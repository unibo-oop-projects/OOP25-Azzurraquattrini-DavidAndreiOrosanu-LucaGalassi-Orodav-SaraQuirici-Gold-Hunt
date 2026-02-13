package it.unibo.goldhunt.view.swing.components;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import it.unibo.goldhunt.view.api.InventoryView;
import it.unibo.goldhunt.view.viewstate.InventoryItemViewState;
import it.unibo.goldhunt.view.viewstate.InventoryViewState;

/**
 * Swing implementation of {@link InventoryView}.
 */
public class InventoryPanel implements InventoryView{

    private final JPanel root;
    private final JPanel itemsPanel;
    private Listener listener;

    public InventoryPanel() {
        this.root = new JPanel(new BorderLayout());
        this.root.setBorder(new TitledBorder("Inventory"));
        this.itemsPanel = new JPanel(new GridLayout(0, 4, 5, 5));
        final JScrollPane scroll = new JScrollPane(itemsPanel);
        scroll.setBorder(null);
        this.root.add(scroll, BorderLayout.CENTER);
    }

    @Override
    public void render(final InventoryViewState state) {
        Objects.requireNonNull(state, "state can't be null");
        itemsPanel.removeAll();;
        for (final InventoryItemViewState item : state.items()) {
            itemsPanel.add(buildButton(item));
        }
        itemsPanel.revalidate();
        itemsPanel.repaint();
    }

    @Override
    public JComponent component() {
        return root;
    }

    @Override
    public void setListener(final Listener listener) {
        this.listener = Objects.requireNonNull(listener, "listener can't be null");
    }

    private JButton buildButton(final InventoryItemViewState item) {
        final String label = item.name() + " x" + item.quantity();
        final JButton button = new JButton(label);
        button.setFocusable(false);
        button.setEnabled(item.usable());
        button.addActionListener(e -> {
            if (item.usable()) {
                listener.onUseItem(item.type());
            }
        });
        return button;
    }
}
