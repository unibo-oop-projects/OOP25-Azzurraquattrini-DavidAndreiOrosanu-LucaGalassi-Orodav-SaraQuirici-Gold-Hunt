package it.unibo.goldhunt.view.swing.components;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.AbstractButton;
import javax.swing.Icon;

public class ScaledIcon implements Icon {

    private final Image image;
    private final int padding;

    public ScaledIcon(final Image image, final int padding) {
        this.image = image;
        this.padding = Math.max(0, padding);
    }

    @Override
    public void paintIcon(final Component c, final Graphics g, final int x, final int y) {
        if (image == null) {
            return;
        }

        final Insets in = (c instanceof AbstractButton b)
        ? b.getInsets()
        : new Insets(0, 0, 0, 0);

        final int availW = Math.max(1, c.getWidth()  - in.left - in.right  - 2 * padding);
        final int availH = Math.max(1, c.getHeight() - in.top  - in.bottom - 2 * padding);

        final int size = Math.min(availW, availH);

        final int drawX = in.left + padding + (availW - size) / 2;
        final int drawY = in.top  + padding + (availH - size) / 2;

        final Graphics2D g2 = (Graphics2D) g.create();
        try {
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            g2.drawImage(image, drawX, drawY, size, size, null);

        } finally {
            g2.dispose();
        }
    }

    @Override
    public int getIconWidth() {
        return 16;
    }

    @Override
    public int getIconHeight() {
        return 16;
    }

}
