package it.unibo.goldhunt.items.impl;

public class LuckyClover extends Item{

    private final static boolean consumable = false;
    private final static String ITEM_NAME = "Lucky clover";
    Gold gold;
    private boolean usage = false;

    @Override
    public String getName() {
        return ITEM_NAME;
    }

    @Override
    public boolean applyEffect() {
        player.setMultiplier(2);
    }

    @Override
    public String shortString() {
        return "C";
    }

}
