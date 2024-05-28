package org.choongang.Game.controller;

import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.constants.Menu;

import java.util.HashMap;
import java.util.Map;

public class GameControllerLocator implements ControllerLocator {
    private static ControllerLocator instance;
    private Map<Menu, Controller> controllers;

    private GameControllerLocator(){
        controllers = new HashMap<>();
    }
    public static ControllerLocator getInstance(){
        if (instance == null){
            instance =  new GameControllerLocator();
        }
        return instance;
    }

    @Override
    public Controller find(Menu menu) {
        Controller controller = controllers.get(menu);
        if (controller != null) {
            return controller;
        }
        switch (menu) {
            case GAMEPVC:
                controller = new GameControllerPvC();
                break;
            case GAMEPVP:
                controller = new GameControllerPvP();
                break;
            default:
                controller = new ResultController();
        }
        controllers.put(menu, controller);
        return controller;
    }
}
