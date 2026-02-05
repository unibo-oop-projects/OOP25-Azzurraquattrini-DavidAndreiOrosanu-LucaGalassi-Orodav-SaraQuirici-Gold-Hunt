package it.unibo.goldhunt.items.impl;

import java.util.List;

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

        List<Cell> adjacent = board.getAdjacentCells(player.position());
        if(adjacent == null || adjacent.isEmpty()){
            throw new IllegalStateException("no cells nearby");
        }

        adjacent.stream()
        .filter(Cell::hasContent)
        .forEach(cell -> cell.getContent()
        .filter(i-> i instanceof Trap)
        .ifPresent(c->cell.removeContent()));

        adjacent.forEach(Cell::reveal);

        return true;
        }
        

    @Override
    public String shortString() {
        return "D";
    }

}
