// AZZU

package it.unibo.goldhunt.view.api;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public interface UIFactory {

    JFrame createFrame(String title);

    JPanel createRootPanel();

    JPanel createScreenPanel(String screenID);      
    JPanel createBarPanel();         
    JPanel createBoardPanel(int boardSize);   // board

    JLabel createLabel(String text);

    JButton createButton(String text, Runnable onClick);
    JButton createTileButton();      // cell per la board
}

