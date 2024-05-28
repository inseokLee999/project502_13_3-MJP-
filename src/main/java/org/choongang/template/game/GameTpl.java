package org.choongang.template.game;

import org.choongang.template.Template;

public class GameTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("\n대전 상대 선택\n")
                .append("1. vsPlayer\n")
                .append("2. vsComputer\n");

        return sb.toString();
    }
}
