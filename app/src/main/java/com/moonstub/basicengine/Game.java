package com.moonstub.basicengine;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.Log;

import com.moonstub.basicengine.framework.Colors;
import com.moonstub.basicengine.framework.GameActivity;
import com.moonstub.basicengine.framework.GameScreen;
import com.moonstub.basicengine.gameClasses.ActionButton;
import com.moonstub.basicengine.gameClasses.Enemy;
import com.moonstub.basicengine.gameClasses.PlayerClass;
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


        public TestScreen(Game game) {
            super(game);
        }

        @Override
        public void init() {
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
            for (int index = 0; index < 5; index++) {
                mEnemyArrayList.add(new Enemy(getGameActivity(),(50 * index), 50,25));
            }

        }

        @Override
        public void update(float delta) {
            List<TouchEvent.TouchEvents> event = getGameActivity().getGameInput().getTouchEvents();
            //Log.d("Test Screen",
            //        x + " : " + getGameGraphics().getWidth());
//            if( x >= 440) {
//                x = 440;
//                step = step * -1;
//            }
//
//            if(x < 0 ){
//                x = 0;
//                step = step * -1;
//            }

//            x = x + step;


            if(event.size() > 0){
                //currentColor = !currentColor;
                if(testButton.getBounds().contains(event.get(0).x,event.get(0).y)){
                    testButton.setIsTouched(!testButton.isTouched());
                } else if(testButton2.getBounds().contains(event.get(0).x,event.get(0).y)){
                    testButton2.setIsTouched(!testButton2.isTouched());
                } else {
                    if(event.get(0).type == 2) {
                        playerOne.fire();
                    }
                }

                x = event.get(0).x/ 2;
                y = event.get(0).y/ 2;

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
            playerOne.update();
            //testEnemy.update();
            for (int index = 0; index < mEnemyArrayList.size(); index++) {
                mEnemyArrayList.get(index).update(mEnemyArrayList);
            }

        }

        @Override
        public void draw(float delta) {

            getGameGraphics().clearScreen((currentColor) ? Colors.BLACK : Colors.BLACK);
            //getGameGraphics().drawFillRect(new Rect(x, y, x + size, y + size), Color.CYAN);


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
            //for (Enemy e : mEnemyArrayList) {
            //    e.draw(getGameGraphics());
            //}
            //testEnemy.draw(getGameGraphics());
            //getPaint().setColor(Color.WHITE);
            //getPaint().setTextSize(50.0f);
            //getGameGraphics().drawString(x + " : " + y,100,200,getPaint());

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
}
