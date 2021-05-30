package com.unnamed.game;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable {
    
    public static final int PANEL_WIDTH = 800;
    public static final int PANEL_HEIGHT = 600;
    public final double GAME_HERTZ = 60.0;
    public final double TIME_BEFORE_UPDATE = 1000000000 / GAME_HERTZ;
    public final int MUST_UPDATE_BEFORE_RENDER = 5;
    public final double TARGET_FPS = 60.0;
    final double TOTAL_TIME_BEFORE_RENDER = 1000000000 / TARGET_FPS;
    
    private Thread thread;
    private boolean isRunning;
    private BufferedImage img;
    private Graphics2D g;
    
    public GamePanel(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocus();
    }

    @Override
    public void addNotify() {
        super.addNotify();
        
        if (thread == null) {
            thread = new Thread(this, "GameThread");
            thread.start();
        }
    }
    
    public void init() {
        isRunning = true;
        
        img = new BufferedImage(PANEL_WIDTH, PANEL_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        g = (Graphics2D) img.getGraphics();
    }

    @Override
    public void run() {
        init();
        
        double lastUpdateTime = System.nanoTime();
        double lastRenderTime;
        
        int frameCount = 0;
        int lastSecondTime = (int) (lastUpdateTime / 1000000000);
        int oldFrameCount = 0;
        
        // Game Loop
        while(isRunning) {
            double now = System.nanoTime();
            int updateCount = 0;
            while(((now - lastUpdateTime) > TIME_BEFORE_UPDATE) && (updateCount < MUST_UPDATE_BEFORE_RENDER)) {                
                update();
                input();
                lastUpdateTime += TIME_BEFORE_UPDATE;
                updateCount++;
            }
            
            if ((now - lastUpdateTime) > TIME_BEFORE_UPDATE) {
                lastUpdateTime = now - TIME_BEFORE_UPDATE;
            }
            
            input();
            render();
            draw();
            lastRenderTime = now;
            frameCount++;
            
            int thisSecond = (int) (lastUpdateTime / 1000000000);
            if (thisSecond > lastSecondTime) {
                if (frameCount != oldFrameCount) {
                    System.out.println("NEW SECOND " + thisSecond + " " + frameCount);
                    oldFrameCount = frameCount;
                }
                frameCount = 0;
                lastSecondTime = thisSecond;
            }
            
            while(now - lastRenderTime < TOTAL_TIME_BEFORE_RENDER && now - lastUpdateTime < TIME_BEFORE_UPDATE) {
                Thread.yield();
                try {
                    Thread.sleep(1);
                }
                catch(Exception e) {
                    System.out.println("ERROR: yielding thread");
                }
                now = System.nanoTime();
            }
        }
    }

    
    public void update() {
        
    }
    
    public void input() {
        
    }
    
    public void render() {
        if (g!= null) {
            g.setColor(new Color(66, 134, 244));
            g.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
        }
    }
    
    public void draw() {
        Graphics g2 = (Graphics) this.getGraphics();
        g2.drawImage(img, 0, 0, PANEL_WIDTH, PANEL_HEIGHT, null);
        g2.dispose();
    }
}
