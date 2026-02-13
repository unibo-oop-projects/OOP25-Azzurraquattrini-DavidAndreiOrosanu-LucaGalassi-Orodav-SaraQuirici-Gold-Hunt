package it.unibo.goldhunt.view.api;

import javax.swing.JComponent;

import it.unibo.goldhunt.view.viewstate.HudViewState;

/**
 * Sub-view responsible for rendering the HUD (level, lives, gold, etc.).
 */
public interface HudView {

    /**
     * Re-renders the HUD based on the provided immutable snapshot.
     *
     * @param state the hud view state
     */
    void render(HudViewState state);

    /**
     * Returns the root Swing component of this sub-view.
     *
     * @return the root component
     */
    JComponent component();
}
