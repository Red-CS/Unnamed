package com.unnamed.game.states;

import java.awt.Graphics2D;
import java.util.ArrayList;
import com.unnamed.game.GamePanel;
import com.unnamed.game.util.KeyHandler;
import com.unnamed.game.util.MouseHandler;
import com.unnamed.game.util.Vector2D;

/**
 * @version GameStateManager Class
 * @author Red Williams (Red-CS)
 * @version 05-30-2021
 */
public class GameStateManager {

    private ArrayList<GameState> states;

    public static Vector2D map;

    /**
     * GameStateManager Constructor
     */
    public GameStateManager() {
        states = new ArrayList<GameState>();
        states.add(new PlayState(this));

        map = new Vector2D(GamePanel.PANEL_WIDTH, GamePanel.PANEL_HEIGHT);
        Vector2D.setWorldVar(map.x, map.y);
    }


    public void update() {
        Vector2D.setWorldVar(map.x, map.y);
        for (int i = 0; i < states.size(); i++) {
            states.get(i).update();
        }
    }


    public void input(MouseHandler mouse, KeyHandler key) {
        for (int i = 0; i < states.size(); i++) {
            states.get(i).input(mouse, key);
        }
    }


    public void render(Graphics2D g) {
        for (int i = 0; i < states.size(); i++) {
            states.get(i).render(g);
        }
    }
}
