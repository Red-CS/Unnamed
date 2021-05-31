package com.unnamed.game.graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import com.unnamed.game.util.Vector2D;

/**
 * @version Sprite Class
 * @author Red Williams (Red-CS)
 * @version 05-30-2021
 */
public class Sprite {

    private BufferedImage SPRITESHEET = null;
    private BufferedImage[][] spriteArray;
    private final int TILE_SIZE = 32;

    /** Width of the Sprite's canvas / tile */
    public int width;

    /** Height of the Sprite's canvas / tile */
    public int height;

    private int wSprite;
    private int hSprite;

    /**
     * Sprite Constructor
     * @param file
     */
    public Sprite(String file) {
        width = TILE_SIZE;
        height = TILE_SIZE;

        System.out.println("Loading: " + file + "...");
        SPRITESHEET = loadSprite(file);

        /*
         * FIXME: This sets the dimensions of the spritesheet
         * (how many sprites in each column and each row)
         * to wSprite and hSprite.
         * 
         * width and height hold the canvas dimensions
         */
        wSprite = SPRITESHEET.getWidth() / width;
        hSprite = SPRITESHEET.getHeight() / height;
        System.out.println(wSprite + ", " + hSprite);
        System.out.println(width + ", " + height);
        loadSpriteArray();
    }


    /**
     * Sprite Constructor
     * @param file
     * @param width
     * @param height
     */
    public Sprite(String file, int width, int height) {
        this.width = width;
        this.height = height;

        System.out.println("Loading: " + file + "...");
        SPRITESHEET = loadSprite(file);

        wSprite = SPRITESHEET.getWidth() / width;
        hSprite = SPRITESHEET.getHeight() / height;
        System.out.println(wSprite + ", " + hSprite);
        System.out.println(width + ", " + height);
        loadSpriteArray();
    }


    public void setSize(int width, int height) {
        setWidth(width);
        setHeight(height);
    }


    /**
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
        wSprite = SPRITESHEET.getWidth() / this.width;
    }


    /**
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
        hSprite = SPRITESHEET.getHeight() / this.height;
    }


    /**
     * @return
     */
    public int getWidth() {
        return width;
    }


    /**
     * @return
     */
    public int getHeight() {
        return height;
    }


    /**
     * Creates an array-based sprite sheet.
     * Assumes a vertical - based Spritesheet
     */
    public void loadSpriteArray() {
        spriteArray = new BufferedImage[wSprite][hSprite];

        // Traverse columns of spritesheet
        for (int x = 0; x < wSprite; x++) {
            // Traverse rows of spritesheet
            for (int y = 0; y < hSprite; y++) {
                spriteArray[x][y] = getSprite(x, y);
            }
        }
    }


    /**
     * Returns the Spritesheet as a Buffered Image
     * @return The Spritesheet as a Buffered Image
     */
    public BufferedImage getSpriteSheet() {
        return SPRITESHEET;
    }


    /**
     * Gets the sprite at the specified location on the Spritesheet
     * @param x The X coordinate of the sprite
     * @param y The y coordinate of the sprite
     * @return The Sprite at the specified location on the Spritesheet
     */
    public BufferedImage getSprite(int x, int y) {
        return SPRITESHEET.getSubimage(x * width, y * height, width, height);
    }


    /**
     * Gets a column of the Spritesheet
     * @param i Column of the Spritesheet
     * @return the Column of the Spritesheet at {@code i}
     */
    public BufferedImage[] getSpriteArray(int i) {
        return spriteArray[i];
    }


    /**
     * Returns the Spritesheet as a 2D array
     * @return the Spritesheet as a 2D array
     */
    public BufferedImage[][] getSpriteArray2D() {
        return spriteArray;
    }


    /**
     * @param g
     * @param img
     * @param pos
     * @param width
     * @param height
     * @param xOffset
     * @param yOffset
     */
    public static void drawArray(
        Graphics2D g,
        ArrayList<BufferedImage> img,
        Vector2D pos,
        int width,
        int height,
        int xOffset,
        int yOffset) {

        float x = pos.x;
        float y = pos.y;

        for (int i = 0; i < img.size(); i++) {
            if (img.get(i) != null) {
                g.drawImage(img.get(i), (int)x, (int)y, width, height, null);
            }

            x += xOffset;
            y += yOffset;
        }
    }


    public static void drawArray(
        Graphics2D g,
        Font f,
        String word,
        Vector2D pos,
        int width,
        int height,
        int xOffset,
        int yOffset) {
        float x = pos.x;
        float y = pos.y;

        for (int i = 0; i < word.length(); i++) {

            // Don't draw a space
            if (word.charAt(i) != 32) {
                g.drawImage(f.getFont(word.charAt(i)), (int)x, (int)y, width,
                    height, null);
            }
            x += xOffset;
            y += yOffset;

        }
    }


    private BufferedImage loadSprite(String file) {
        BufferedImage sprite = null;
        try {
            sprite = ImageIO.read(getClass().getClassLoader()
                .getResourceAsStream(file));
        }
        catch (Exception e) {
            System.out.println("ERROR: could not load file: " + file);
        }
        return sprite;
    }

}
