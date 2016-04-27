package com.moonstub.basicengine.gameClasses;

import android.graphics.Color;
import android.graphics.Rect;

import com.moonstub.basicengine.framework.GameActivity;
import com.moonstub.basicengine.framework.GameGraphics;

import java.util.ArrayList;

/**
 * Created by Micah on 4/26/2016.
 */
public class Enemy {

    int x,y,size;
    boolean isAlive,direction,drop;
    GameActivity game;
    //private boolean mDrop;

    public Enemy(GameActivity game, int x, int y, int size){
        this.game = game;
        setX(x);
        setY(y);
        setSize(size);
        setDirection(true);
    }

    public void draw(GameGraphics graphics){
        graphics.drawFillRect(new Rect(x, y, x + size, y + size), Color.CYAN);
    }

    public void update(ArrayList<Enemy> enemyList){
        boolean switchDirection = move();
        if( switchDirection){
            phoneHome(enemyList);

        }
    }

    private void phoneHome(ArrayList<Enemy> enemyList) {
        for (int index = 0; index < enemyList.size(); index++) {
            enemyList.get(index).setDirection(!enemyList.get(index).isDirection());
            enemyList.get(index).setDrop(true);
        }
    }

    private boolean move() {
        if(drop){
         y = y + 25;
            setDrop(false);
        } else {
            if (direction) {
                x = x + 10;
                if (x + size >= game.getGameGraphics().getWidth()) {
                    x = game.getGameGraphics().getWidth() - size;
                    return true;
                    //direction = !direction;
                }
            } else {
                x = x - 10;
                if (x <= 0) {
                    x = 0;
                    return true;
                    //direction = !direction;
                }
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
}
