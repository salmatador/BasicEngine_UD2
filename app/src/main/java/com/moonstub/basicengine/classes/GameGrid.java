package com.moonstub.basicengine.classes;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.moonstub.basicengine.framework.GameGraphics;
import com.moonstub.basicengine.framework.GameImage;
import com.moonstub.basicengine.framework.GameSettings;

import java.util.Random;

/**
 * Created by Micah on 1/19/2016.
 */
public class GameGrid {

    int size = 50;
    int currentFrame = 0;
    int maxFrame;
    int gemIndex = 0;
    float timeElapsed = 0.0f;
    float animationDelay = 3.0f;
    boolean isAlive;
    int x,y;
    Random randGem = new Random();;
    //GameImage image;

    public GameGrid(int x, int y, int maxFrame){
        this.x = x;
        this.y = y;
        this.maxFrame = maxFrame;
        isAlive = false;
        setInitGemIndex();
        //setRandomGemIndex();
        //gemIndex = 0;
    }

    public void setMaxFrame(int maxFrame){
        this.maxFrame = maxFrame;
    }

    public void updateFrame(float delta){
        //timeElapsed = timeElapsed + delta;
        //if(timeElapsed >= animationDelay) {
            currentFrame++;
            if (currentFrame > maxFrame) {
                currentFrame = 0;
            }
          //  timeElapsed = 0.0f;
        //}
    }

    public void draw(GameGraphics graphics, AnimateImage[] gemImage){
        //if(gemIndex != 0){
        graphics.drawImage(gemImage[gemIndex]
                .getImage(currentFrame),(getX()*size)+ GameSettings.OFFSET_X,
                (getY()*size) + GameSettings.OFFSET_Y);
        //}
    }

    public int getX(){ return this.x; }
    public int getY(){ return this.y; }


    public int getGemIndex() {
        return this.gemIndex;
    }

    public void setGemIndex(int gemIndex) {
        this.gemIndex = gemIndex;
    }

    public boolean isEmpty() {
        return !(gemIndex > 0);
    }

    public void setInitGemIndex(){
        gemIndex = 3;
    }
    public void setRandomGemIndex() {
        gemIndex = randGem.nextInt(8);
    }

    public Rect bounds(){
        return new Rect(300,50,350,100);


    }
}
