package it.unibo.goldhunt.view.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.ImageIcon;

import it.unibo.goldhunt.view.api.ItemVisualRegistry;

public class ItemRegistry implements ItemVisualRegistry {

    private final Map<String, String> glyphMap = new HashMap<>();
    private final Map<String, String> tooltipMap = new HashMap<>();
    private final Map<String, String> stylekeyMap = new HashMap<>();
    private final Map<String, ImageIcon> iconMap = new HashMap<>();

    public ItemRegistry() {
        glyphMap.put("M", "M");
        tooltipMap.put("M", "Chart");
        stylekeyMap.put("M", "chart-style");
        iconMap.put("M", new ImageIcon(getClass().getResource("/map.png")));
        if (getClass().getResource("/gold.png") == null) {
        System.err.println("gold.png not found");
        }


        glyphMap.put("D", "D");
        tooltipMap.put("D", "Dynamite");
        stylekeyMap.put("D", "dynamite-style");
        iconMap.put("D", new ImageIcon(getClass().getResource("/dynamite.png")));

        glyphMap.put("G", "G");
        tooltipMap.put("G", "Gold");
        stylekeyMap.put("G", "gold-style");
        iconMap.put("G", new ImageIcon(getClass().getResource("/gold.png")));

        glyphMap.put("L", "L");
        tooltipMap.put("L", "Life");
        stylekeyMap.put("L", "life-style");
        iconMap.put("L", new ImageIcon(getClass().getResource("/life.png")));

        glyphMap.put("C", "C");
        tooltipMap.put("C", "Lucky Clover");
        stylekeyMap.put("C", "clover-style");
        iconMap.put("C", new ImageIcon(getClass().getResource("/luckyClover.png")));

        glyphMap.put("P", "P");
        tooltipMap.put("P", "Pickaxe");
        stylekeyMap.put("P", "pickaxe-style");
        iconMap.put("P", new ImageIcon(getClass().getResource("/pickaxe.png")));

        glyphMap.put("S", "S");
        tooltipMap.put("S", "Shield");
        stylekeyMap.put("S", "shield-style");
        iconMap.put("S", new ImageIcon(getClass().getResource("/shield.png")));

        glyphMap.put("X", "X");
        tooltipMap.put("X", "Gold x3");
        stylekeyMap.put("X", "goldx3-style");
        iconMap.put("X", new ImageIcon(getClass().getResource("/goldX3.png")));

        glyphMap.put("T", "T");
        tooltipMap.put("T", "Trap");
        stylekeyMap.put("T", "trap-style");
        iconMap.put("T", new ImageIcon(getClass().getResource("/trap.png")));
    }

    @Override
    public String getGlyph(String getContentID) {
        return glyphMap.get(getContentID);
    }

    @Override
    public String getTooltip(String contentID) {
        return tooltipMap.get(contentID);
    }

    @Override
    public String getStyleKey(String contentID) {
        return stylekeyMap.get(contentID);
    }

    @Override
    public ImageIcon getIcon(String id) {
        return iconMap.get(id);
    }

    public Set<String> getAllItemsID(){
        return glyphMap.keySet();
    }
}
