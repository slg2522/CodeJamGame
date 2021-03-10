package com.company;

public class Sprite {

    private int locationX;
    private int locationY;
    private int width;
    private int height;

    public Sprite(int locationX, int locationY, int width, int height) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.width = width;
        this.height = height;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void moveHorizontally(int velocity){
        this.locationX+=velocity;
    }

    public void moveVertically(int velocity) {
        this.locationY+=velocity;
    }
}
