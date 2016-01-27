package com.moonstub.basicengine;

import com.moonstub.basicengine.framework.GameImage;
import com.moonstub.basicengine.input.GameInput;

public class GameAssets {

    //GameAssets

    public enum LoadingScreens {
        Splash,
        MainMenu,
        GameBoard;
        //Add more options for more screens Loading Screen Loads Assets
    }

    public static GameImage BlueGem;
    public static GameImage GreenGem;
    public static GameImage BombGem;
    //Splash Screen Assets
    public static GameImage SplashImage;
    //MainMenu Assets
    public static GameImage PlayBtnMenu;
    public static GameImage PlayBtnMenuDefault;
    public static GameImage PlayBtnMenuPressed;
    public static GameImage PlayBtnMenu_Depressed;
    public static GameImage HowToPlayBtnMenu;
    public static GameImage HowToPlayBtnMenu_Depressed;

}
