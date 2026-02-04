package it.unibo.goldhunt.player.api;

import it.unibo.goldhunt.engine.api.Position;

public interface PlayerOperations extends Player{

    PlayerOperations moveTo(Position p);

    PlayerOperations addGold(int num);

    PlayerOperations addLives(int num);

    PlayerOperations addItem(Item item, int quantity);

    PlayerOperations useItem(Item item, int quantity);
}
