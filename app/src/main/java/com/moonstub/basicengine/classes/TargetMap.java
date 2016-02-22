package com.moonstub.basicengine.classes;

import android.graphics.Rect;

/**
 * Created by Micah on 2/21/2016.
 */
public class TargetMap {

    Rect target;

    public TargetMap(int x, int y, int h, int w){
        target = new Rect(x,y,x+w,y+h);
    }

    public Rect getBounds(){
        return new Rect(target);
    }
}
