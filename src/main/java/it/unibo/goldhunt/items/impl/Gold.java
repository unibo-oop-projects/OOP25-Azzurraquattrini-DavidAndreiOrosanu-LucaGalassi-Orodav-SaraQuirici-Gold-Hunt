package it.unibo.goldhunt.items.impl;

//luca
public class Gold extends Item{

    public static final String ITEM_NAME = "Gold";

    @Override
    public String getName() {
        return ITEM_NAME;
    }

    @Override
    public boolean applyEffect() {
        inventory.add(gold, ADDED_GOLD);
        return true;
    }

    @Override
    public String shortString() {
        return "G";
    }

}
