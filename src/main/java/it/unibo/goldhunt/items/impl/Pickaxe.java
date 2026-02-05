package it.unibo.goldhunt.items.impl;
//luca
import java.util.Random;

public class Pickaxe extends Item{

    private final static String ITEM_NAME = "Pickaxe";
    
    @Override
    public String getName() {
        return ITEM_NAME;
    }

    @Override
    public boolean applyEffect() {
        Random random = new Random();
        random.
    }

    @Override
    public String shortString() {
        return "P";
    }

    @Override
    public boolean isConsumable() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isConsumable'");
    }
}