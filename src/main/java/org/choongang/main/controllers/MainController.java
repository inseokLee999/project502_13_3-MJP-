package org.choongang.main.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.constants.Menu;
import org.choongang.template.Templates;

public class MainController extends AbstractController {
    @Override
    public void show() {
        Templates.getInstance().render(Menu.MAIN);
    }
}
