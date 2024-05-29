package org.choongang.member.controllers;

import org.choongang.Game.controllers.GameController;
import org.choongang.Game.controllers.ResultController;
import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.controllers.MainController;

public class MemberControllerLocator extends AbstractControllerLocator {
    private MemberControllerLocator(){}
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
        MainMenu mainMenu = (MainMenu) menu;
        switch (mainMenu) {
            case JOIN:
                controller = new JoinController();
                break;
            case LOGIN:
                controller = new LoginController();
                break;
            default:
                controller = new MainController();
        }
        controllers.put(mainMenu, controller);
        return controller;
    }
}
