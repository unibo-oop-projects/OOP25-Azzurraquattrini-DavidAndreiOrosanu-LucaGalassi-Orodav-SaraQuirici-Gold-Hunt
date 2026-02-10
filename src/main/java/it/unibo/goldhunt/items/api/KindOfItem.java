package it.unibo.goldhunt.items.api;

public enum KindOfItem {
    CHART("Map"),
    DYNAMITE("Dynamite"),
    PICKAXE("Pickaxe"),
    SHIELD("Shield");

    private final String itemName;

    KindOfItem(String itemName){
        this.itemName = itemName;
    }

    public String getName(){
        return itemName;
    }
}
