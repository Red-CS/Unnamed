package com.unnamed.game.entity;

import java.awt.Graphics2D;
import com.unnamed.game.graphics.Sprite;
import com.unnamed.game.util.KeyHandler;
import com.unnamed.game.util.MouseHandler;
import com.unnamed.game.util.Vector2D;

/**
 * Player Class
 * @author Red Williams (Red-CS)
 * @version 05-30-2021
 */
public class Player extends Entity {

    /**
     * Player Constructor
     */
    public Player(Sprite sprite, Vector2D origin, int size) {
        super(sprite, origin, size);
    }


    public void move() {
        if (up) {
            dy -= acc;
            if (dy < -maxSpeed) {
                dy = -maxSpeed;
            }
        }
        else {
            if (dy < 0) {
                dy += deacc;
                if (dy > 0) {
                    dy = 0;
                }
            }
        }

        if (down) {
            dy += acc;
            if (dy < maxSpeed) {
                dy = maxSpeed;
            }
        }
        else {
            if (dy > 0) {
                dy -= deacc;
                if (dy < 0) {
                    dy = 0;
                }
            }
        }

        if (left) {
            dx -= acc;
            if (dx < -maxSpeed) {
                dx = -maxSpeed;
            }
        }
        else {
            if (dx < 0) {
                dx += deacc;
                if (dx > 0) {
                    dx = 0;
                }
            }
        }

        if (right) {
            dx += acc;
            if (dx > maxSpeed) {
                dx = maxSpeed;
            }
        }
        else {
            if (dx > 0) {
                dx -= deacc;
                if (dx < 0) {
                    dx = 0;
                }
            }
        }

    }


    @Override
    public void update() {
        super.update();
        move();
        pos.x += dx;
        pos.y += dy;
    }


    /**
     * @param g Graphics object
     */
    @Override
    public void render(Graphics2D g) {
        g.drawImage(ani.getImage(), (int)(pos.x), (int)(pos.y), size, size,
            null);
    }


    @Override
    public void input(MouseHandler mouse, KeyHandler key) {

        if (mouse.getButton() == 1) {
            System.out.println("Player: " + pos.x + ", " + pos.y);
        }

        // If Player presses Up
        if (key.up.down) {
            up = true;
        }
        else {
            up = false;
        }

        // If Player presses Down
        if (key.down.down) {
            down = true;
        }
        else {
            down = false;
        }

        // If Player presses Left
        if (key.left.down) {
            left = true;
        }
        else {
            left = false;
        }

        // If Player presses Right
        if (key.right.down) {
            right = true;
        }
        else {
            right = false;
        }

        // If Player presses Attack button
        if (key.attack.down) {
            attack = true;
        }
        else {
            attack = false;
        }

    }

}
