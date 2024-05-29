package org.choongang.member.controller;

import org.choongang.global.AbstractController;
import org.choongang.global.constants.MainMenu;
import org.choongang.template.Templates;

public class MainLogincontroller extends AbstractController {
    public void show(){
        Templates.getInstance().render(MainMenu.MAINLOGINPAGE);
    }

    public void prompt(){
    }
}
