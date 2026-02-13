package it.unibo.goldhunt.view.swing.screens;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import it.unibo.goldhunt.items.api.ItemTypes;
import it.unibo.goldhunt.view.api.ShopView;
import it.unibo.goldhunt.view.viewstate.ShopItemViewState;
import it.unibo.goldhunt.view.viewstate.ShopViewState;

public class ShopPanel implements ShopView{

    private final JPanel root;
    private final JLabel remainingLabel;
    private final JPanel itemsPanel;
    private final JButton leaveButton;

    private Listener listener = new Listener() {

        @Override
        public void onBuy(final ItemTypes type) { }

        @Override
        public void onLeaveShop() { }
    };

    public ShopPanel() {
        this.root = new JPanel(new BorderLayout());
        this.root.setBorder(new TitledBorder("Shop"));
        final JPanel topBar = new JPanel(new BorderLayout());
        this.remainingLabel = new JLabel("Remaining purchases: 0");
        final JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        this.leaveButton = new JButton("Leave shop");
        this.leaveButton.setFocusable(false);
        this.leaveButton.addActionListener(e -> listener.onLeaveShop());
        right.add(leaveButton);
        topBar.add(remainingLabel, BorderLayout.WEST);
        topBar.add(right, BorderLayout.EAST);
        this.itemsPanel = new JPanel(new GridLayout(0, 3, 8, 8));
        final JScrollPane scroll = new JScrollPane(itemsPanel);
        scroll.setBorder(null);
        root.add(topBar, BorderLayout.NORTH);
        root.add(scroll, BorderLayout.CENTER);
    }
    @Override
    public void render(ShopViewState state) {
        Objects.requireNonNull(state, "state can't be null");
        remainingLabel.setText("Remaining purchases: " + state.remainingPurchases());
        itemsPanel.removeAll();
        for (final ShopItemViewState item : state.items()) {
            itemsPanel.add(buildBuyButton(item));
        }
        itemsPanel.revalidate();
        itemsPanel.repaint();
    }

    @Override
    public JComponent component() {
        return root;
    }

    @Override
    public void setListener(Listener listener) {
        this.listener = Objects.requireNonNull(listener, "listener can't be null");
    }

    private JButton buildBuyButton(final ShopItemViewState item) {
        final String label = item.name() + " /" + item.price() + "g";
        final JButton b = new JButton(label);
        b.setFocusable(false);
        b.setEnabled(item.enabled());
        if (!item.enabled()) {
            if (!item.affordable()) {
                b.setToolTipText("Not enough gold");
            } else {
                b.setToolTipText("No remaining purchases");
            }
        } else {
            b.setToolTipText(null);
        }
        b.addActionListener(e -> {
            if (item.enabled()) {
                listener.onBuy(item.type());
            }
        });
        return b;
    }
}

