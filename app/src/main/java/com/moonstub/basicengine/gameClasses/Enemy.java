package com.moonstub.basicengine.gameClasses;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.Log;

import com.moonstub.basicengine.framework.GameActivity;
import com.moonstub.basicengine.framework.GameGraphics;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Micah on 4/26/2016.
 */
public class Enemy {

    int x,y,size;
    boolean isAlive,direction,drop;
    GameActivity game;
    Bullet mBullet;
    //private boolean mDrop;

    public Enemy(GameActivity game, int x, int y, int size){
        this.game = game;
        setX(x);
        setY(y);
        setSize(size);
        setDirection(true);
        setIsAlive(true);
        mBullet = new Bullet();
    }

    public void fire(){
        Random rnd = new Random();
        int value = rnd.nextInt(10000);
        if(value < 2 && !mBullet.isAlive()){
            mBullet = new Bullet(getX() + getBounds().width() / 2,getY(),false);
        }
    }
    public void draw(GameGraphics graphics){
        if(isAlive()){
            graphics.drawFillRect(new Rect(x, y, x + size, y + size), Color.CYAN);
        }
        if(mBullet.isAlive()){
            mBullet.draw(graphics);
        }
    }

    public void update(){
        move();
        fire();
        if(mBullet.isAlive()){
            mBullet.move();
        }
    }

    public void phoneHome(ArrayList<Enemy> enemyList) {
        for (int index = 0; index < enemyList.size(); index++) {
            enemyList.get(index).setDirection(!enemyList.get(index).isDirection());
            enemyList.get(index).setDrop(true);
        }
    }

    public boolean wallCheck() {
        if(isAlive()) {
            if (direction) {
                if (x + size > game.getGameGraphics().getWidth()) {

                    return true;
                }
            } else {
                if (x < 10) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean move() {
        if(drop){
         y = y + 25;
            setDrop(false);
        } else {
            if (direction) {
                x = x + 10;
            } else {
                x = x - 10;
            }
        }
        return false;
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
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public boolean isDirection() {
        return direction;
    }

    public void setDirection(boolean direction) {
        this.direction = direction;
    }

    public void setDrop(boolean drop) {
        this.drop = drop;
    }

    public Rect getBounds(){
        return new Rect(getX(),getY(),getX()+getSize(),getY()+getSize());
    }
}
