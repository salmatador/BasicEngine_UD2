package com.moonstub.basicengine.gameClasses;

import android.graphics.Color;
import android.graphics.Rect;

import com.moonstub.basicengine.framework.GameGraphics;

/**
 * Created by Micah on 4/26/2016.
 */
public class ActionButton {

    int x,y,size;
    boolean isTouched;

    //creates a button
    public ActionButton(int x, int y, int size){
        setX(x);
        setY(y);
        setSize(size);
        setIsTouched(false);
    }

    //calls a filled rectangle
    public void draw(GameGraphics graphics){
        graphics.drawFillRect(new Rect(x,y,x+size,y+size),((isTouched) ? Color.GREEN : Color.GRAY));
    }

    //getters and setters
    public Rect getBounds(){
        return new Rect(x,y,x+size,y+size);
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

    //checks to see if button is touched
    public boolean isTouched() {
        return isTouched;
    }

    //lets the program know the button is touched
    public void setIsTouched(boolean isTouched) {
        this.isTouched = isTouched;
    }
}
