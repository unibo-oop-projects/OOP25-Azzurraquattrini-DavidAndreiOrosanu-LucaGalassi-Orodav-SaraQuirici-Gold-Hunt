package it.unibo.goldhunt.view.api;

import javax.swing.JComponent;

import it.unibo.goldhunt.items.api.ItemTypes;
import it.unibo.goldhunt.view.viewstate.ShopViewState;

/**
 * Sub-view responsible for rendering the shop section.
 */
public interface ShopView {

    /**
     * Re-renders the shop UI based on the provided immutable snapshot.
     *
     * @param state the shop view state
     * @throws NullPointerException if state is null
     */
    void render(ShopViewState state);

    /**
     * Returns the root Swing component of this sub-view.
     *
     * @return the root component
     */
    JComponent component();

    /**
     * Sets the listener notified when the user interacts with the shop.
     *
     * @param listener the listener
     * @throws NullPointerException if listener is null
     */
    void setListener(Listener listener);

    /**
     * Listener for shop UI actions.
     */
    interface Listener {

        /**
         * Called when the user attempts to buy an item.
         *
         * @param type the item type to buy
         */
        void onBuy(ItemTypes type);

        /**
         * Called when the user requests to leave the shop screen.
         */
        void onLeaveShop();
    }
}
