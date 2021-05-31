package com.unnamed.game;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Window extends JFrame {

    private static final String GAME_TITLE = "Unnamed";

    public Window() {
        setTitle(GAME_TITLE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(new GamePanel(GamePanel.PANEL_WIDTH,
            GamePanel.PANEL_HEIGHT));
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
