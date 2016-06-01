package com.moonstub.basicengine.gameClasses;

import android.graphics.Color;
import android.graphics.Rect;

import com.moonstub.basicengine.framework.GameGraphics;

import java.util.ArrayList;

/**
 * Created by Micah on 4/26/2016.
 */
public class Bullet {

    int x,y;
    boolean isAlive;
    boolean direction = false;
    public Bullet (){
        setY(-1000);
        setX(-1000);
        setIsAlive(false);
    }
    //sets parameters for the bullets
    public Bullet(int x, int y, boolean direction){
        setX(x);
        setY(y);
        setIsAlive(true);
        this.direction = direction;
    }

    //draws rectangles for bullets
    public void draw(GameGraphics graphics){
        graphics.drawFillRect(new Rect(x, y, x + 10, y + 15), Color.BLUE);
    }

    //checks to see if the bullet hit an enemy
    public void checkCollision(ArrayList<Enemy> enemy){
        for (Enemy e : enemy) {
            if(e.isAlive() && e.getBounds().contains(getX(),getY())){
                e.setIsAlive(false);
                setIsAlive(false);
                break;
            }

        }
    }

    //moves the bullet when fired in one direction
    public void move(){
        setY(getY() + ((direction) ? -10 : 10));
        if(getY() <= 0 || getY() > 1500){
            setIsAlive(false);
        }
    }

    //getters and setters
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
