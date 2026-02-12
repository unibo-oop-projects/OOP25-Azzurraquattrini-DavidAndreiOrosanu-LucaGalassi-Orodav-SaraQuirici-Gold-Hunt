package it.unibo.goldhunt.view.api;

import javax.swing.ImageIcon;

public interface ItemVisualRegistry {

    String getGlyph(final String getContentID);

    String getTooltip(final String contentID);

    String getStyleKey(final String contentID);

    ImageIcon getIcon(String id);
}
