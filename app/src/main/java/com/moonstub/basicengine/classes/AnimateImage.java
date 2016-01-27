package com.moonstub.basicengine.classes;

import com.moonstub.basicengine.framework.GameActivity;
import com.moonstub.basicengine.framework.GameImage;

/**
 * Created by Micah on 1/19/2016.
 */
public class AnimateImage {

    GameActivity mGameActivity;
    GameImage mImages[];
    GameImage mSpriteImage;

    int mFrameSizeX = 50;
    int mFrameSizeY = 50;
    int mSpriteCount = 1;

    public AnimateImage(GameActivity game, GameImage spriteImage, int frameSizeX,int frameSizeY, int spriteCount){
        mSpriteImage = spriteImage;
        mFrameSizeX = frameSizeX;
        mFrameSizeY = frameSizeY;
        mSpriteCount = spriteCount;
        mGameActivity = game;
    }

    public GameImage getImage(int index){
        if(index > mImages.length - 1)
        {
            index = 0;
        }
            return mImages[index];
    }

    public boolean LoadImageArray(){
        boolean isDone = false;
        int x = 0;
        int y = 0;
        int count = 0;
        mImages = new GameImage[mSpriteCount];
        while(!isDone){
            mImages[count] = mGameActivity.getGameGraphics()
                    .newSpriteImage(mSpriteImage,x,y,mFrameSizeX,mFrameSizeY);
            count++;
            x = x + mFrameSizeX;
            if(x > mSpriteImage.getWidth() - mFrameSizeX){
                x = 0;
                y = y + mFrameSizeY;
            }
            if(count == mSpriteCount){
                isDone = true;
            }

        }

        return true;
    }

    public int getFrameCount() {
        return mImages.length;
    }
}
