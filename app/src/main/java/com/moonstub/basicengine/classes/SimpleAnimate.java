package com.moonstub.basicengine.classes;

import android.util.Log;

import com.moonstub.basicengine.framework.GameGraphics;
import com.moonstub.basicengine.framework.GameImage;

/**
 * Created by Micah on 5/17/2016.
 */
public class SimpleAnimate {


    int frameCount;
    int currentFrame;
    float timeAccumulation = 0.0f;

    GameImage[] imageAssets;

    public SimpleAnimate(GameImage[] imageAssets){
        this.imageAssets = imageAssets;
        this.frameCount = imageAssets.length;
        this.currentFrame = 0;
    }

    public SimpleAnimate(){}

    public void update(float delta){
        timeAccumulation = timeAccumulation + delta;

        //Log.v("Delta Time", delta + "");
        if(timeAccumulation > 45.0f){
            currentFrame++;
            if(currentFrame == imageAssets.length){
                currentFrame = 0;
            }
            timeAccumulation = 0.0f;
        }
    }

    public void draw(GameGraphics graphics){
        //graphics.drawImage(imageAssets[currentFrame],100,100);
        graphics.drawScaledImage(imageAssets[currentFrame],100,100,200,200);
    }

    public GameImage getCurrentImage(){
        return imageAssets[currentFrame];
    }
}
