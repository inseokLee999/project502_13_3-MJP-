package org.choongang.Game.Services;

import org.choongang.Game.constants.SubMenu;
import org.choongang.Game.mapper.PointLogMapper;
import org.choongang.global.AbstractServiceLocator;
import org.choongang.global.Menu;
import org.choongang.global.Service;
import org.choongang.global.ServiceLocator;
import org.choongang.global.configs.DBConn;
import org.choongang.global.constants.MainMenu;

public class GameServiceLocator extends AbstractServiceLocator {
    private static ServiceLocator instance;
    public static ServiceLocator getInstance(){
        if(instance == null){
            instance = new GameServiceLocator();
        }
        return instance;
    }
    public PointLogMapper pointLogMapper(){
        return DBConn.getSession().getMapper(PointLogMapper.class);
    }
    @Override
    public Service find(Menu menu) {
        Service service = services.get(menu);

        if(service != null){
            return service;
        }
        if(menu instanceof SubMenu) {//혼자하기, 같이하기, 순위보기
            SubMenu subMenu = (SubMenu) menu;
            switch (subMenu){
                case PVC://혼자하기

                case PVP://함께하기

                case RANKING:
                    service = new RankingInfoService(pointLogMapper()); break;
                default : service = new GameService();break;
            }
        }else{//주 메뉴

        }

        services.put(menu,service);
        return service;
    }
}
