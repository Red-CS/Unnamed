package com.unnamed.game;

import javax.swing.JFrame;

public class Window extends JFrame {
    
    private static final String GAME_TITLE = "Unnamed";
    
    public Window() {
        setTitle(GAME_TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new GamePanel(GamePanel.PANEL_WIDTH, GamePanel.PANEL_HEIGHT));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
