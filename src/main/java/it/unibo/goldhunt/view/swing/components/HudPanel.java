package it.unibo.goldhunt.view.swing.components;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Objects;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import it.unibo.goldhunt.view.api.HudView;
import it.unibo.goldhunt.view.viewstate.HudViewState;

/**
 * Swing HUD panel: displays basic player/session info (level, lives, gold).
 */
public final class HudPanel implements HudView {

    private final JPanel root;
    private final JLabel levelLabel;
    private final JLabel livesLabel;
    private final JLabel goldLabel;

    public HudPanel() {
        this.root = new JPanel(new BorderLayout());
        this.root.setBorder(new EmptyBorder(6, 8, 6, 8));
        final JPanel stats = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 0));
        this.levelLabel = new JLabel("Level: -");
        this.livesLabel = new JLabel("Lives: -");
        this.goldLabel = new JLabel("Gold: 0");
        stats.add(levelLabel);
        stats.add(livesLabel);
        stats.add(goldLabel);
        root.add(stats, BorderLayout.WEST);
    }
    @Override
    public void render(HudViewState state) {
        Objects.requireNonNull(state, "state can't be null");
        levelLabel.setText("Level: " + state.levelNumber());
        livesLabel.setText("Lives: " + state.lives());
        goldLabel.setText("Gold: " + state.gold());
    }

    @Override
    public JComponent component() {
        return root;
    }
}
