package com.moonstub.basicengine.input;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import com.moonstub.basicengine.framework.Pool;
import com.moonstub.basicengine.framework.Pool.PoolObjectFactory;
import com.moonstub.basicengine.input.TouchEvent.TouchEvents;
import com.moonstub.basicengine.framework.RenderView;

/**
 * Created by Micah on 11/4/2015.
 */
public class GameInputHandler implements InputHandler {

    boolean mIsTouched;
    int mTouchX;
    int mTouchY;
    Pool<TouchEvents> mTouchEventPool;
    List<TouchEvents> mTouchEvents = new ArrayList<>();
    List<TouchEvents> mTouchEventsBuffer = new ArrayList<>();
    float mScaleX = 1;
    float mScaleY = 1;

    public GameInputHandler(View view) {
        PoolObjectFactory<TouchEvents> factory = new PoolObjectFactory<TouchEvents>() {
            @Override
            public TouchEvents createObject() {
                return new TouchEvents();
            }
        };

        mTouchEventPool = new Pool<TouchEvents>(factory, 100);
        view.setOnTouchListener(this);


    }

    public GameInputHandler(RenderView renderView, float scaleX, float scaleY) {
        PoolObjectFactory<TouchEvents> factory = new PoolObjectFactory<TouchEvents>() {
            @Override
            public TouchEvents createObject() {
                return new TouchEvents();
            }
        };

        mTouchEventPool = new Pool<TouchEvents>(factory, 100);
        renderView.setOnTouchListener(this);

        mScaleX = 1.0f;//scaleX;
        mScaleY = 1.0f;//scaleY;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        synchronized (this) {
            TouchEvents touchEvent = mTouchEventPool.newObject();
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    touchEvent.type = TouchEvents.TOUCH_DOWN;
                    mIsTouched = true;
                    break;
                case MotionEvent.ACTION_MOVE:
                    touchEvent.type = TouchEvents.TOUCH_DRAGGED;
                    mIsTouched = true;
                    break;
                case MotionEvent.ACTION_CANCEL:
                case MotionEvent.ACTION_UP:
                    touchEvent.type = TouchEvents.TOUCH_UP;
                    mIsTouched = false;
                    break;
                default:
                    Log.e("Input Error", event.getAction() + "");
                    //throw new IllegalArgumentException();
            }

            touchEvent.x = mTouchX = (int) (event.getRawX());// * mScaleX);
            touchEvent.y = mTouchY = (int) (event.getRawY());// * mScaleY);
            mTouchEventsBuffer.add(touchEvent);

            return true;
        }
    }

    @Override
    public boolean isDown(int pointer) {
        synchronized (this) {
            if (pointer == 0) {
                return mIsTouched;
            } else {
                return false;
            }
        }

    }

    @Override
    public int getX(int pointer) {
        synchronized (this) {
            return mTouchX;
        }

    }

    @Override
    public int getY(int pointer) {
        synchronized (this) {
            return mTouchY;
        }
    }

    @Override
    public List<TouchEvents> getTouchEvents() {
        synchronized (this) {
            int length = mTouchEvents.size();
            for (int i = 0; i < length; i++) {
                mTouchEventPool.free(mTouchEvents.get(i));
            }

            mTouchEvents.clear();
            mTouchEvents.addAll(mTouchEventsBuffer);
            mTouchEventsBuffer.clear();
            return mTouchEvents;
        }
    }


}
