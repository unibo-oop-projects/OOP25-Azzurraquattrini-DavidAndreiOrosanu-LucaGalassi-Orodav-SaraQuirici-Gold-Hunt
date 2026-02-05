package it.unibo.goldhunt.board.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.goldhunt.board.api.Cell;
import it.unibo.goldhunt.board.api.CellFactory;

public class BaseCellTest {
    
    private CellFactory factory;
    private Cell cell;

    @BeforeEach
    void init() {
        this.factory = new BaseCellFactory();
        this.cell = this.factory.createCell();
    }

    /**
     * Tests that a cell is revealed when it is not flagged.
     */
    @Test
    void testRevealWhenNotFlagged() {
        cell.reveal();
        assertTrue(cell.isRevealed());
        assertFalse(cell.isFlagged());
    }
    
    /**
     * Tests that a revealed cell remains revealed if revealed more than once.
     */
    @Test
    void testRevealWhenAlreadyRevealed() {
        cell.reveal();
        cell.reveal();
        assertTrue(cell.isRevealed());
    }

    /**
     * Tests that a flagged cell cannot be revealed.
     */
    @Test
    void testRevealWhenFlagged() {
        cell.toggleFlag();
        cell.reveal();
        assertFalse(cell.isRevealed());
        assertTrue(cell.isFlagged());
    }

    /**
     * Tests that a non-revealed and unflagged cell can be flagged.
     */
    @Test
    void testToggleFlagWhenNotFlagged() {
        cell.toggleFlag();
        assertFalse(cell.isRevealed());
        assertTrue(cell.isFlagged());
    }

    /**
     * Tests that a flagged cell can be unflagged.
     */
    @Test
    void testToggleFlagWhenFlagged() {
        cell.toggleFlag();
        cell.toggleFlag();
        assertFalse(cell.isRevealed());
        assertFalse(cell.isFlagged());
    }

    /**
     * Tests that a revealed cell cannot be flagged.
     */
    @Test
    void testToggleFlagWhenRevealed() {
        cell.reveal();
        cell.toggleFlag();
        assertFalse(cell.isFlagged());
    }

    /**
     * Tests that the number of adjacent cells is between 0 and 8 inclusive
     */
    @Test
    void testSetAdjacentTraps() {
        cell.setAdjacentTraps(0);
        assertEquals(0, cell.getAdjacentTraps());
        cell.setAdjacentTraps(1);
        assertEquals(1, cell.getAdjacentTraps());
        cell.setAdjacentTraps(8);
        assertEquals(8, cell.getAdjacentTraps());
        assertThrows(IllegalArgumentException.class, () -> cell.setAdjacentTraps(-1));
        assertThrows(IllegalArgumentException.class, () -> cell.setAdjacentTraps(9));
    }

}
