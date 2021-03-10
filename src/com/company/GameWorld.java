package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Timer;

public class GameWorld extends JPanel implements Runnable, KeyListener {

    private static final int WIDTH = 1000,HEIGHT = 1000;
    private Thread thread;
    private static boolean isRunning;

    private Sprite sprite;
    private TileMap tileMap;

    private HashMap<Integer,Boolean> keyInputManager;

    public GameWorld(){
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        addKeyListener(this);
        sprite = new Sprite(3,0,20,20);
        tileMap = new TileMap(sprite);
        keyInputManager = new HashMap<>();
        requestFocus();
    }

    public void init(){
        isRunning = true;
        tileMap = new TileMap(sprite);
        thread = new Thread(this);
        thread.start();
    }

    public void stop(){
        if (!isRunning){
            return;
        }
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        init();
        while (isRunning){
            loadFramePerSec();
            repaint();
        }
        //stop();
    }

    public void loadFramePerSec(){
        try {
            Thread.sleep(1000/60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics graphics){
        graphics.clearRect(0,0,WIDTH,HEIGHT);
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0,WIDTH,HEIGHT);
        //updateMovement();
        tileMap.draw(graphics);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e){
        keyInputManager.put(e.getKeyCode(),true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyInputManager.put(e.getKeyCode(),false);
    }

    /*private void updateMovement(){
        if (keyInputManager.getOrDefault(KeyEvent.VK_RIGHT,false)){
            if (sprite.getLocationX()<TileMap.TILE_COL-1){
                sprite.moveHorizontally(1);
                tileMap.replaceOldPosWithZero(sprite.getLocationY(),sprite.getLocationX()-1);
                tileMap.updatePosSprite(sprite.getLocationY(),sprite.getLocationX());
            }
        }

        /*else if (keyInputManager.getOrDefault(KeyEvent.VK_LEFT,false)){
            if (sprite.getLocationX()>0){
                sprite.moveHorizontally(-1);
                tileMap.replaceOldPosWithZero(sprite.getLocationY(),sprite.getLocationX()+1);
                tileMap.updatePosSprite(sprite.getLocationY(),sprite.getLocationX());
            }
        }

        else if (keyInputManager.getOrDefault(KeyEvent.VK_UP,false)){
            if (sprite.getLocationY()>0){
                sprite.moveVertically(-1);
                tileMap.replaceOldPosWithZero(sprite.getLocationY()-1,sprite.getLocationX());
                tileMap.updatePosSprite(sprite.getLocationY(),sprite.getLocationX());
            }
        }
    */

}
