package it.unibo.goldhunt.items.impl;

import it.unibo.goldhunt.items.api.CellContent;
import it.unibo.goldhunt.player.api.PlayerOperations;

//luca
public class Trap implements CellContent{

    PlayerOperations playerop;
    public static final int DAMAGE = -1;

    @Override
    public boolean applyEffect() {
        playerop.addLives(DAMAGE);
        return true;
    }

    @Override
    public String shortString() {
        return "T";
    }

    
}
