package com.moonstub.basicengine;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.Log;

import com.moonstub.basicengine.framework.Colors;
import com.moonstub.basicengine.framework.GameActivity;
import com.moonstub.basicengine.framework.GameScreen;
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
        PlayerClass playerOne;
        PlayerClass playerTwo;

        ArrayList<PlayerClass> mPlayerClassArrayList;


        public TestScreen(Game game) {
            super(game);
        }

        @Override
        public void init() {
            playerOne = new PlayerClass(400,400);
            playerOne.setColor(Color.BLUE);
            playerTwo = new PlayerClass(0,400);
            playerTwo.setColor(Color.RED);

            mPlayerClassArrayList = new ArrayList<>();
                for (int xIndex = 0; xIndex < 4; xIndex++) {
                    mPlayerClassArrayList.add(new PlayerClass(xIndex * 100
                            , xIndex * 100));
                    //mPlayerClassArrayList.get(index).setColor(index);
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
                currentColor = !currentColor;
                x = event.get(0).x/ 2;
                y = event.get(0).y/ 2;
            }
            for(int index = 0; index < mPlayerClassArrayList.size();
                    index++){
                mPlayerClassArrayList.get(index).move(-10);
            }
        }

        @Override
        public void draw(float delta) {

            getGameGraphics().clearScreen((currentColor) ? Colors.BLACK : Colors.GRAY);
            //getGameGraphics().drawFillRect(new Rect(x, y, x + size, y + size), Color.CYAN);


            for(int index = 0; index < mPlayerClassArrayList.size();
                index++){
                mPlayerClassArrayList
                        .get(index).draw(getGameGraphics());
            }

            playerOne.draw(getGameGraphics());
            playerTwo.draw(getGameGraphics());
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
