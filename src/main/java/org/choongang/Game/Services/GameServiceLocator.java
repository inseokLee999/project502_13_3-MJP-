package org.choongang.Game.Services;

import org.choongang.global.AbstractServiceLocator;
import org.choongang.global.Service;
import org.choongang.global.ServiceLocator;
import org.choongang.global.constants.MainMenu;

public class GameServiceLocator extends AbstractServiceLocator {
    public static ServiceLocator getInstance(){
        if(instance == null){
            instance = new GameServiceLocator();
        }
        return instance;
    }
    @Override
    public Service find(MainMenu mainMenu) {
        Service service = services.get(mainMenu);
        if(service != null){
            return service;
        }switch (mainMenu){
            default : service = new GameService();break;
        }
        return service;
    }
}
