package it.unibo.goldhunt.items.impl;
//luca
public class Shield extends Item{

    private final static String ITEM_NAME = "Shield";

    @Override
    public String getName() {
        return ITEM_NAME;
    }

    @Override
    public boolean applyEffect() {
        if(trap != null && trap.applyEffect()){
            playerop.addLives(PLUS_LIFE);
            return true;
        }
        return false;
    }

    @Override
    public String shortString() {
        return "S";
    }

}
