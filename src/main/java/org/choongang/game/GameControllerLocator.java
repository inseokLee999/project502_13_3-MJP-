package org.choongang.game;

import org.choongang.global.*;
import org.choongang.global.Controller;

public class GameControllerLocator extends AbstractControllerLocator {

    private static ControllerLocator instance;
    private GameControllerLocator(){}

    public static ControllerLocator getInstance(){
        if (instance == null){
            instance = new GameControllerLocator();
        }
        return instance;
    }

    @Override
    public Controller find(Menu menu) {
        Controller controller = controllers.get(menu);
        if (controller != null) {
            return controller;
        }
        //게임 서브 메뉴
        if(menu instanceof SubMenu){
            SubMenu subMenu = (SubMenu) menu;
            switch(subMenu){
                case PVC:
                    controller = new GameControllerPvC();
                    break;
                case PVP:
                    controller = new GameControllerPvP();
                    break;
                case RANKING:
                    controller = new RankingController();
                    break;

            }
        }else{//게임 메인 메뉴
            controller = new GameController();
        }
        return controller;
    }
}
