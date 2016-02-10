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
    float deltaSlow = 35.0f;
    float actualDeltaSlow = 0.0f;

    int eventX = 0,eventY = 0;
    int testX = 0,testY = 0;
    GameGrid[] gemGrid;

    public GameBoardScreen(GameActivity game) {
        super(game);
    }

    @Override
    public void init() {
        gems = new AnimateImage[8];
        gameBoard = new GameGrid[64];
        gemGrid = new GameGrid[2];
        gemGrid[0] = null;
        gemGrid[1] = null;

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

        if(events.size() > 0) {
            testX = events.get(0).x; // Replace 50 with variable
            testY = events.get(0).y; // Ditto

            eventX = testX / 50;
            eventY = testY / 50;
            //Check which index is touched if any

            int index = eventY * 8 + eventX;

            if (index < 64 && index >= 0) {

                if (gemGrid[0] == null) {
                    gemGrid[0] = gameBoard[index];
                } else {
                    gemGrid[1] = gameBoard[index];
                    swapGems();
                }
            }
        }

//        if(events.size() > 0){
//            eventX = events.get(0).x;
//            eventY = events.get(0).y;
//
//            if(gemGrid[0] == null){
//                for(int i = 0; i < gameBoard.length;i++) {
//                    if(gameBoard[i].bounds().contains(eventX + 25, eventY)){
//                        gemGrid[0] = gameBoard[i];
//                        break;
//                    }
//                }
//            } else if(gemGrid[1] == null){
//                for(int i = 0; i < gameBoard.length;i++) {
//                    if(gameBoard[i].bounds().contains(eventX + 25, eventY)){
//                        gemGrid[1] = gameBoard[i];
//                        break;
//                    }
//                }
//                if(gemGrid[1] == null || gemGrid[1].equals(gemGrid[0])){
//                    gemGrid[0] = null;
//                }
//            } else if(!gemGrid[0].equals(gemGrid[1])){
//                int index = gemGrid[0].getGemIndex();
//                gemGrid[0].setGemIndex(gemGrid[1].getGemIndex());
//                gemGrid[1].setGemIndex(index);
//                gemGrid[0] = null;
//                gemGrid[1] = null;
//            }

            //for(GameGrid grid : gameBoard){
            //    gemGrid[gemGrid[0] == null ? 0 : 1] = grid.bounds().contains(eventX-25,eventY) ? grid : null;
            //}




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



    private void swapGems() {
        int tempGemIndex;
        tempGemIndex = gemGrid[0].getGemIndex();
        gemGrid[0].setGemIndex(gemGrid[1].getGemIndex());
        gemGrid[1].setGemIndex(tempGemIndex);

        gemGrid[0] = null;
        gemGrid[1] = null;
    }
    private void checkMatchGrid() {
        ArrayList<GameGrid> matches = new ArrayList<>();
        ArrayList<GameGrid> matchesY = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < 64; i++){
            GameGrid c = gameBoard[i];
            count=0;
            for(int x = 1; x < 8; x++) {
                if (i + x < 64 && c.getGemIndex() == gameBoard[i + x].getGemIndex() &&
                        ((i + x) % 8) != 0) {
                    if(count == 0){
                        matches.add(c);
                    }
                    count++;
                    matches.add(gameBoard[i+x]);
                } else {
                    if(count==1){
                        matches.remove(matches.size()-1);
                        matches.remove(matches.size()-1);
                    }
                    break;
                }
            }
            count=0;
            for(int y = 1; y < 8; y++){
                if(i + (y * 8) < 64 && c.getGemIndex() == gameBoard[i + (y*8)].getGemIndex() &&
                        ((i + y) % 8 != 0)){
                    if(count == 0){
                        matchesY.add(c);
                    }
                    count++;
                    matchesY.add(gameBoard[i + (y*8)]);
                }
                else{
                    if(count==1){
                        matchesY.remove(matchesY.size()-1);
                        matchesY.remove(matchesY.size()-1);
                    }
                    break;
                }
            }
        }
        if(matches.size() > 2){
            for(int j = 0; j < matches.size(); j++){
                matches.get(j).setGemIndex(0);
            }
            matches.clear();
        }

        if(matchesY.size() > 2){
            for(int j = 0; j < matchesY.size(); j++){
                matchesY.get(j).setGemIndex(0);
            }
            matchesY.clear();
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
        getPaint().setTextSize(60.f);
        if(gemGrid[0] != null){
            getGameGraphics().drawRect(gemGrid[0].bounds(), Color.RED);
        }
        if(gemGrid[1] != null) {
            getGameGraphics().drawRect(gemGrid[1].bounds(), Color.YELLOW);
        }
        getGameGraphics().drawString(eventX + " , " + eventY + " : ", 600,200,getPaint());
        getGameGraphics().drawString(testX + " , " + testY + " : ", 600,400,getPaint());

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
