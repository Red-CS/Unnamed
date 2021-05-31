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

    public static final int PLAY = 0;

    public static final int MENU = 1;

    public static final int PAUSE = 2;

    public static final int GAMEOVER = 3;

    /**
     * GameStateManager Constructor
     */
    public GameStateManager() {
        states = new ArrayList<GameState>();
        states.add(new PlayState(this));

        map = new Vector2D(GamePanel.PANEL_WIDTH, GamePanel.PANEL_HEIGHT);
        Vector2D.setWorldVar(map.x, map.y);
    }


    /**
     * @param state
     */
    public void pop(int state) {
        states.remove(state);
    }


    public void add(int state) {
        if (state == PLAY) {
            states.add(new PlayState(this));
        }
        if (state == MENU) {
            states.add(new MenuState(this));
        }
        if (state == PAUSE) {
            states.add(new PauseState(this));
        }
        if (state == GAMEOVER) {
            states.add(new GameOverState(this));
        }
    }


    /**
     * @param state
     */
    public void addAndPop(int state) {
        states.remove(0);
        add(state);
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
