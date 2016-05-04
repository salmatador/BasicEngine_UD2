package com.moonstub.basicengine.gameClasses;

import android.graphics.Color;
import android.graphics.Rect;

import com.moonstub.basicengine.framework.Colors;
import com.moonstub.basicengine.framework.GameActivity;
import com.moonstub.basicengine.framework.GameGraphics;
import com.moonstub.basicengine.framework.GameSettings;

import java.util.ArrayList;

/**
 * Created by Micah on 4/19/2016.
 */
public class PlayerClass {

    GameActivity game;
    int x,y,width,height;
    boolean isAlive;
    int livesLeft;
    int score;
    int mColor;
    Bullet[] mBullets;
    int maxBullets = 5;
    int currentBullet = 0;

    public PlayerClass(GameActivity game, int x, int y){
        this.game = game;
        this.x = x;
        this.y = y;
        isAlive = false;
        livesLeft = 3;
        score = 0;
        width = 100;
        height = 50;
        mColor = Color.WHITE;
        mBullets = new Bullet[maxBullets];
        for(int index = 0; index < mBullets.length; index++){
            mBullets[index] = new Bullet();
        }
    }

    public void update(ArrayList<Enemy> enemy){
        for (int i = 0; i < mBullets.length; i++) {
            if(mBullets[i].isAlive()) {
                mBullets[i].move();
                mBullets[i].checkCollision(enemy);
            }
        }

    }

    public void move(int step){
        x = x + step;
        if( x  < 0){
            x = 0;
        }
        if(x + width > game.getGameGraphics().getWidth()){
            x = game.getGameGraphics().getWidth() - width;
        }
    }

    public void fire(){
        int index = currentBullet;
        if(!mBullets[index].isAlive()) {
            mBullets[index] = new Bullet(x + (width / 2), y - 10,true);
        }
            currentBullet = ((currentBullet + 1) % mBullets.length);
    }

    public void draw(GameGraphics graphics){
        graphics.drawFillRect(new Rect(x,y,x + width,y + height), mColor);
        for (Bullet bullet : mBullets) {
            if(bullet.isAlive()) {
                bullet.draw(graphics);
            }
        }
    }

    public void setColor(int color){
        mColor = color;
    }




}
