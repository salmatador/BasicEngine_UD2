package com.moonstub.basicengine.gameScreens;

import android.graphics.Color;

import com.moonstub.basicengine.GameState;
import com.moonstub.basicengine.framework.Colors;
import com.moonstub.basicengine.framework.GameActivity;
import com.moonstub.basicengine.framework.GameScreen;

/**
 * Created by Micah on 5/3/2016.
 */
public class MainGameScreen extends GameScreen {

    GameState mGameState = GameState.INIT;

    public MainGameScreen(GameActivity game) {
        super(game);
    }

    @Override
    public void init() {
        mGameState = GameState.STARTING;
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
                //gameResumeUpdate(delta);
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
        getGameGraphics().clearScreen(Colors.GRAY);
        getPaint().setColor(Color.WHITE);
        getPaint().setTextSize(45.0f);
        getGameGraphics().drawString("New Game Screen", 100,100,getPaint());
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
