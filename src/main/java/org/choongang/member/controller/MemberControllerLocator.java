package org.choongang.member.controller;

import org.choongang.Game.controller.GameController;
import org.choongang.Game.controller.ResultController;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.constants.Menu;
import org.choongang.main.controllers.MainController;

import java.util.HashMap;
import java.util.Map;

public class MemberControllerLocator implements ControllerLocator {
    private static ControllerLocator instance;
    private Map<Menu, Controller> controllers;

    private MemberControllerLocator(){
        controllers = new HashMap<>();
    }
    public static ControllerLocator getInstance(){
        if (instance == null){
            instance = new MemberControllerLocator();
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
            case JOIN:
                controller = new JoinController();
                break;
            case GAME:
                controller = (Controller) new GameController();
                break;
            case LOGIN:
                controller = new LoginController();
                break;
            case RESULT:
                controller = new ResultController();
                break;
            default:
                controller = new MainController();
        }
        controllers.put(menu, controller);
        return controller;
    }
}
