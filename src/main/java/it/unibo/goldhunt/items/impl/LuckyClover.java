package it.unibo.goldhunt.items.impl;

import it.unibo.goldhunt.items.api.KindOfItem;
import it.unibo.goldhunt.player.api.PlayerOperations;

public class LuckyClover extends Item{

    private final static String ITEM_NAME = "Lucky clover";

    @Override
    public String getName() {
        return ITEM_NAME;
    }

    @Override
    public PlayerOperations applyEffect(PlayerOperations playerop) {
        if(playerop == null){
            throw new IllegalArgumentException();
        }

        if(context == null){
            throw new IllegalArgumentException();
        }
        playerop.addItem(getItem(), MAX_QUANTITY_CLOVER);
        return playerop;
    }

    @Override
    public String shortString() {
        return "C";
    }

    @Override
    public KindOfItem getItem() {
        return KindOfItem.LUCKYCLOVER;
    }

}