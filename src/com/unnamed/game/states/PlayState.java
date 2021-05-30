package com.unnamed.game.states;

import java.awt.Color;
import java.awt.Graphics2D;
import com.unnamed.game.util.KeyHandler;
import com.unnamed.game.util.MouseHandler;

/**
 * @version PlayState Class
 * @author Red Williams (Red-CS)
 * @version 05-30-2021
 */
public class PlayState extends GameState {

    public PlayState(GameStateManager gsm) {
        super(gsm);
    }


    /**
     * 
     */
    @Override
    public void update() {
        // TODO Auto-generated method stub

    }


    /**
     * @param mouse
     * @param key
     */
    @Override
    public void input(MouseHandler mouse, KeyHandler key) {
        if (key.up.down) {
            System.out.println("W pressed");
        }

    }


    /**
     * @param g
     */
    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.magenta);
        g.fillRect(100, 100, 64, 64);

    }

}
