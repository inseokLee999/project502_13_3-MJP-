package org.choongang.template;
//이 클래스는 싱글톤 패턴을 사용하여 하나의 인스턴스만을 가지며, 다양한 메뉴에 대한 템플릿을 관리하고 렌더링하는 역할을 합니다.
import org.choongang.game.SubMenu;
import org.choongang.global.Menu;
import org.choongang.global.MainMenu;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public  class Templates {
    private static  Templates instance;
    //Menu 타입의 키와 Template 타입의 값을 가지는 맵으로, 각 메뉴에 대한 템플릿을 저장합니다.
    private Map<Menu, Template> tpls;
    private Templates(){tpls = new HashMap<>();}
    public static Templates getInstance(){
        if(instance == null){
            instance = new Templates();
        }
        return instance;
    }

    public void render(Menu menu){
        render(menu,null);
    }
    public void render(Menu menu, Supplier<String> hook) {
        System.out.println(find(menu,hook).getTpl());
    }
    public Template find(Menu menu,Supplier<String> hook){
    Template tpl = tpls.get(menu);
    if(tpl != null){
        return tpl;
    }
    if(menu instanceof SubMenu) {
        SubMenu subMenu = (SubMenu) menu;

        switch (subMenu) {
            case PVC, PVP:
                tpl = new GameTpl();
                break;
            case RANKING:
                tpl = new RankTpl();
                break;
        }
    }else{
        MainMenu mainMenu = (MainMenu) menu;
        switch(mainMenu){
            case JOIN:
                tpl = new JoinTpl();
                break;
            case LOGIN:
                tpl = new LoginTpl();
                break;
            case GAME:
                tpl = new GameTpl();
                break;
            case RESULT:
                tpl = new RankTpl();
                break;
            default:
                tpl = new MainTpl();
        }
    }
    if(hook != null){
        tpl.addHook(hook);
    }
        tpls.put(menu,tpl);
        return tpl;
    }

    public String line(){return "----------------------------------------\n";}
    public String doubleline(){return "========================================\n";}


}
