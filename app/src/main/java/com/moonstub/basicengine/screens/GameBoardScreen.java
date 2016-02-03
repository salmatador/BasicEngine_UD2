package com.moonstub.basicengine.screens;

import android.graphics.Color;
import android.util.Log;

import com.moonstub.basicengine.Game;
import com.moonstub.basicengine.GameAssets;
import com.moonstub.basicengine.classes.AnimateImage;
import com.moonstub.basicengine.classes.GameGrid;
import com.moonstub.basicengine.framework.Colors;
import com.moonstub.basicengine.framework.GameActivity;
import com.moonstub.basicengine.framework.GameScreen;
import com.moonstub.basicengine.framework.GameSettings;
import com.moonstub.basicengine.input.TouchEvent;

import java.util.ArrayList;

/**
 * Created by Micah on 1/19/2016.
 */
public class GameBoardScreen extends GameScreen {

    AnimateImage[] gems;
    GameGrid[] gameBoard;
    boolean isFull = true;
    float deltaSlow = 100.0f;
    float actualDeltaSlow = 0.0f;

    int eventX = 0,eventY = 0;

    public GameBoardScreen(GameActivity game) {
        super(game);
    }

    @Override
    public void init() {
        gems = new AnimateImage[8];
        gameBoard = new GameGrid[64];

        gems[1] = new AnimateImage(getGameActivity(), GameAssets.BlueGem,50,50,20);
        gems[2] = new AnimateImage(getGameActivity(), GameAssets.GreenGem,50,50,20);
        gems[3] = new AnimateImage(getGameActivity(), GameAssets.OrangeGem,50,50,20);
        gems[4] = new AnimateImage(getGameActivity(), GameAssets.PurpleGem,50,50,20);
        gems[5] = new AnimateImage(getGameActivity(), GameAssets.RedGem,50,50,21);
        gems[6] = new AnimateImage(getGameActivity(), GameAssets.WhiteGem,50,50,20);
        gems[7] = new AnimateImage(getGameActivity(), GameAssets.YellowGem,50,50,20);
        gems[0] = new AnimateImage(getGameActivity(), GameAssets.BombGem,50,50,24);

        for(int index = 0; index < gems.length; index++){
            gems[index].LoadImageArray();
        }

        int index = 0;
        for(int y = 0; y < 8; y++ ){
            for(int x = 0; x < 8; x++ ) {
                gameBoard[index] = new GameGrid(x,y,24);
                index++;
            }

        }

    }

    @Override
    public void update(float delta) {
      actualDeltaSlow = delta + actualDeltaSlow;

        ArrayList<TouchEvent.TouchEvents> events = (ArrayList<TouchEvent.TouchEvents>) getGameActivity()
                .getGameInput().getTouchEvents();

        if(events.size() > 0){
            eventX = events.get(0).x;
            eventY = events.get(0).y;
        }

        if(actualDeltaSlow > deltaSlow) {
            isFull = checkZeroGrid();
            if (isFull) {
                checkMatchGrid();
            }
            for (int index = 0; index < gameBoard.length; index++) {
                gameBoard[index].setMaxFrame(gems[gameBoard[index].getGemIndex()].getFrameCount());
                gameBoard[index].updateFrame(delta);
            }
            actualDeltaSlow = 0.0f;
        }
    }

    private void checkMatchGrid() {
        for(int i = 0; i < 64; i++){
            GameGrid c = gameBoard[i];
            ArrayList<GameGrid> matches = new ArrayList<>();
            matches.add(c);
            ArrayList<GameGrid> matchesY = new ArrayList<>();
            matchesY.add(c);
            //GameGrid[] matches = new GameGrid[8];
            //GameGrid[] matchesY = new GameGrid[8];
            //if(i % 8 < 6) {
                int count = 0;
                for(int x = 1; x < 8; x++) {
                    if (i + x < 64 && c.getGemIndex() == gameBoard[i + x].getGemIndex() &&
                            ((i + x) % 8) != 0) {
                        //count++;
                        matches.add(gameBoard[i+x]);
                    } else {
                        break;
                    }
                }

                for(int y = 1; y < 8; y++){
                    if(i + (y * 8) < 64 && c.getGemIndex() == gameBoard[i + (y*8)].getGemIndex() &&
                            ((i + y) % 8 != 0)){
                        //matchesY[0] = c;
                        matchesY.add(gameBoard[i + (y*8)]);
                    }
                }

                if(matches.size() > 2){
                    for(int j = 0; j < matches.size(); j++){
                        matches.get(j).setGemIndex(0);
                    }
                }

                if(matchesY.size() > 2){
                    for(int j = 0; j < matchesY.size(); j++){
                        matchesY.get(j).setGemIndex(0);
                    }
                }

            }
        }
    //}

    //This method checks the Game Grid in reverse for Empty Grids if it is Empty it pulls down from the
    // grid above if the grid is off screen it randomly chooses a new gem
    private boolean checkZeroGrid() {
        boolean notEmptyGem = true;

        for(int i = 63; i >= 0; i--){
                if (gameBoard[i].isEmpty()) {
                    if(i > 8){
                        gameBoard[i].setGemIndex(gameBoard[i - 8].getGemIndex());
                        gameBoard[i - 8].setGemIndex(0);
                    } else {
                        gameBoard[i].setRandomGemIndex();
                    }
                    notEmptyGem = false;
                }
            }

//        for(int y = 8; y > 0; y--){
//            for(int x = 8; x > 0; x--){
//                index--;
//                //Log.e("Log Index",index + " : " + x + " , " + y + " , " + (x%8) );
//                if(gameBoard[index].getGemIndex() == 0){
//                    if(y > 0 & index > 8) {
//                        gameBoard[index].setGemIndex(gameBoard[index - 8].getGemIndex());
//                        emptyGem = true;
//                    }
//                }
//            }
//        }
        return notEmptyGem;
    }

    @Override
    public void draw(float delta) {
        getGameGraphics().clearScreen(Colors.BLACK);
        for(int index = 0; index < gameBoard.length; index++){
            gameBoard[index].draw(getGameGraphics(), gems);
        }

        getPaint().setColor(Color.WHITE);
        getPaint().setTextSize(30.f);
        //getGameGraphics().drawString(gameBoard[14].bounds().contains(eventX, eventY) + "", 600, 400, getPaint());
        //if())
        getGameGraphics().drawRect(gameBoard[14].bounds(),
                gameBoard[14].bounds().contains(eventX+25,eventY) ? Color.RED : Color.YELLOW);
        getGameGraphics().drawString(eventX + " , " + eventY + " : ", 600,200,getPaint());
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
