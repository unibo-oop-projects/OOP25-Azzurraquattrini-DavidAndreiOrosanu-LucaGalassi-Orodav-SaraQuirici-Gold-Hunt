// AZZU

package it.unibo.goldhunt.board.api;

import it.unibo.goldhunt.engine.api.Position;

public interface RevealStrategy {

    void reveal(Board b, Position p);

}
