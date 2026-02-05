package it.unibo.goldhunt.items.impl;

import it.unibo.goldhunt.board.api.Cell;

//luca
public class Dynamite extends Item{

    private final static String ITEM_NAME = "Dynamite";
    


    @Override
    public String getName() {
        return ITEM_NAME;
    }

    @Override
    public boolean applyEffect() {
        var cells = board.getAdjacentCells(player.position());
        cells.stream()
        .filter(Cell::hasContent)
        .map(Cell::getContent)
        .forEach();
        }
        

    @Override
    public String shortString() {
        return "D";
    }

}
