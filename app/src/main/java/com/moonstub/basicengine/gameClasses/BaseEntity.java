package com.moonstub.basicengine.gameClasses;

import android.graphics.Color;
import android.graphics.Rect;

import com.moonstub.basicengine.framework.GameGraphics;

/**
 * Created by Micah on 5/3/2016.
 */
public class BaseEntity {

    int x,y,size,width,height,life;
    boolean isAlive;

    //sets parameters for the base
    public BaseEntity(int x, int y, int size){
        setX(x);
        setY(y);
        setSize(size);
        setIsAlive(true);
        life = 3;
    }

    //draws rectangles for the bases
    public void draw(GameGraphics graphics){
        graphics.drawFillRect(getBounds(), Color.GREEN);
    }

    //getters and setters
    public Rect getBounds(){
        return new Rect(x,y,x+width,y+height);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
        this.width = size;
        this.height = size;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
}
