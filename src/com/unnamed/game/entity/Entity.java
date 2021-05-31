package com.unnamed.game.entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import com.unnamed.game.graphics.Animation;
import com.unnamed.game.graphics.Sprite;
import com.unnamed.game.util.AABB;
import com.unnamed.game.util.KeyHandler;
import com.unnamed.game.util.MouseHandler;
import com.unnamed.game.util.Vector2D;

/**
 * Entity Class
 * @author Red Williams (Red-CS)
 * @version 05-30-2021
 */
public abstract class Entity {

    private final int RIGHT = 0;
    private final int LEFT = 1;
    private final int UP = 2;
    private final int DOWN = 3;
    protected int currentAnimation;

    protected Animation ani;
    protected Sprite sprite;
    protected Vector2D pos;
    protected int size;
    protected int animationDelay;

    protected boolean up;
    protected boolean down;
    protected boolean right;
    protected boolean left;
    protected boolean attack;
    protected boolean attackSpeed;
    protected boolean attackDuration;

    protected float dx;
    protected float dy;

    protected float maxSpeed = 3f;
    protected float acc = 2f;
    protected float deacc = 0.1f;

    protected AABB hitBounds;
    protected AABB bounds;

    /**
     * Entity Constructor
     */
    public Entity(Sprite sprite, Vector2D origin, int size) {
        this.sprite = sprite;
        pos = origin;
        this.size = size;
        bounds = new AABB(origin, size, size);
        hitBounds = new AABB(new Vector2D(origin.x + (size / 2), origin.y),
            size, size);
        animationDelay = 5;
        ani = new Animation();

        setAnimation(LEFT, sprite.getSpriteArray(LEFT), 10);
    }


    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }


    public void setSize(int i) {
        size = i;
    }


    public void setMaxSpeed(float f) {
        maxSpeed = f;
    }


    public void setAcceleration(float f) {
        acc = f;
    }


    public void setDeceleration(float f) {
        deacc = f;
    }


    public AABB getBounds() {
        return bounds;
    }


    public int getSize() {
        return size;
    }


    public Animation getAnimation() {
        return ani;
    }


    public void setAnimation(int i, BufferedImage[] frames, int delay) {
        currentAnimation = i;
        ani.setFrames(frames);
        ani.setDelay(delay);
    }


    public void animate() {
        if (up) {
            if (currentAnimation != UP || ani.getDelay() == -1) {
// currentAnimation = UP;
                setAnimation(UP, sprite.getSpriteArray(UP), 5);
// setAnimation(RIGHT, sprite.getSpriteArray(RIGHT), 5);
            }
        }
        else if (down) {
// currentAnimation = DOWN;
            if (currentAnimation != DOWN || ani.getDelay() == -1) {
// setAnimation(DOWN, sprite.getSpriteArray(DOWN), 5);
                setAnimation(LEFT, sprite.getSpriteArray(LEFT), 5);
            }
        }
        else if (right) {
// currentAnimation = RIGHT;
            if (currentAnimation != RIGHT || ani.getDelay() == -1) {
                setAnimation(RIGHT, sprite.getSpriteArray(RIGHT), 5);
            }
        }
        else if (left) {
// currentAnimation = LEFT;
            if (currentAnimation != LEFT || ani.getDelay() == -1) {
                setAnimation(LEFT, sprite.getSpriteArray(LEFT), 5);
            }
        }
        else {
            // Idle
            setAnimation(currentAnimation, sprite.getSpriteArray(
                currentAnimation), 5);
        }

    }


    public void update() {
        animate();
        setHitBoxDirection();
        ani.update();
    }


    public abstract void render(Graphics2D g);


    public void input(MouseHandler mouse, KeyHandler key) {

    }


    private void setHitBoxDirection() {

        if (up) {
            hitBounds.setXOffset(-size / 2);
            hitBounds.setYOffset(-size / 2);
        }

        else if (down) {
            hitBounds.setXOffset(size / 2);
            hitBounds.setYOffset(-size / 2);
        }

        else if (left) {
            hitBounds.setXOffset(-size);
            hitBounds.setYOffset(0);
        }

        else if (right) {
            hitBounds.setXOffset(0);
            hitBounds.setYOffset(0);
        }

    }

}
