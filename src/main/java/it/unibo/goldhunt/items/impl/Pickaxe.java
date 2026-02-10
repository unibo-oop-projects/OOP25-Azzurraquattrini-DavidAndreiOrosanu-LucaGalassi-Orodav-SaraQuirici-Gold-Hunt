package it.unibo.goldhunt.items.impl;
import java.util.List;
//luca
import java.util.Random;

import it.unibo.goldhunt.board.api.Cell;
import it.unibo.goldhunt.items.api.ClearCells;
import it.unibo.goldhunt.items.api.KindOfItem;
import it.unibo.goldhunt.player.api.PlayerOperations;

public class Pickaxe extends Item implements ClearCells{

    private final static String ITEM_NAME = "Pickaxe";
    
    @Override
    public String getName() {
        return ITEM_NAME;
    }

    @Override
    public PlayerOperations applyEffect(PlayerOperations playerop) {
        if(context == null){
            throw new IllegalStateException("cannot bind items");
        }

        var board = context.board();
        Random random = new Random();
        int idx = random.nextInt(board.getBoardSize());
        List<Cell> cells = random.nextBoolean() 
        ? board.getRow(idx) 
        : board.getColumn(idx);

        disarm(cells);
        return playerop;
    }

    @Override
    public String shortString() {
        return "P";
    }

    @Override
    public KindOfItem getItem() {
        return KindOfItem.PICKAXE;
    }

}
