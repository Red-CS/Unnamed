package com.unnamed.game.util;

import com.unnamed.game.entity.Entity;

/**
 * AABB Class
 * (Axis-Aligned Bounding Box)
 * Collision Detection
 * @author Red Williams (Red-CS)
 * @version 05-30-2021
 */
public class AABB {

    private Vector2D pos;
    private Entity entity;
    private float width;
    private float height;
    private float radius;
    private float xOffset = 0;
    private float yOffset = 0;
    private int size;

    /**
     * AABB Constructor
     */
    public AABB(Vector2D pos, int width, int height) {
        this.pos = pos;
        this.width = width;
        this.height = height;

        size = Math.max(width, height);

    }


    /**
     * AABB Constructor
     * @param pos
     * @param radius
     */
    public AABB(Vector2D pos, int radius, Entity entity) {
        this.pos = pos;
        this.radius = radius;
        this.entity = entity;

        size = radius;
    }


    public Vector2D getPos() {
        return pos;
    }


    public float getWidth() {
        return width;
    }


    public float getHeight() {
        return height;
    }


    /**
     * @return
     */
    public float getRadius() {
        return radius;
    }


    public void setBox(Vector2D pos, int width, int height) {
        this.pos = pos;
        this.width = width;
        this.height = height;

        size = Math.max(width, height);
    }


    public void setCircle(Vector2D pos, int radius) {
        this.pos = pos;
        this.radius = radius;

        size = radius;
    }


    public void setWidth(float f) {
        width = f;
    }


    public void setHeight(float f) {
        height = f;
    }


    public void setXOffset(float f) {
        xOffset = f;
    }


    public void setYOffset(float f) {
        yOffset = f;
    }


    /**
     * Determines if 2 Entities collide with each other
     * @param bBox Collision box of the other Entity
     * @return True if they collide, false if not
     */
    public boolean collidesWith(AABB bBox) {
        // Get the middle points of the box
        float ax = ((pos.getWorldVar().x + (xOffset)) + (width / 2));
        float ay = ((pos.getWorldVar().y + (yOffset)) + (height / 2));
        float bx = ((bBox.pos.getWorldVar().x + (bBox.xOffset / 2)) + (width
            / 2));
        float by = ((bBox.pos.getWorldVar().y + (bBox.yOffset / 2)) + (height
            / 2));

        // Returns true if the hitboxes are within each other
        if (Math.abs(ax - bx) < (width / 2) + (bBox.width / 2)) {
            if (Math.abs(ay - by) < (height / 2) + (bBox.height / 2)) {
                return true;
            }
        }

        // Else they aren't colliding
        return false;
    }


    /**
     * Determines if a circle and a box collide
     * @param aBox Collision box to test
     * @return True if they collide, flase otherwise
     */
    public boolean colCircleBox(AABB aBox) {

        float cx = (float)(pos.getWorldVar().x + radius / Math.sqrt(2.0)
            - entity.getSize() / Math.sqrt(2.0));
        float cy = (float)(pos.getWorldVar().y + radius / Math.sqrt(2.0)
            - entity.getSize() / Math.sqrt(2.0));

        float xDelta = cx - Math.max(aBox.pos.getWorldVar().x + (aBox.getWidth()
            / 2), Math.min(cx, aBox.pos.getWorldVar().x));
        float yDelta = cy - Math.max(aBox.pos.getWorldVar().y + (aBox.getWidth()
            / 2), Math.min(cy, aBox.pos.getWorldVar().y));

        return ((Math.pow(xDelta, 2) + Math.pow(yDelta, 2)) < Math.pow((radius
            / Math.sqrt(2.0)), 2));

    }

}
