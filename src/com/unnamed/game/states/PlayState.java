package com.unnamed.game.states;

import java.awt.Graphics2D;
import com.unnamed.game.graphics.Font;
import com.unnamed.game.graphics.Sprite;
import com.unnamed.game.util.KeyHandler;
import com.unnamed.game.util.MouseHandler;
import com.unnamed.game.util.Vector2D;

/**
 * @version PlayState Class
 * @author Red Williams (Red-CS)
 * @version 05-30-2021
 */
public class PlayState extends GameState {

    private Font font;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        font = new Font("font/ZeldaFont.png", 16, 16);
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

    }


    /**
     * @param g
     */
    @Override
    public void render(Graphics2D g) {

        Sprite.drawArray(g, font, "a your mom", new Vector2D(100, 100), 32, 32,
            16, 0);
    }

}
