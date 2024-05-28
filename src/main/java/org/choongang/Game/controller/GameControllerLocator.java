package org.choongang.Game.controller;

import org.choongang.global.GMController;
import org.choongang.global.GMControllerLocator;
import org.choongang.global.constants.GameMenu;

import java.util.HashMap;
import java.util.Map;

public class GameControllerLocator implements GMControllerLocator {
    private static GMControllerLocator instance;
    private Map<GameMenu, GMController> controllers;

    private GameControllerLocator(){
        controllers = new HashMap<>();
    }
    public static GMControllerLocator getInstance(){
        if (instance == null){
            instance = new GameControllerLocator();
        }
        return instance;
    }

    @Override
    public GMController find(GameMenu gameMenu) {
        GMController controller = controllers.get(gameMenu);
        if (controller != null) {
            return controller;
        }
        switch (gameMenu) {
            case GAMEPVC:
                controller = new GameControllerPvC();
                break;
            case GAMEPVP:
                controller =  new GameControllerPvP();
                break;
        }
        controllers.put(gameMenu, controller);
        return controller;
    }
}
