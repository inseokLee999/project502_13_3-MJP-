package org.choongang.member.service;

import org.choongang.Game.Services.GameService;
import org.choongang.Game.Services.ResultService;
import org.choongang.global.AbstractServiceLocator;
import org.choongang.global.Service;
import org.choongang.global.ServiceLocator;
import org.choongang.global.constants.MainMenu;

public class MemberServiceLocator extends AbstractServiceLocator {

    public static ServiceLocator getInstance() {
        if (instance == null) {
            instance = new MemberServiceLocator();
        }

        return instance;
    }

    @Override
    public Service find(MainMenu mainMenu) {
        Service service = services.get(mainMenu);
        if (service != null) {
            return service;
        }switch (mainMenu) {
            case JOIN: service = new JoinService();break;
            case LOGIN: service = new LoginService(); break;
            case GAME: service = new GameService(); break;
            case RESULT: service = new ResultService();break;
        }

        return service;
    }
}
