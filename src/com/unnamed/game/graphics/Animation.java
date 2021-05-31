package com.unnamed.game.graphics;

import java.awt.image.BufferedImage;

/**
 * Animation Class
 * @author Red Williams (Red-CS)
 * @version 05-30-2021
 */
public class Animation {

    private BufferedImage[] frames;
    private int currentFrame;
    private int numFrames;

    private int count;
    private int delay;

    private int timesPlayed;

    /**
     * Animation Constructor
     */
    public Animation() {
        timesPlayed = 0;
    }


    /**
     * Animation Constructor
     */
    public Animation(BufferedImage[] frames) {
        timesPlayed = 0;
        setFrames(frames);
    }


    public void setFrames(BufferedImage[] frames) {
        this.frames = frames;
        currentFrame = 0;
        count = 0;
        timesPlayed = 0;
        delay = 2;
        numFrames = frames.length;
    }


    public void setDelay(int delay) {
        this.delay = delay;
    }


    public void setFrame(int frame) {
        currentFrame = frame;
    }


    public void setNumFrames(int numFrames) {
        this.numFrames = numFrames;
    }


    public void update() {
        if (delay == -1) {
            return;
        }

        count++;

        if (count == delay) {
            currentFrame++;
            count = 0;
        }

        if (currentFrame == numFrames) {
            currentFrame = 0;
            timesPlayed++;
        }
    }


    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }


    /**
     * @return the frame
     */
    public int getFrame(int frame) {
        return frame;
    }


    /**
     * @return the delay
     */
    public int getDelay() {
        return delay;
    }


    public BufferedImage getImage() {
        return frames[currentFrame];
    }


    public boolean hasPlayedOnce() {
        return timesPlayed > 0;
    }


    public boolean hasPlayed(int i) {
        return timesPlayed == i;
    }
}
