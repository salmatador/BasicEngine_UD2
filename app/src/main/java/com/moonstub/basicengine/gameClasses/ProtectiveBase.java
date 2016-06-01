package com.moonstub.basicengine.gameClasses;

import com.moonstub.basicengine.framework.GameGraphics;

import java.util.ArrayList;

/**
 * Created by Micah on 5/17/2016.
 */
public class ProtectiveBase {

    /**
     *
     *  XXX
     *  X_X
     *  X_X
     * **/

    int x,y,gridSize;
    ArrayList<BaseEntity> baseBlocks;

    public ProtectiveBase(int x, int y, int gridSize){

        this.x = x;
        this.y = y;
        this.gridSize = gridSize;
        baseBlocks = new ArrayList<>();
        buildBase();
    }

    //draws the base the player moves under
    public void buildBase(){

        for(int indexY = 0; indexY < 3; indexY++){
            for(int indexX = 0; indexX < 3; indexX++){
                if(indexY * 3 + indexX == 4 || indexY * 3 + indexX == 7){

                }else{

                    baseBlocks.add(new BaseEntity(((gridSize -1) * indexX) + x, ((gridSize - 1) * indexY)+y, gridSize));

                }

            }
        }
    }

    public void draw(GameGraphics graphics){
        for (BaseEntity b : baseBlocks) {
            b.draw(graphics);
        }
    }

}
