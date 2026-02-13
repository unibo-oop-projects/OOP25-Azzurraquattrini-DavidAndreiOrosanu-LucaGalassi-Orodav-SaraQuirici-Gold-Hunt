package it.unibo.goldhunt.view.api;

import javax.swing.JComponent;

import it.unibo.goldhunt.engine.api.Position;
import it.unibo.goldhunt.items.api.ItemTypes;
import it.unibo.goldhunt.view.viewstate.GameViewState;

public interface GameView {

    void render(GameViewState state);
    JComponent component();
    void setListener(Listener listener);
    interface Listener {
        void onReveal(Position p);
        void onToggleFlag(Position p);
        void onBuy(ItemTypes t);
        void onLeaveShop();
        void onUseItem(ItemTypes t);
        void onStartGame(); // menu/difficulty ecc
    }
}
