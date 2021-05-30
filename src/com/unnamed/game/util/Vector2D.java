package com.unnamed.game.util;

/**
 * @version Vector2D Class
 * @author Red Williams (Red-CS)
 * @version 05-30-2021
 */
public class Vector2D {

    public float x;
    public float y;

    /** X and Y of the World */
    public static float worldX;
    public static float worldY;

    /**
     * Vector2D Constructor
     */
    public Vector2D() {
        x = 0;
        y = 0;
    }


    /**
     * Vector2D Constructor
     * @param vector
     */
    public Vector2D(Vector2D vector) {
        new Vector2D(vector.x, vector.y);
    }


    /**
     * Vector2D Constructor
     * @param x
     * @param y
     */
    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }


    /**
     * @param f
     */
    public void addX(float f) {
        x += f;
    }


    /**
     * @param f
     */
    public void addY(float f) {
        y += f;
    }


    /**
     * @param f
     */
    public void setX(float f) {
        x = f;
    }


    /**
     * @param f
     */
    public void setY(float f) {
        y = f;
    }


    public void setVector(Vector2D vector) {
        x = vector.x;
        y = vector.y;
    }


    /**
     * @param x
     * @param y
     */
    public void setVector(float x, float y) {
        this.x = x;
        this.y = y;
    }


    /**
     * @param x
     * @param y
     */
    public static void setWorldVar(float x, float y) {
        worldX = x;
        worldY = y;
    }


    /**
     * @return
     */
    public Vector2D getWorldVar() {
        return new Vector2D(x - worldX, y - worldY);
    }


    /**
     * Returns a String representation of the Vector
     * @return a String representation of the Vector
     */
    @Override
    public String toString() {
        return x + ", " + y;
    }

}
