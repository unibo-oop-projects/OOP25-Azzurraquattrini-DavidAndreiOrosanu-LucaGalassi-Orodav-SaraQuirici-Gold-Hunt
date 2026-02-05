package it.unibo.goldhunt.items.impl;
//luca
public class GoldX3 extends Item {

    public static final String ITEM_NAME = "Gold x3";

    @Override
    public boolean applyEffect(){

        inventory.add(gold, ADDED_GOLDX3);
        return true;
    }

    @Override
    public String shortString(){
        return "X";
    }

    @Override
    public String getName() {
        return ITEM_NAME;
    }

}
