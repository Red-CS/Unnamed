package com.unnamed.game.util;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import com.unnamed.game.GamePanel;

public class MouseHandler implements MouseListener, MouseMotionListener {

    // Set to -1 when not being pressed
    private static int mouseX = -1;
    private static int mouseY = -1;
    private static int mouseB = -1;
    // Left Button = 1,
    // Middle Button = 2;
    // Right Button = 3,

    /**
     * MouseHandler Constructor
     * @param game Game Panel instance
     */
    public MouseHandler(GamePanel game) {
        game.addMouseListener(this);
    }


    /**
     * Gets X Position of the mouse
     * @return X Position of the mouse
     */
    public int getX() {
        return mouseX;
    }


    /**
     * Gets Y Position of the mouse
     * @return Y Position of the mouse
     */
    public int getY() {
        return mouseY;
    }


    /**
     * Returns the Mouse Button clicked
     * @return the Mouse Button clicked
     */
    public int getButton() {
        return mouseB;
    }


    /**
     * Handles the mouse click
     * @param e Mouse Event
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }


    /**
     * Handles the mouse pressed
     * @param e Mouse Event
     */
    @Override
    public void mousePressed(MouseEvent e) {
        mouseB = e.getButton();

    }


    /**
     * Handles the mouse release
     * @param e Mouse Event
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        mouseB = -1;

    }


    /**
     * Handles the mouse entering
     * @param e MouseEvent
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }


    /**
     * Handles the mouse exiting
     * @param e Mouse Event
     */
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }


    /**
     * Handles the mouse dragging
     * @param e Mouse Event
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }


    /**
     * Handles the mouse moving
     * @param e Mouse Event
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

}
