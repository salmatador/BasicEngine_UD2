package com.moonstub.basicengine.screens;

import com.moonstub.basicengine.Game;
import com.moonstub.basicengine.GameAssets;
import com.moonstub.basicengine.classes.AnimateImage;
import com.moonstub.basicengine.framework.Colors;
import com.moonstub.basicengine.framework.GameActivity;
import com.moonstub.basicengine.framework.GameGraphics;
import com.moonstub.basicengine.framework.GameScreen;

import java.util.Random;

/**
 * Created by Micah on 1/12/2016.
 */
public class LoadingScreen extends GameScreen {

    public AnimateImage blueGem;
    public AnimateImage greenGem;
    public AnimateImage bombGem;
    int index = 0;
    float animationTime = 290.0f;
    float currentTime = 0.0f;

    public LoadingScreen(GameActivity game) {
        super(game);
    }

    @Override
    public void init() {
        GameAssets.GreenGem = getGameGraphics().newImage("green.png", GameGraphics.ImageFormat.ARGB8888);
        GameAssets.BlueGem = getGameGraphics().newImage("blue.png", GameGraphics.ImageFormat.ARGB8888);
        GameAssets.BombGem = getGameGraphics().newImage("bomb.png", GameGraphics.ImageFormat.ARGB8888);
        //while(GameAssets.BlueGem.getWidth() != 0){}
        blueGem = new AnimateImage(getGameActivity(),GameAssets.BlueGem,50,50,24);
        blueGem.LoadImageArray();

        greenGem = new AnimateImage(getGameActivity(),GameAssets.GreenGem,50,50,24);
        greenGem.LoadImageArray();

        bombGem = new AnimateImage(getGameActivity(),GameAssets.BombGem,50,50,24);
        bombGem.LoadImageArray();

    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void draw(float delta) {
        //Random rnd = new Random();
        //getGameGraphics().drawImage(GameAssets.BlueGem, 0, 0);
        //getGameGraphics().drawImage(GameAssets.GreenGem, 400,0);
        //int index = rnd.nextInt(20);

        //getGameGraphics().drawImage(blueGem.getImage(index),100,300);
        //getGameGraphics().drawImage(greenGem.getImage(index),400,300);

        getGameGraphics().clearScreen(Colors.BLACK);
        getGameGraphics().drawImage(greenGem.getImage(index),300,250);
        getGameGraphics().drawImage(blueGem.getImage(index), 350, 250);
        getGameGraphics().drawImage(greenGem.getImage(index),400,250);
        getGameGraphics().drawImage(bombGem.getImage(index), 300, 300);
        getGameGraphics().drawImage(bombGem.getImage(index),350,300);
        getGameGraphics().drawImage(bombGem.getImage(index),400,300);
        currentTime = delta + currentTime;
        if(currentTime > animationTime) {
            currentTime = 0.0f;
            if(index == 0){
                animationTime = 15.0f;
            }
            index++;
            if (index > 23) {
                index = 0;
                animationTime = 90f;
            }
        }

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public boolean onBackPressed() {
        return false;
    }
}
