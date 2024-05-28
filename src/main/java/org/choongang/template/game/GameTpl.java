package org.choongang.template.game;

import org.choongang.template.Template;

public class GameTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("게임시작\n");

        return sb.toString();
    }
}
