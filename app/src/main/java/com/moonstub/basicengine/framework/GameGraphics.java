package com.moonstub.basicengine.framework;


import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

public class GameGraphics {

    public static enum ImageFormat {
        ARGB8888
    }

    AssetManager mAssetManager;
    Bitmap mFrameBuffer;
    Canvas mCanvas;
    Paint mPaint;
    Rect mSourceRect = new Rect();
    Rect mDestinationRect = new Rect();

    public GameGraphics(AssetManager assetManager, Bitmap frameBuffer) {
        mAssetManager = assetManager;
        mFrameBuffer = frameBuffer;
        mCanvas = new Canvas(frameBuffer);
        mPaint = new Paint();
    }
    public GameImage newSpriteImage(GameImage gameImage, int x, int y, int frameSize, int frameSizeY){

        Bitmap bitmap = null;

        bitmap = Bitmap.createBitmap(gameImage.getImage(),x,y,frameSize,frameSizeY);

        return new GameImage(bitmap, ImageFormat.ARGB8888);
    }
    public GameImage newImage(String fileName, ImageFormat format) {
        //Bitmap.Config config = Bitmap.Config.ARGB_8888;
        //BitmapFactory.Options options = new BitmapFactory.Options();
        //options.inPreferredConfig = config;

        InputStream inputStream = null;
        Bitmap bitmap = null;
        try {
            inputStream = mAssetManager.open(fileName);
            bitmap = BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Error loading asset file", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return new GameImage(bitmap, format);
    }

    //TODO fix this right now it only clears to black
    public void clearScreen(Colors color) {
        switch (color){

            case BLACK:
                mCanvas.drawRGB(0, 0, 0);
                break;
            case WHITE:
                mCanvas.drawRGB(255, 255, 255);
                break;
            case GRAY:
                mCanvas.drawRGB(100, 100, 100);
                break;
            default:
                mCanvas.drawRGB(0, 0, 0);
        }


    }

    //Helper Method to draw lines
    public void drawLine(int x, int y, int x2, int y2, int color) {
        mPaint.setColor(color);
        mCanvas.drawLine(x, y, x2, y2, mPaint);
    }

    public void drawRect(int x, int y, int width, int height, int color) {
        mPaint.setColor(color);
        mPaint.setStyle(Paint.Style.FILL);
        mCanvas.drawRect(x, y, x + width - 1, y + height - 1, mPaint);

    }

    public void drawImage(GameImage image, int x, int y,
                          int srcX, int srcY, int srcWidth, int srcHeight) {

        mSourceRect.left = srcX;
        mSourceRect.top = srcY;
        mSourceRect.right = srcX + srcWidth;
        mSourceRect.bottom = srcY + srcHeight;

        mDestinationRect.left = x;
        mDestinationRect.top = y;
        mDestinationRect.right = x + srcWidth;
        mDestinationRect.bottom = y + srcHeight;

        mCanvas.drawBitmap(image.mBitmap, mSourceRect, mDestinationRect, null);

    }

    public void drawString(String text, int x, int y, Paint paint) {
        mCanvas.drawText(text, x, y, paint);
    }

    public void drawImage(GameImage image, int x, int y){
        mCanvas.drawBitmap(image.mBitmap, x, y, null);

    }

    public void drawScaledImage(GameImage image, int x, int y, int width, int height){
        mDestinationRect.left = x;
        mDestinationRect.top = y;
        mDestinationRect.right = x + width;
        mDestinationRect.bottom = y + height;
        mCanvas.drawBitmap(image.mBitmap, null, mDestinationRect, null);
    }

    public int getWidth() {
        return mFrameBuffer.getWidth();
    }

    public int getHeight() {
        return mFrameBuffer.getHeight();
    }

    public void drawARGB(int a, int r, int g, int b) {
        mPaint.setStyle(Paint.Style.FILL);
        mCanvas.drawARGB(a,r,g,b);
    }


}
