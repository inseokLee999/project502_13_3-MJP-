package org.choongang.template;

import org.choongang.global.constants.Menu;
import org.choongang.template.game.GameTpl;
import org.choongang.template.game.ResultTpl;
import org.choongang.template.main.MainTpl;
import org.choongang.template.member.JoinTpl;
import org.choongang.template.member.LoginTpl;

import java.util.HashMap;
import java.util.Map;

public  class Templates {
    private static  Templates instance;
    private Map<Menu, Template> tpls;
    private Templates(){tpls = new HashMap<>();}
    public static Templates getInstance(){
        if(instance == null){
            instance = new Templates();
        }
        return instance;
    }
    public void render(Menu menu) {

        System.out.println(find(menu).getTpl());
    }
    public Template find(Menu menu){
    Template tpl = tpls.get(menu);
    if(tpl != null){
        return tpl;
    }
        switch (menu){
            case JOIN: tpl = new JoinTpl(); break;
            case LOGIN: tpl = new LoginTpl(); break;
            case GAME: tpl = new GameTpl(); break;
            case RESULT: tpl = new ResultTpl(); break;
            default: tpl = new MainTpl();
        }
        tpls.put(menu,tpl);
        return tpl;
    }

    public String line(){return "----------------------------------------\n";}
    public String doubleline(){return "========================================\n";}


}

}

