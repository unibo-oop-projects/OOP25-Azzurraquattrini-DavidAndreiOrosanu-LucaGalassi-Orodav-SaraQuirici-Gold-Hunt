package it.unibo.goldhunt.engine.api;

import it.unibo.goldhunt.player.api.Player;
import it.unibo.goldhunt.shop.api.Shop;

import java.util.Optional;

import it.unibo.goldhunt.board.api.ReadOnlyBoard;

/**
 * Represents an immutable snapshot.
 */
public interface GameState {

    ReadOnlyBoard board();

    Player player();

    Status status();

    Optional<Shop> shop();
}
