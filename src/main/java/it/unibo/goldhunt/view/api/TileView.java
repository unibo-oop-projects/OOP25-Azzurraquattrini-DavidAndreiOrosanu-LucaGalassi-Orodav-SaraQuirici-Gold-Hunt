package it.unibo.goldhunt.view.api;

import javax.swing.Icon;
import javax.swing.JComponent;

public interface TileView {

    JComponent getComponent();   // quello che va messo nella griglia

    void setBaseText(String text);     // numero/trappola
    void setOverlayIcon(Icon icon);    // player, item, flag
    void clearOverlay();

    void setCovered(boolean covered);  // opzionale
}
