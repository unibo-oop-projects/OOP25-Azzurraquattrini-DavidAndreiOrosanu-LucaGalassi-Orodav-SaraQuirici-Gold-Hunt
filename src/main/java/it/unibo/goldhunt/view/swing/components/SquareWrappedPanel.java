package it.unibo.goldhunt.view.swing.components;

import java.awt.Dimension;
import javax.swing.JPanel;

public class SquareWrappedPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    public SquareWrappedPanel() {
        super(null);
    }

    @Override
    public void doLayout() {
        if (getComponentCount() == 0) {
            return;
        }

        var panel = getComponent(0);

        int width = getWidth();
        int height = getHeight();
        int maxSize = Math.min(width, height);
        int x = (width - maxSize) / 2;
        int y = (height - maxSize) / 2;

        panel.setBounds(x, y, maxSize, maxSize);
    }

    @Override
    public Dimension getPreferredSize() {
        return super.getPreferredSize();
    }

    public void setContent(final JPanel content) {
        removeAll();
        add(content);
        revalidate();
        repaint();
    }

}
