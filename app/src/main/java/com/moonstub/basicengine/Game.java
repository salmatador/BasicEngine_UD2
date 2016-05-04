package com.moonstub.basicengine;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.Log;

import com.moonstub.basicengine.framework.Colors;
import com.moonstub.basicengine.framework.GameActivity;
import com.moonstub.basicengine.framework.GameScreen;
import com.moonstub.basicengine.gameClasses.ActionButton;
import com.moonstub.basicengine.gameClasses.BaseEntity;
import com.moonstub.basicengine.gameClasses.Enemy;
import com.moonstub.basicengine.gameClasses.PlayerClass;
import com.moonstub.basicengine.gameScreens.MainGameScreen;
import com.moonstub.basicengine.input.TouchEvent;

import java.util.ArrayList;
import java.util.List;

public class Game extends GameActivity {

    protected GameScreen initializeScreen() {
        return new TestScreen(this);
    }

    private class TestScreen extends GameScreen {

        int x = 0;
        int y = 0;
        int size = 100;
        int step = 20;
        boolean currentColor;
        Enemy testEnemy;
        ArrayList<Enemy> mEnemyArrayList;
        PlayerClass playerOne;
        PlayerClass playerTwo;
        ActionButton testButton;
        ActionButton testButton2;

        ArrayList<PlayerClass> mPlayerClassArrayList;

        BaseEntity testBaseEntity;

        public TestScreen(Game game) {
            super(game);
        }

        @Override
        public void init() {

            testBaseEntity = new BaseEntity(500,500,50);

            testEnemy = new Enemy(getGameActivity(), 50,50,50);
            testButton = new ActionButton(50,1200,100);
            testButton2 = new ActionButton(850,1200,100);
            playerOne = new PlayerClass(getGameActivity(),200,1000);
            playerOne.setColor(Color.BLUE);
            playerTwo = new PlayerClass(getGameActivity(),0,400);
            playerTwo.setColor(Color.RED);

            mPlayerClassArrayList = new ArrayList<>();
                for (int xIndex = 0; xIndex < 4; xIndex++) {
                    mPlayerClassArrayList.add(new PlayerClass(getGameActivity(),xIndex * 100
                            , xIndex * 100));
                    //mPlayerClassArrayList.get(index).setColor(index);
                }

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
            List<TouchEvent.TouchEvents> event = getGameActivity().getGameInput().getTouchEvents();

            if(event.size() > 0){
                if(testButton.getBounds().contains(event.get(0).x,event.get(0).y)){
                    testButton.setIsTouched(!testButton.isTouched());
                } else if(testButton2.getBounds().contains(event.get(0).x,event.get(0).y)){
                    testButton2.setIsTouched(!testButton2.isTouched());
                } else {
                    if(event.get(0).type == 2) {
                        playerOne.fire();
                    }
                }

                x = event.get(0).x;
                y = event.get(0).y;

                Log.d("Test Button", testButton.getX() + " , " + testButton.getY() +
                " : " + event.get(0).x + " , " + event.get(0).y);
            }
            if(event.size() > 1){

            }
            for(int index = 0; index < mPlayerClassArrayList.size();
                    index++){
                mPlayerClassArrayList.get(index).move(-10);
            }
            if(testButton.isTouched()) {
                testButton2.setIsTouched(false);
                playerOne.move(-10);

            }
            if(testButton2.isTouched()){
                testButton.setIsTouched(false);
                playerOne.move(10);
            }
            playerOne.update(mEnemyArrayList);
            //testEnemy.update();
            for (int index = 0; index < mEnemyArrayList.size(); index++) {
                if(mEnemyArrayList.get(index).wallCheck()){
                    mEnemyArrayList.get(index).phoneHome(mEnemyArrayList);
                    break;
                }
            }
            for(int index = 0; index < mEnemyArrayList.size(); index++){
                mEnemyArrayList.get(index).update();
            }

        }

        @Override
        public void draw(float delta) {

            getGameGraphics().clearScreen((currentColor) ? Colors.BLACK : Colors.BLACK);

            for(int index = 0; index < mPlayerClassArrayList.size();
                index++){
                mPlayerClassArrayList
                        .get(index).draw(getGameGraphics());
            }

            testButton.draw(getGameGraphics());
            testButton2.draw(getGameGraphics());

            playerOne.draw(getGameGraphics());
            playerTwo.draw(getGameGraphics());

            for(int index = 0; index < mEnemyArrayList.size(); index++){
                mEnemyArrayList.get(index).draw(getGameGraphics());
            }

            testBaseEntity.draw(getGameGraphics());

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
            getGameActivity().setCurrentScreen(new MainGameScreen(getGameActivity()));
            return false;
        }
    }
}
