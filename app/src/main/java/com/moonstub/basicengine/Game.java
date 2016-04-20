package com.moonstub.basicengine;

import com.moonstub.basicengine.framework.GameActivity;
import com.moonstub.basicengine.framework.GameScreen;

public class Game extends GameActivity {

    protected GameScreen initializeScreen() {
        return new TestScreen(this);
    }

    private class TestScreen extends GameScreen {
        public TestScreen(Game game) {
            super(game);
        }

        @Override
        public void init() {

        }

        @Override
        public void update(float delta) {

        }

        @Override
        public void draw(float delta) {

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
