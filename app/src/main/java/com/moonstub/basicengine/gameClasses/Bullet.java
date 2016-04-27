package com.moonstub.basicengine.gameClasses;

import android.graphics.Color;
import android.graphics.Rect;

import com.moonstub.basicengine.framework.GameGraphics;

/**
 * Created by Micah on 4/26/2016.
 */
public class Bullet {

    int x,y;
    boolean isAlive;

    public Bullet (){
        setY(-1000);
        setX(-1000);
        setIsAlive(false);
    }
    public Bullet(int x, int y){
        setX(x);
        setY(y);
        setIsAlive(true);
    }

    public void draw(GameGraphics graphics){
        graphics.drawFillRect(new Rect(x, y, x + 5, y + 10), Color.BLUE);
    }



    public void move(){
        setY(getY() - 10);
        if(getY() <= 0){
            setIsAlive(false);
        }
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

    public boolean isAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
}
