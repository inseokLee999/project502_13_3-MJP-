package org.choongang.Game.controller;

import org.choongang.global.AbstractGMController;
import org.choongang.global.constants.Menu;
import org.choongang.template.Templates;

public class GameController extends AbstractGMController {
    @Override
    public void show() {
        Templates.getInstance().render(Menu.GAME);
    }

    @Override
    public void prompt() {
        System.out.println("게임선택");
    }
}
