package com.company;

import java.awt.*;
import java.util.Random;

public class TileMap {

    public static final int TILE_WIDTH = 20, TILE_HEIGHT = 20;
    public static final int TILE_ROW = 50, TILE_COL = 50;
    private int [][] map;

    private Sprite sprite;

    public TileMap(Sprite sprite){
        this.sprite = sprite;
        createMap();
    }

    private void createMap() {
        Random random = new Random();
        int randomLocationX = random.nextInt(TILE_ROW);
        int randomLocationY = random.nextInt(TILE_COL);
        map = new int[TILE_ROW][TILE_COL];
        map[sprite.getLocationX()][sprite.getLocationY()] = 2;
        for (int i = 0; i<TILE_ROW;i++){
            for (int j = 0; j<TILE_COL;j++){
                if (map[i][j] == 0){
                    map[randomLocationX][randomLocationY] = 1;
                    randomLocationX = random.nextInt(TILE_ROW);
                    randomLocationY = random.nextInt(TILE_COL);
                }
            }
        }
    }

    public void draw(Graphics graphics){
        for (int i = 0;i<TILE_ROW;i++){
            for (int j = 0;j<TILE_COL;j++){
                if (map[i][j] == 2){
                    System.out.println("draw");
                    graphics.setColor(Color.BLUE);
                    graphics.fillRect(j*TILE_WIDTH,i*TILE_HEIGHT,TILE_WIDTH,TILE_HEIGHT);
                }
                else if (map[i][j] == 1){
                    graphics.setColor(Color.RED);
                    graphics.fillRect(j*TILE_WIDTH,i*TILE_HEIGHT,TILE_WIDTH,TILE_HEIGHT);
                }
            }
        }
    }

    public void replaceOldPosWithZero(int x,int y){
        map[x][y] = 0;
    }

    public void updatePosSprite(int x, int y){
        map[x][y] = 2;
    }

}
