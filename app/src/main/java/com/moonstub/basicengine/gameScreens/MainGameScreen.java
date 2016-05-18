package com.moonstub.basicengine.gameScreens;

import android.graphics.Color;

import com.moonstub.basicengine.GameAssets;
import com.moonstub.basicengine.GameState;
import com.moonstub.basicengine.framework.Colors;
import com.moonstub.basicengine.framework.GameActivity;
import com.moonstub.basicengine.framework.GameGraphics;
import com.moonstub.basicengine.framework.GameScreen;
import com.moonstub.basicengine.gameClasses.ActionButton;
import com.moonstub.basicengine.gameClasses.BaseEntity;
import com.moonstub.basicengine.gameClasses.Enemy;
import com.moonstub.basicengine.gameClasses.PlayerClass;

import java.util.ArrayList;

/**
 * Created by Micah on 5/3/2016.
 */
public class MainGameScreen extends GameScreen {

    GameState mGameState = GameState.INIT;

    ArrayList<Enemy> mEnemyArrayList;

    PlayerClass playerOne;

    ActionButton leftButton;
    ActionButton rightButton;

    ArrayList<BaseEntity> protectiveBase;
    ArrayList<BaseEntity> protectiveBase_2;
    ArrayList<BaseEntity> protectiveBase_3;

    public MainGameScreen(GameActivity game) {
        super(game);
    }

    @Override
    public void init() {
        GameAssets.TestAsset = getGameGraphics().newImage("testImage.png");

        mGameState = GameState.STARTING;

        playerOne = new PlayerClass(getGameActivity(),500, 1200);

        protectiveBase = new ArrayList<>();
        for(int indexY = 0; indexY < 3; indexY++){
            for(int indexX = 0; indexX < 3; indexX++){
                if(indexY * 3 + indexX == 4 || indexY * 3 + indexX == 7){

                }else{

                    protectiveBase.add(new BaseEntity((50 * indexX) + 200, (50 * indexY)+1000, 50));

                }

            }
        }
        protectiveBase_2 = new ArrayList<>();
        for(int indexY = 0; indexY < 3; indexY++){
            for(int indexX = 0; indexX < 3; indexX++){
                if(indexY * 3 + indexX == 4 || indexY * 3 + indexX == 7){

                }else{

                    protectiveBase_2.add(new BaseEntity((50 * indexX) + 500, (50 * indexY)+1000, 50));

                }

            }
        }
        protectiveBase_3 = new ArrayList<>();
        for(int indexY = 0; indexY < 3; indexY++){
            for(int indexX = 0; indexX < 3; indexX++){
                if(indexY * 3 + indexX == 4 || indexY * 3 + indexX == 7){

                }else{

                    protectiveBase_3.add(new BaseEntity((50 * indexX) + 800, (50 * indexY)+1000, 50));

                }

            }
        }

        playerOne = new PlayerClass(getGameActivity(),200,1000);
        playerOne.setColor(Color.BLUE);

        mEnemyArrayList = new ArrayList<>();
        for (int indexY = 0; indexY < 5; indexY++) {
            for(int indexX = 0; indexX < 10; indexX++)
            {
                mEnemyArrayList.add(new Enemy(getGameActivity(),(55 * indexX), (55 * indexY),50));
                int value = indexY * 10 + indexX;
                if(value % 2 == 0){
                    mEnemyArrayList.get(value).setIsAlive(false);
                }
            }
        }
    }

    @Override
    public void update(float delta) {
        switch (mGameState){
            case INIT:
                break;
            case GAME_OVER:
                gameOverUpdate();
                break;
            case PAUSED:
                gamePausedUpdate();
                break;
            case RUNNING:
                gameRunningUpdate(delta);
                break;
            case LOADING:
                break;
            case DEMO:
                break;
            case RESUME:
                break;
            case NEXT:
                break;
            case STARTING:
                gameStartingUpdate(delta);
                break;
            default:
                break;
        }
    }

    private void gamePausedUpdate() {

    }

    private void gameRunningUpdate(float delta) {

    }

    private void gameStartingUpdate(float delta) {

    }

    private void gameOverUpdate() {

    }

    @Override
    public void draw(float delta) {
        getGameGraphics().clearScreen(Colors.BLACK);
        getGameGraphics().drawString("New Game Screen", 300, 400, 35.0f, Color.BLUE);

        playerOne.draw(getGameGraphics());

        for (BaseEntity b : protectiveBase) {
            b.draw(getGameGraphics());
        }
        for (BaseEntity b : protectiveBase_2) {
            b.draw(getGameGraphics());
        }
        for (BaseEntity b : protectiveBase_3) {
            b.draw(getGameGraphics());
        }

        getGameGraphics().drawString("This Is White", 100,100);
        getGameGraphics().drawString("This is not White",100,300,45.0f,Color.MAGENTA);

        getGameGraphics().drawImage(GameAssets.TestAsset,200,200);

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
