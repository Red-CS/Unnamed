package com.unnamed.game.util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import com.unnamed.game.GamePanel;

/**
 * @version KeyHandler Class
 * @author Red Williams (Red-CS)
 * @version 05-30-2021
 */
public class KeyHandler implements KeyListener {

    /** Sequence of keys pressed */
    public static List<Key> keys = new ArrayList<Key>();

    /**
     * @version Key Class
     * @author Red Williams (Red-CS)
     * @version 05-30-2021
     */
    public class Key {
        public int presses, absorbs;
        public boolean down, clicked;

        /**
         * Key Constructor
         */
        public Key() {
            KeyHandler.keys.add(this);
        }


        /**
         * Toggles a key's state
         * @param pressed
         */
        public void toggle(boolean pressed) {
            if (pressed != down) {
                down = pressed;
            }

            if (pressed) {
                presses++;
            }
        }


        /**
         * 
         */
        public void tick() {
            if (absorbs < presses) {
                absorbs++;
                clicked = true;
            }
            else {
                clicked = false;
            }
        }
    }

    public Key up = new Key();
    public Key down = new Key();
    public Key left = new Key();
    public Key right = new Key();
    public Key attack = new Key();
    public Key menu = new Key();
    public Key enter = new Key();
    public Key escape = new Key();

    public KeyHandler(GamePanel game) {
        game.addKeyListener(this);
    }


    /**
     * Releases a button if it's being pressed
     */
    public void releaseAll() {
        for (int i = 0; i < KeyHandler.keys.size(); i++) {
            KeyHandler.keys.get(i).down = false;
        }
    }


    /**
     * 
     */
    public void tick() {
        for (int i = 0; i < KeyHandler.keys.size(); i++) {
            KeyHandler.keys.get(i).tick();
        }
    }


    /**
     * Sets the action based on the key
     * 
     * @param e key pressed event
     * @param pressed State of key
     */
    public void toggle(KeyEvent e, boolean pressed) {

        if (e.getKeyCode() == KeyEvent.VK_W) {
            up.toggle(pressed);
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            down.toggle(pressed);
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            left.toggle(pressed);
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            right.toggle(pressed);
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            attack.toggle(pressed);
        }
        if (e.getKeyCode() == KeyEvent.VK_E) {
            menu.toggle(pressed);
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            enter.toggle(pressed);
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            escape.toggle(pressed);
        }

    }


    /**
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }


    /**
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        toggle(e, true);
    }


    /**
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {
        toggle(e, false);

    }

}
