package com.moonstub.basicengine.gameClasses;

import android.graphics.Color;
import android.graphics.Rect;

import com.moonstub.basicengine.framework.Colors;
import com.moonstub.basicengine.framework.GameGraphics;
import com.moonstub.basicengine.framework.GameSettings;

/**
 * Created by Micah on 4/19/2016.
 */
public class PlayerClass {

    int x,y,width,height;
    boolean isAlive;
    int livesLeft;
    int score;
    int mColor;

    public PlayerClass(int x, int y){
        this.x = x;
        this.y = y;
        isAlive = false;
        livesLeft = 3;
        score = 0;
        width = 100;
        height = 50;
        mColor = Color.WHITE;
    }

    public void move(int step){
        x = x + step;
        if( x  < 0){
            x = 0;
        }
        if(x + width > GameSettings.PORT_SCREEN_WIDTH/2){
            x = GameSettings.PORT_SCREEN_WIDTH/2 - width;
        }
    }

    public void fire(){

    }

    public void draw(GameGraphics graphics){
        graphics.drawFillRect(new Rect(x,y,x + width,y + height), mColor);
    }

    public void setColor(int color){
        mColor = color;
    }




}
