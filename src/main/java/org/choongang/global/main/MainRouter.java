package org.choongang.global.main;

import org.choongang.global.Controller;
import org.choongang.global.Router;
import org.choongang.global.constants.Menu;
import org.choongang.global.member.JoinController;
import org.choongang.global.member.LoginController;

public class MainRouter implements Router {
    private static Router instance;

    private MainRouter(){}
    public  static  Router getInstance(){
        if(instance == null){
            instance = new MainRouter();
        }
        return instance;
    }
    @Override
    public void change(Menu menu) {
        Controller controller = null;

        switch (menu){
            case JOIN: controller = new JoinController(); break;
            case LOGIN: controller = new LoginController(); break;
            case GAME: controller = new LoginController(); break;
            case RESULT: controller = new LoginController(); break;
            default: controller = new MainController();
        }
        controller.run();
    }

    @Override
    public void start() {
        while (true){
            change(Menu.MAIN);
        }
    }
}
