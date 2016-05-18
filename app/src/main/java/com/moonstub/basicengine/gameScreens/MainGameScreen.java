package com.moonstub.basicengine.gameScreens;

import android.graphics.Color;

import com.moonstub.basicengine.GameAssets;
import com.moonstub.basicengine.GameState;
import com.moonstub.basicengine.classes.SimpleAnimate;
import com.moonstub.basicengine.framework.Colors;
import com.moonstub.basicengine.framework.GameActivity;
import com.moonstub.basicengine.framework.GameGraphics;
import com.moonstub.basicengine.framework.GameImage;
import com.moonstub.basicengine.framework.GameScreen;
import com.moonstub.basicengine.gameClasses.ActionButton;
import com.moonstub.basicengine.gameClasses.BaseEntity;
import com.moonstub.basicengine.gameClasses.Enemy;
import com.moonstub.basicengine.gameClasses.PlayerClass;
import com.moonstub.basicengine.gameClasses.ProtectiveBase;
import com.moonstub.basicengine.input.TouchEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Micah on 5/3/2016.
 */
public class MainGameScreen extends GameScreen {

    //GameState mGameState = GameState.INIT;

    ArrayList<Enemy> mEnemyArrayList;

    PlayerClass playerOne;

    ActionButton leftButton;
    ActionButton rightButton;

    ArrayList<ProtectiveBase> protectiveBase;

    SimpleAnimate bobAnimate;

    GameImage[] bob;

    public MainGameScreen(GameActivity game) {
        super(game);
    }

    @Override
    public void init() {

        GameAssets.Bob_Open = getGameGraphics().newImage("a10.png");
        GameAssets.Bob_Close = getGameGraphics().newImage("a11.png");
        bob = new GameImage[]{GameAssets.Bob_Open,GameAssets.Bob_Close};
        bobAnimate = new SimpleAnimate(new GameImage[]{GameAssets.Bob_Open,GameAssets.Bob_Close});

        mGameState = GameState.STARTING;

        playerOne = new PlayerClass(getGameActivity(),500, 1200);

        protectiveBase = new ArrayList<>();
        protectiveBase.add(new ProtectiveBase(200,1300,50));
        protectiveBase.add(new ProtectiveBase(500,1300,50));
        protectiveBase.add(new ProtectiveBase(800,1300,50));

        playerOne = new PlayerClass(getGameActivity(),200,1600);
        playerOne.setColor(Color.BLUE);

        mEnemyArrayList = new ArrayList<>();
        for (int indexY = 0; indexY < 5; indexY++) {
            for(int indexX = 0; indexX < 10; indexX++)
            {
                mEnemyArrayList.add(new Enemy(getGameActivity(),(55 * indexX), (55 * indexY),50));
                mEnemyArrayList.get(mEnemyArrayList.size() - 1).setSprite(bob);
                int value = indexY * 10 + indexX;
                if(value % 2 == 0){
                    mEnemyArrayList.get(value).setIsAlive(false);
                }
            }
        }

        mGameState = GameState.RUNNING;
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
        List<TouchEvent.TouchEvents> event = getGameActivity().getGameInput().getTouchEvents();

        if(event.size() > 0){
            mGameState = GameState.RUNNING;
        }
    }

    private void gameRunningUpdate(float delta) {
        bobAnimate.update(delta);

        playerOne.update(mEnemyArrayList);

        for (int index = 0; index < mEnemyArrayList.size(); index++) {
            if(mEnemyArrayList.get(index).wallCheck()){
                mEnemyArrayList.get(index).phoneHome(mEnemyArrayList);
                break;
            }
        }
        for(int index = 0; index < mEnemyArrayList.size(); index++){
            mEnemyArrayList.get(index).update(delta);
        }
    }

    private void gameStartingUpdate(float delta) {

    }

    private void gameOverUpdate() {

    }

    @Override
    public void draw(float delta) {
        defaultDraw(delta);
        getGameGraphics().drawString("New Game Screen", 300, 400, 35.0f, Color.BLUE);

        switch (mGameState){
            case INIT:
                break;
            case GAME_OVER:
                drawGameOver();
                break;
            case PAUSED:
                drawPaused();
                break;
            case RUNNING:
                drawRunning();
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
                break;
        }





        //getGameGraphics().drawString("This Is White", 100,100);
        //getGameGraphics().drawString("This is not White",100,300,45.0f,Color.MAGENTA);

        //getGameGraphics().drawImage(GameAssets.TestAsset,200,200);

    }

    private void drawRunning() {
        bobAnimate.draw(getGameGraphics());
    }

    private void drawGameOver() {
        getGameGraphics().drawString("Game Over Man!!!",300,900,75.0f, Color.RED);
    }

    private void drawPaused() {
        getGameGraphics().drawString("Game is Paused",300,900,75.0f, Color.RED);
    }

    private void defaultDraw(float delta) {
        getGameGraphics().clearScreen(Colors.BLACK);

        for(ProtectiveBase p : protectiveBase){
            p.draw(getGameGraphics());
        }

        for(int index = 0; index < mEnemyArrayList.size(); index++){
            mEnemyArrayList.get(index).draw(getGameGraphics());
        }

        playerOne.draw(getGameGraphics());

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
        if(mGameState != GameState.PAUSED){
            mGameState = GameState.PAUSED;
            return false;
        } else {
            return true;
        }
    }
}
