//SARA
package it.unibo.goldhunt.configuration.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import it.unibo.goldhunt.board.api.Board;
import it.unibo.goldhunt.board.api.BoardFactory;
import it.unibo.goldhunt.board.api.Cell;
import it.unibo.goldhunt.configuration.api.BoardGenerator;
import it.unibo.goldhunt.configuration.api.LevelConfig;
import it.unibo.goldhunt.engine.api.Position;
import it.unibo.goldhunt.items.api.ItemFactory;
import it.unibo.goldhunt.items.api.TrapFactory;
import it.unibo.goldhunt.items.api.CellContent;

/**
 * This class is the implementation of BoardGenerator.
 */
public class BoardGeneratorImpl implements BoardGenerator {
    
    private final BoardFactory boardFactory;
    private final TrapFactory trapFactory;
    private final ItemFactory itemFactory;
    
    /**
     * Creates a new {@code BoardGeneratorImpl}.
     * 
     * @param boardFactory the factory used to create board cells
     * @param itemFactory the factory used to create items placed on the board
     */
    public BoardGeneratorImpl(BoardFactory boardFactory, TrapFactory trapFactory, ItemFactory itemFactory) {
        this.boardFactory = boardFactory;
        this.trapFactory = trapFactory;
        this.itemFactory = itemFactory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Board generate(LevelConfig config, Position start, Position exit) {
        Objects.requireNonNull(config);
        Objects.requireNonNull(start);
        Objects.requireNonNull(exit);

        final Board board = boardFactory.createEmptyBoard(config.getBoardSize());

        final Set<Cell> safePath = computeSafePath(board, start, exit);

        final Set<Cell> occupiedCells = new HashSet<>(safePath);

        placeTraps(board, occupiedCells, config);
        placeItems(board, occupiedCells, config);

        computeAdjacentTraps(board);

        return board;
    }
    
    /**
     * Computes a safe path by using a DFS algorithm and stores it 
     * in a {@link Set} of {@link Cell}.
     * 
     * @param board the board on which the safepath is computed
     * @param start the starting position of the algorithm
     * @param exit the ending position of the algorithm
     * @return a {@link Set} containing all cells belonging to the safe path
     * @throws IllegalStateException if no safe path can be found
     */
    private Set<Cell> computeSafePath(final Board board, final Position start, final Position exit) {
        
        final Set<Cell> safePath = new HashSet<>();
        
        if (!dfs(board, start, exit, safePath)) {
            throw new IllegalStateException("No safe path could be computed");
        }
        
        return safePath;
    }

    /**
     * Recursive implementation of the DFS algorithm used to compute a safe path.
     * Starting from the current position, the method adds the corresponding cell to the safe path,
     * then explores adjacent cells in random order until the exit position is reached.
     * If a dead end is encountered, backtracking is performed by removing the current cell
     * from the safe path.
     * 
     * @param board the board on which the search is performed
     * @param current the current position explored by the algorithm
     * @param exit the target exit position
     * @param safePath the {@link Set} collecting the cells of the safe path
     * @return true if a path to the exit has been found, false otherwise
     */
    private boolean dfs(final Board board, final Position current, final Position exit, final Set<Cell> safePath) {
        
        final Cell currentCell = board.getCell(current);
        safePath.add(currentCell);

        if (current.equals(exit)) {             
            return true;
        }

        final List<Cell> neighbors = new ArrayList<>(board.getAdjacentCells(current));
        Collections.shuffle(neighbors);

        for (final Cell neighbor : neighbors) {
            if (!safePath.contains(neighbor)) {
                final Position neighborPos = board.getCellPosition(neighbor);
                if (dfs(board, neighborPos, exit, safePath)) {
                    return true;
                }
            }
        }

        safePath.remove(currentCell);           
        return false;    
    }

    /**
     * Returns the cells that are not yet occupied.
     * 
     * @param board
     * @param safePath
     * @return
     */
    private List<Cell> getAvailableCells(final Board board, final Set<Cell> occupiedCells) {
        return board.getBoardCells().stream().filter(cell -> !occupiedCells.contains(cell)).toList();
    }


    /**
     * Places traps randomly on the board, avoiding the cells of the safe path.
     * 
     * @param board the board on which traps are placed
     * @param safePath the {@link Set} of {@link Cell} that must remain trap-free
     * @param config the level configuration providing the number of traps
     */
    private void placeTraps(final Board board, final Set<Cell> occupiedCells, final LevelConfig config) {
        
        final List<Cell> availableCells = new ArrayList<>(getAvailableCells(board, occupiedCells));
    
        Collections.shuffle(availableCells);

        int trapCount = config.getTrapCount();

        if (trapCount > availableCells.size()) {
            throw new IllegalStateException("Not enough free cells for traps");
        }

        for (int i = 0; i < trapCount; i++) {
            final Cell cell = availableCells.get(i);
            cell.setContent(trapFactory.createTrap());
            occupiedCells.add(cell);
        }
    }

    /**
     * Places items randomly on the board, avoiding the cells of the safe path.
     *  
     * @param board the board on which items are places
     * @param safePath the {@link Set} of {@link Cell} that must remain trap-free
     * @param config the level configuration providing the number of traps
     */
    private void placeItems(final Board board, final Set<Cell> occupiedCells, final LevelConfig config) {
        
        final List<Cell> availableCells = new ArrayList<>(getAvailableCells(board, occupiedCells));

        Collections.shuffle(availableCells);

        Map<String, Integer> items = config.getItemConfig();

        int index = 0;
        for (final Map.Entry<String, Integer> entry : items.entrySet()) {
            String symbol = entry.getKey();
            int quantity = entry.getValue();
            
            for (int i = 0; i < quantity; i++) {
                if (index >= availableCells.size()) {
                    throw new IllegalStateException("Not enough free cells for items");
                }

                final Cell cell = availableCells.get(index);
                final CellContent content = itemFactory.generateItem(symbol);
                cell.setContent(content);
                occupiedCells.add(cell);
                index++;
            }
        }
    }

    /**
     * Computes the number of adjacent traps for each cell on the board.
     * 
     * @param board the board on which adjacent traps are computed
     */
    private void computeAdjacentTraps(final Board board) {
        
        for (final Cell cell : board.getBoardCells()) {
            int count = 0;
        
            for (final Cell neighbor : board.getAdjacentCells(board.getCellPosition(cell))) {
                if (neighbor.hasContent() && neighbor.getContent().get().isTrap()) {
                    count++;
                }
            }

            cell.setAdjacentTraps(count);
        }
    } 
}

