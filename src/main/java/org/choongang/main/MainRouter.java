package org.choongang.main;

import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Router;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.controllers.MainController;
import org.choongang.member.controllers.MemberControllerLocator;

public class MainRouter implements Router {
    private static Router instance;

    private MainRouter(){}
    public static Router getInstance(){
        if(instance == null){
            instance = new MainRouter();
        }
        return instance;
    }
    @Override
    public void change(MainMenu menu) {
        ControllerLocator memlocator = MemberControllerLocator.getInstance();
        Controller controller = null;
        switch (menu){
            case JOIN: controller = memlocator.find(MainMenu.JOIN) ; break;
            case LOGIN: controller =memlocator.find(MainMenu.LOGIN); break;
            case MAINLOGINPAGE: controller = memlocator.find(MainMenu.MAINLOGINPAGE); break;

            case GAME: controller = memlocator.find(MainMenu.GAME); break;
            case RESULT: controller = memlocator.find(MainMenu.RESULT); break;
            
            default: controller = new MainController();
        }
        controller.run();
    }



    @Override
    public void start() {
        while (true){
            change(MainMenu.MAIN);
        }
    }
}
