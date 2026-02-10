package it.unibo.goldhunt.items.api;

import it.unibo.goldhunt.player.api.PlayerOperations;

public enum KindOfItem implements ItemTypes{
    CHART("Map"),
    DYNAMITE("Dynamite"),
    PICKAXE("Pickaxe"),
    LUCKYCLOVER("Lucky Clover"),
    LIVES("Life"),
    GOLDX3("Gold x3"),
    GOLD("Gold"),
    SHIELD("Shield");

    private final String itemName;

    KindOfItem(String itemName){
        this.itemName = itemName;
    }

    public String getName(){
        return itemName;
    }

    @Override
    public PlayerOperations applyEffect(PlayerOperations playerop) {
        return playerop;
    }

    @Override
    public String shortString() {
        return this.name();
    }

    @Override
    public KindOfItem getItem() {
        return this;
    }
}
