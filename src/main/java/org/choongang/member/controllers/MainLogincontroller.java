package org.choongang.member.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.constants.Menu;
import org.choongang.template.Templates;

public class MainLogincontroller extends AbstractController {
    public void show(){
        Templates.getInstance().render(Menu.MAINLOGINPAGE);
    }

    public void prompt(){
        String number =

    }
}
