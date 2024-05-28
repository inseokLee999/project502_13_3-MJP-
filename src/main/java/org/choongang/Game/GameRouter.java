package org.choongang.Game;

import org.choongang.Game.controller.GameControllerLocator;
import org.choongang.Game.controller.GameController;
import org.choongang.global.*;
import org.choongang.global.constants.GameMenu;

public class GameRouter implements GMRouter {
    private static GMRouter instance;
    private GameRouter(){}
    public static GMRouter getInstance(){
        if(instance == null){
            instance = new GameRouter();
        }
        return instance;
    }
    @Override
    public void changeGM(GameMenu gameMenu) {
        GMControllerLocator gamelocator = GameControllerLocator.getInstance();
        GMController gmcontroller = null;
        switch (gameMenu){
            case GAMEPVC: gmcontroller = gamelocator.find(GameMenu.GAMEPVC); break;
            case GAMEPVP: gmcontroller = gamelocator.find(GameMenu.GAMEPVP); break;
            default: gmcontroller = new GameController();
        }
        gmcontroller.run();
    }

    @Override
    public void start() {

    }
}
