package com.moonstub.basicengine.gameClasses;

import android.graphics.Color;
import android.graphics.Rect;

import com.moonstub.basicengine.GameAssets;
import com.moonstub.basicengine.classes.SimpleAnimate;
import com.moonstub.basicengine.framework.GameActivity;
import com.moonstub.basicengine.framework.GameGraphics;
import com.moonstub.basicengine.framework.GameImage;

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
    GameImage mGameImage;
    SimpleAnimate mAnimate;
    //private boolean mDrop;

    public Enemy(GameActivity game, int x, int y, int size){
        this.game = game;
        setX(x);
        setY(y);
        setSize(size);
        setDirection(true);
        setIsAlive(true);
        mBullet = new Bullet();
        //mGameImage = GameAssets.TestAsset;
    }

    public void setSprite(GameImage[] sprites){
        mAnimate = new SimpleAnimate(sprites);
        mGameImage = mAnimate.getCurrentImage();
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
            if(mGameImage != null){
                //graphics.drawImage(mGameImage,x,y);
                graphics.drawScaledImage(mAnimate.getCurrentImage(),x,y,100,100);
            } else {
                graphics.drawFillRect(new Rect(x, y, x + size, y + size), Color.CYAN);
            }
        }
        if(mBullet.isAlive()){
            mBullet.draw(graphics);
        }
    }

    public void update(float delta){
        mAnimate.update(delta);
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
