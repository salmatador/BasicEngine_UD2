package com.moonstub.basicengine.screens;

import android.graphics.Color;

import com.moonstub.basicengine.GameState;
import com.moonstub.basicengine.MainMenuAssets;
import com.moonstub.basicengine.classes.TargetMap;
import com.moonstub.basicengine.framework.Colors;
import com.moonstub.basicengine.framework.GameActivity;
import com.moonstub.basicengine.framework.GameGraphics;
import com.moonstub.basicengine.framework.GameScreen;
import com.moonstub.basicengine.input.TouchEvent;

import java.util.ArrayList;

/**
 * Created by Micah on 2/16/2016.
 */
public class MainMenuScreen extends GameScreen{

    TargetMap[] mTargetMap;

    public MainMenuScreen(GameActivity game) {
        super(game);
    }

    @Override
    public void init() {

        mTargetMap = new TargetMap[3];
        //Load Main Menu Assets
        MainMenuAssets.Background = getGameGraphics().newImage("main_menu_assets/menuindex.png", GameGraphics.ImageFormat.ARGB8888);
        MainMenuAssets.PlayPressed = getGameGraphics().newImage("main_menu_assets/menustart.png", GameGraphics.ImageFormat.ARGB8888);
        mTargetMap[0] = new TargetMap(0,0,100,100);
        MainMenuAssets.SettingsPressed = getGameGraphics().newImage("main_menu_assets/menusetting.png", GameGraphics.ImageFormat.ARGB8888);
        mTargetMap[1] = new TargetMap(0,200,100,100);
        MainMenuAssets.CreditPressed = getGameGraphics().newImage("main_menu_assets/menucredit.png", GameGraphics.ImageFormat.ARGB8888);
        mTargetMap[2] = new TargetMap(0,400,100,100);


    }

    @Override
    public void update(float delta) {
        switch (mGameState){
            case INIT:
                break;
            case GAME_OVER:
                break;
            case PAUSED:
                break;
            case RUNNING:
                break;
            case LOADING:
                break;
            case DEMO:
                break;
            case RESUME:
                break;
            case NEXT:
                break;
            default:

        }

        ArrayList<TouchEvent.TouchEvents> events = (ArrayList<TouchEvent.TouchEvents>) getGameActivity()
                .getGameInput().getTouchEvents();

        if(events.size() > 0){
            getGameActivity().setCurrentScreen(new GameBoardScreen(getGameActivity()));

        }
    }

    @Override
    public void draw(float delta) {
        getGameGraphics().clearScreen(Colors.GRAY);
        getGameGraphics().drawImage(MainMenuAssets.Background, 0, 0);
        getGameGraphics().drawImage(MainMenuAssets.PlayPressed,0,0);
        getGameGraphics().drawImage(MainMenuAssets.SettingsPressed,0,0);
        getGameGraphics().drawImage(MainMenuAssets.CreditPressed, 0,0);

        getGameGraphics().drawRect(mTargetMap[0].getBounds(), Color.WHITE);
        getGameGraphics().drawRect(mTargetMap[1].getBounds(), Color.WHITE);
        getGameGraphics().drawRect(mTargetMap[2].getBounds(), Color.WHITE);
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
        return true;
    }
}
