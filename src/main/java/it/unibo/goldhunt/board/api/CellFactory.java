// AZZU

package it.unibo.goldhunt.board.api;

import java.util.Optional;

public interface CellFactory {

    Cell createCell();

    Cell createCell(Optional<CellContent> content);
}
