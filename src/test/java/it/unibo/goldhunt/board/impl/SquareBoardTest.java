// AZZU

package it.unibo.goldhunt.board.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.goldhunt.board.api.Board;
import it.unibo.goldhunt.board.api.Cell;
import it.unibo.goldhunt.board.api.CellFactory;
import it.unibo.goldhunt.engine.api.Position;

public final class SquareBoardTest {

    private Board board;
    private CellFactory factory;
    private Cell[][] cells;

    @BeforeEach
    void init() {
        this.board = new TestableSquareBoard(3);
        this.factory = new BaseCellFactory();
        this.cells = new Cell[3][3];
        fillBoard();
    }

    /**
     * Tests that SquareBoard.getBoardCells() returns 
     * a list with all of the board's cells
     */
    @Test
    void testGetBoardCells() {
        List<Cell> list = this.board.getBoardCells();
        assertEquals(9, list.size());
        assertTrue(list.containsAll(List.of(
            cells[0][0], cells[0][1], cells[0][2],
            cells[1][0], cells[1][1], cells[1][2],
            cells[2][0], cells[2][1], cells[2][2] )));
    }

    private void fillBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final Cell c = factory.createCell();
                this.board.setCell(c, new Position(i, j));
                cells[i][j] = c;
            }
        }
    }

    static class TestableSquareBoard extends SquareBoard {
        TestableSquareBoard(final int boardSize) {
            super(boardSize);
        }
    }
}
