package com.moonstub.basicengine.screens;

import android.util.Log;

import com.moonstub.basicengine.GameAssets;
import com.moonstub.basicengine.classes.AnimateImage;
import com.moonstub.basicengine.classes.GameGrid;
import com.moonstub.basicengine.framework.Colors;
import com.moonstub.basicengine.framework.GameActivity;
import com.moonstub.basicengine.framework.GameScreen;

/**
 * Created by Micah on 1/19/2016.
 */
public class GameBoardScreen extends GameScreen {

    AnimateImage[] gems;
    GameGrid[] gameBoard;
    boolean isFull = true;

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
        //if(!isFull) {
            isFull = checkGrid();
        //}
        //Check Grid for Zeros

        for(int index = 0; index < gameBoard.length; index++){
            gameBoard[index].setMaxFrame(gems[gameBoard[index].getGemIndex()].getFrameCount());
            gameBoard[index].updateFrame(delta);
        }
    }

    //This method checks the Game Grid in reverse for Empty Grids if it is Empty it pulls down from the
    // grid above if the grid is off screen it randomly chooses a new gem
    private boolean checkGrid() {
        boolean emptyGem = false;
        int index = 64;
        for(int i = 63; i > 0; i--){
                if (gameBoard[i].isEmpty()) {
                    if(i > 8){
                        gameBoard[i].setGemIndex(gameBoard[i - 8].getGemIndex());
                    } else {
                        gameBoard[i].setRandomGemIndex();
                    }
                }
            }

        for(int y = 8; y > 0; y--){
            for(int x = 8; x > 0; x--){
                index--;
                //Log.e("Log Index",index + " : " + x + " , " + y + " , " + (x%8) );
                if(gameBoard[index].getGemIndex() == 0){
                    if(y > 0 & index > 8) {
                        gameBoard[index].setGemIndex(gameBoard[index - 8].getGemIndex());
                        emptyGem = true;
                    }
                }
            }
        }
        return emptyGem;
    }

    @Override
    public void draw(float delta) {
        getGameGraphics().clearScreen(Colors.BLACK);
        for(int index = 0; index < gameBoard.length; index++){
            gameBoard[index].draw(getGameGraphics(), gems);
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
        return true;
    }
}
