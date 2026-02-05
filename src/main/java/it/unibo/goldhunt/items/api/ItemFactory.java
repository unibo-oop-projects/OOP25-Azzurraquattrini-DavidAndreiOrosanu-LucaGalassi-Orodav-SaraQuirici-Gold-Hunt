
package it.unibo.goldhunt.items.api;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import it.unibo.goldhunt.items.impl.Chart;
import it.unibo.goldhunt.items.impl.Dynamite;
import it.unibo.goldhunt.items.impl.Gold;
import it.unibo.goldhunt.items.impl.Lifes;
import it.unibo.goldhunt.items.impl.LuckyClover;
import it.unibo.goldhunt.items.impl.Pickaxe;
import it.unibo.goldhunt.items.impl.Shield;


public class ItemFactory {

    private final static Map<String, Supplier<Item>> ITEMS = new HashMap<>();


    static{
        ITEMS.put("M", Chart::new);
        ITEMS.put("D", Dynamite::new);
        ITEMS.put("G", Gold::new);
        ITEMS.put("L", Lifes::new);
        ITEMS.put("C", LuckyClover::new);
        ITEMS.put("P", Pickaxe::new);
        ITEMS.put("S", Shield::new);

    }

    public Item generateItem(final String item){
        Supplier<Item> constructor = ITEMS.get(item);

        if(constructor == null){
            throw new IllegalArgumentException();
        }
        return constructor.get();
    }


}

