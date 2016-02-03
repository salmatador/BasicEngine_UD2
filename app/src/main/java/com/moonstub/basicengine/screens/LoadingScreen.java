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
    public AnimateImage orangeGem;
    public AnimateImage purpleGem;
    public AnimateImage redGem;
    public AnimateImage whiteGem;
    public AnimateImage yellowGem;
    public AnimateImage blueBomb;
    public AnimateImage greenBomb;
    public AnimateImage orangeBomb;
    public AnimateImage purpleBomb;
    public AnimateImage redBomb;
    public AnimateImage whiteBomb;
    public AnimateImage yellowBomb;
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
        GameAssets.OrangeGem = getGameGraphics().newImage("orange.png", GameGraphics.ImageFormat.ARGB8888);
        GameAssets.PurpleGem = getGameGraphics().newImage("purple.png", GameGraphics.ImageFormat.ARGB8888);
        GameAssets.YellowGem = getGameGraphics().newImage("yellow.png", GameGraphics.ImageFormat.ARGB8888);
        GameAssets.WhiteGem = getGameGraphics().newImage("white.png", GameGraphics.ImageFormat.ARGB8888);
        GameAssets.RedGem = getGameGraphics().newImage("red.png", GameGraphics.ImageFormat.ARGB8888);
        GameAssets.BombGem = getGameGraphics().newImage("bomb.png", GameGraphics.ImageFormat.ARGB8888);

        GameAssets.Green3Bomb = getGameGraphics().newImage("3green.png", GameGraphics.ImageFormat.ARGB8888);
        GameAssets.Blue3Bomb = getGameGraphics().newImage("3blue.png", GameGraphics.ImageFormat.ARGB8888);
        GameAssets.Orange3Bomb = getGameGraphics().newImage("3orange.png", GameGraphics.ImageFormat.ARGB8888);
        GameAssets.Purple3Bomb = getGameGraphics().newImage("3purple.png", GameGraphics.ImageFormat.ARGB8888);
        GameAssets.Yellow3Bomb = getGameGraphics().newImage("3yellow.png", GameGraphics.ImageFormat.ARGB8888);
        GameAssets.White3Bomb = getGameGraphics().newImage("3white.png", GameGraphics.ImageFormat.ARGB8888);
        GameAssets.Red3Bomb = getGameGraphics().newImage("3red.png", GameGraphics.ImageFormat.ARGB8888);

        blueGem = new AnimateImage(getGameActivity(),GameAssets.BlueGem,50,50,24);
        blueGem.LoadImageArray();

        greenGem = new AnimateImage(getGameActivity(),GameAssets.GreenGem,50,50,24);
        greenGem.LoadImageArray();

        bombGem = new AnimateImage(getGameActivity(),GameAssets.BombGem,50,50,24);
        bombGem.LoadImageArray();

        orangeGem = new AnimateImage(getGameActivity(),GameAssets.OrangeGem,50,50,24);
        orangeGem.LoadImageArray();

        purpleGem = new AnimateImage(getGameActivity(),GameAssets.PurpleGem,50,50,24);
        purpleGem.LoadImageArray();

        yellowGem = new AnimateImage(getGameActivity(),GameAssets.YellowGem,50,50,24);
        yellowGem.LoadImageArray();

        whiteGem = new AnimateImage(getGameActivity(),GameAssets.WhiteGem,50,50,24);
        whiteGem.LoadImageArray();

        redGem = new AnimateImage(getGameActivity(),GameAssets.RedGem,50,50,24);
        redGem.LoadImageArray();

        blueBomb = new AnimateImage(getGameActivity(),GameAssets.Blue3Bomb,150,50,24);
        blueBomb.LoadImageArray();

        greenBomb = new AnimateImage(getGameActivity(),GameAssets.Green3Bomb,150,50,24);
        greenBomb.LoadImageArray();

        //bombBomb = new AnimateImage(getGameActivity(),GameAssets.BombGem,50,50,24);
        //bombBomb.LoadImageArray();

        orangeBomb = new AnimateImage(getGameActivity(),GameAssets.Orange3Bomb,150,50,24);
        orangeBomb.LoadImageArray();

        purpleBomb = new AnimateImage(getGameActivity(),GameAssets.Purple3Bomb,150,50,24);
        purpleBomb.LoadImageArray();

        yellowBomb = new AnimateImage(getGameActivity(),GameAssets.Yellow3Bomb,150,50,24);
        yellowBomb.LoadImageArray();

        whiteBomb = new AnimateImage(getGameActivity(),GameAssets.White3Bomb,150,50,24);
        whiteBomb.LoadImageArray();

        redBomb = new AnimateImage(getGameActivity(),GameAssets.Red3Bomb,150,50,24);
        redBomb.LoadImageArray();


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
        getGameGraphics().drawImage(orangeGem.getImage(index), 250, 250);
        getGameGraphics().drawImage(greenGem.getImage(index), 300, 250);
        getGameGraphics().drawImage(blueGem.getImage(index), 350, 250);
        getGameGraphics().drawImage(redGem.getImage(index),400,250);
        getGameGraphics().drawImage(yellowGem.getImage(index), 300, 300);
        getGameGraphics().drawImage(purpleGem.getImage(index),350,300);
        getGameGraphics().drawImage(whiteGem.getImage(index),400,300);
        getGameGraphics().drawImage(bombGem.getImage(index),400,350);

        getGameGraphics().drawImage(orangeBomb.getImage(index), 0, 0);
        getGameGraphics().drawImage(greenBomb.getImage(index), 150, 50);
        getGameGraphics().drawImage(blueBomb.getImage(index), 300, 150);
        getGameGraphics().drawImage(redBomb.getImage(index),450,250);
        getGameGraphics().drawImage(yellowBomb.getImage(index), 600, 350);
        getGameGraphics().drawImage(purpleBomb.getImage(index),50,450);
        getGameGraphics().drawImage(whiteBomb.getImage(index),0,500);








        currentTime = delta + currentTime;
        animationTime = 15.0f;
        if(currentTime > animationTime) {
            currentTime = 0.0f;
            if(index == 0){
                animationTime = 15.0f;
            }
            index++;
            if (index > 23) {
                index = 0;
        //        animationTime = 90f;
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
        getGameActivity().setCurrentScreen(new GameBoardScreen(getGameActivity()));
        return false;
    }
}
