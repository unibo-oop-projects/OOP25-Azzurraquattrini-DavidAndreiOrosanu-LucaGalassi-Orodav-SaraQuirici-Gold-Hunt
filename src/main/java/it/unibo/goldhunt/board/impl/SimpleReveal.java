// AZZU

package it.unibo.goldhunt.board.impl;

import java.util.Objects;

import it.unibo.goldhunt.board.api.Board;
import it.unibo.goldhunt.board.api.RevealStrategy;
import it.unibo.goldhunt.engine.api.Position;

public class SimpleReveal implements RevealStrategy {

    /**
     * {@inheritDoc}
     */
    @Override
    public void reveal(Board b, Position p) {
        Objects.requireNonNull(b);
        b.getCell(p).reveal();
    }

}
