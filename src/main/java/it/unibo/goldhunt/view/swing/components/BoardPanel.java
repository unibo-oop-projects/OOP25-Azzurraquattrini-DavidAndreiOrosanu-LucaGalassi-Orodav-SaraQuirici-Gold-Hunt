package it.unibo.goldhunt.view.swing.components;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.swing.JPanel;

import it.unibo.goldhunt.engine.api.Position;
import it.unibo.goldhunt.view.api.GameView;
import it.unibo.goldhunt.view.api.ItemVisualRegistry;
import it.unibo.goldhunt.view.viewstate.GameViewState;

public final class BoardPanel extends JPanel {

    private final ItemVisualRegistry registry;
    private final List<CellButton> viewCells = new ArrayList<>();
    private GameView.Listener listener;
    private int currentSize = -1;

    public BoardPanel(final ItemVisualRegistry registry) {
        this.registry = Objects.requireNonNull(registry);
    }

    public void setListener(final GameView.Listener listener) {
        this.listener = listener;
        viewCells.forEach(b -> b.setListener(listener));
    }

    public void render (final GameViewState state) {
        Objects.requireNonNull(state);

        final int size = state.boardSize();
        if (size <= 0) {
            return;
        }
        if (size != currentSize) {
            rebuildGrid(size);
        }

        final int n = Math.min(viewCells.size(), state.cells().size());
        for (int i = 0; i < n ; i++) {
            viewCells.get(i).render(state.cells().get(i));
        }

        revalidate();
        repaint();
    }

    private void rebuildGrid(final int size) {
        removeAll();
        viewCells.clear();

        setLayout(new GridLayout(size, size,0, 0));

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                final CellButton cellButton = new CellButton(new Position(x, y), registry);
                if (listener != null) {
                    cellButton.setListener(listener);
                }
                viewCells.add(cellButton);
                add(cellButton);
            }
        }

        currentSize = size;
    }
}
