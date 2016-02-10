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

    public AnimateImage blueGem3H;
    public AnimateImage blueGem3V;
    public AnimateImage greenGem3H;
    public AnimateImage greenGem3V;
    public AnimateImage orangeGem3H;
    public AnimateImage orangeGem3V;
    public AnimateImage whiteGem3H;
    public AnimateImage whiteGem3V;
    public AnimateImage yellowGem3H;
    public AnimateImage yellowGem3V;
    public AnimateImage redGem3H;
    public AnimateImage redGem3V;
    public AnimateImage purpleGem3H;
    public AnimateImage purpleGem3V;

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

        GameAssets.BlueGem3H = getGameGraphics().newImage("3blueH.png", GameGraphics.ImageFormat.ARGB8888);
        GameAssets.BlueGem3V = getGameGraphics().newImage("3blueV.png", GameGraphics.ImageFormat.ARGB8888);

        blueGem3H = new AnimateImage(getGameActivity(),GameAssets.BlueGem3H,150,50,27);
        blueGem3H.LoadImageArray();

        blueGem3V = new AnimateImage(getGameActivity(),GameAssets.BlueGem3V,50,150,27);
        blueGem3V.LoadImageArrayVertical();

        GameAssets.GreenGem3H = getGameGraphics().newImage("3greenH.png", GameGraphics.ImageFormat.ARGB8888);
        GameAssets.GreenGem3V = getGameGraphics().newImage("3greenV.png", GameGraphics.ImageFormat.ARGB8888);

        greenGem3H = new AnimateImage(getGameActivity(),GameAssets.GreenGem3H,150,50,27);
        greenGem3H.LoadImageArray();

        greenGem3V = new AnimateImage(getGameActivity(),GameAssets.GreenGem3V,50,150,27);
        greenGem3V.LoadImageArrayVertical();

        GameAssets.RedGem3H = getGameGraphics().newImage("3redH.png", GameGraphics.ImageFormat.ARGB8888);
        GameAssets.RedGem3V = getGameGraphics().newImage("3redV.png", GameGraphics.ImageFormat.ARGB8888);

        redGem3H = new AnimateImage(getGameActivity(),GameAssets.RedGem3H,150,50,27);
        redGem3H.LoadImageArray();

        redGem3V = new AnimateImage(getGameActivity(),GameAssets.RedGem3V,50,150,27);
        redGem3V.LoadImageArrayVertical();


        GameAssets.WhiteGem3H = getGameGraphics().newImage("3whiteH.png", GameGraphics.ImageFormat.ARGB8888);
        GameAssets.WhiteGem3V = getGameGraphics().newImage("3whiteV.png", GameGraphics.ImageFormat.ARGB8888);

        whiteGem3H = new AnimateImage(getGameActivity(),GameAssets.WhiteGem3H,150,50,27);
        whiteGem3H.LoadImageArray();

        whiteGem3V = new AnimateImage(getGameActivity(),GameAssets.WhiteGem3V,50,150,27);
        whiteGem3V.LoadImageArrayVertical();


        GameAssets.YellowGem3H = getGameGraphics().newImage("3yellowH.png", GameGraphics.ImageFormat.ARGB8888);
        GameAssets.YellowGem3V = getGameGraphics().newImage("3yellowV.png", GameGraphics.ImageFormat.ARGB8888);

        yellowGem3H = new AnimateImage(getGameActivity(),GameAssets.YellowGem3H,150,50,27);
        yellowGem3H.LoadImageArray();

        yellowGem3V = new AnimateImage(getGameActivity(),GameAssets.YellowGem3V,50,150,27);
        yellowGem3V.LoadImageArrayVertical();

        GameAssets.OrangeGem3H = getGameGraphics().newImage("3orangeH.png", GameGraphics.ImageFormat.ARGB8888);
        GameAssets.OrangeGem3V = getGameGraphics().newImage("3orangeV.png", GameGraphics.ImageFormat.ARGB8888);

        orangeGem3H = new AnimateImage(getGameActivity(),GameAssets.OrangeGem3H,150,50,27);
        orangeGem3H.LoadImageArray();

        orangeGem3V = new AnimateImage(getGameActivity(),GameAssets.OrangeGem3V,50,150,27);
        orangeGem3V.LoadImageArrayVertical();


        GameAssets.PurpleGem3H = getGameGraphics().newImage("3purpleH.png", GameGraphics.ImageFormat.ARGB8888);
        GameAssets.PurpleGem3V = getGameGraphics().newImage("3purpleV.png", GameGraphics.ImageFormat.ARGB8888);

        purpleGem3H = new AnimateImage(getGameActivity(),GameAssets.PurpleGem3H,150,50,27);
        purpleGem3H.LoadImageArray();

        purpleGem3V = new AnimateImage(getGameActivity(),GameAssets.PurpleGem3V,50,150,27);
        purpleGem3V.LoadImageArrayVertical();


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

        getGameGraphics().drawImage(orangeGem3H.getImage(index), 0,0);
        getGameGraphics().drawImage(orangeGem3V.getImage(index), 0, 50);

        getGameGraphics().drawImage(blueGem3H.getImage(index), 50,50);
        getGameGraphics().drawImage(blueGem3V.getImage(index), 50, 100);

        getGameGraphics().drawImage(greenGem3H.getImage(index), 100,100);
        getGameGraphics().drawImage(greenGem3V.getImage(index), 100,150);

        getGameGraphics().drawImage(redGem3H.getImage(index), 150,150);
        getGameGraphics().drawImage(redGem3V.getImage(index), 150,200);

        getGameGraphics().drawImage(yellowGem3H.getImage(index), 200,200);
        getGameGraphics().drawImage(yellowGem3V.getImage(index), 200,250);

        getGameGraphics().drawImage(whiteGem3H.getImage(index), 250,250);
        getGameGraphics().drawImage(whiteGem3V.getImage(index), 250,300);

        getGameGraphics().drawImage(purpleGem3H.getImage(index), 300,300);
        getGameGraphics().drawImage(purpleGem3V.getImage(index), 300,350);


//        getGameGraphics().drawImage(orangeGem.getImage(index), 250, 250);
//        getGameGraphics().drawImage(greenGem.getImage(index), 300, 250);
//        getGameGraphics().drawImage(blueGem.getImage(index), 350, 250);
//        getGameGraphics().drawImage(redGem.getImage(index),400,250);
//        getGameGraphics().drawImage(yellowGem.getImage(index), 300, 300);
//        getGameGraphics().drawImage(purpleGem.getImage(index),350,300);
//        getGameGraphics().drawImage(whiteGem.getImage(index),400,300);
//        getGameGraphics().drawImage(bombGem.getImage(index),400,350);
//
//        getGameGraphics().drawImage(orangeBomb.getImage(index), 0, 0);
//        getGameGraphics().drawImage(greenBomb.getImage(index), 150, 50);
//        getGameGraphics().drawImage(blueBomb.getImage(index), 300, 150);
//        getGameGraphics().drawImage(redBomb.getImage(index),450,250);
//        getGameGraphics().drawImage(yellowBomb.getImage(index), 600, 350);
//        getGameGraphics().drawImage(purpleBomb.getImage(index),50,450);
//        getGameGraphics().drawImage(whiteBomb.getImage(index),0,500);









        currentTime = delta + currentTime;
        animationTime = 15.0f;
        if(currentTime > animationTime) {
            currentTime = 0.0f;
            if(index == 0){
                animationTime = 15.0f;
            }
            index++;
            if (index > 26) {
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
