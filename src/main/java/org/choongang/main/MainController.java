package org.choongang.main;

import org.choongang.global.AbstractController;
import org.choongang.global.MainMenu;
import org.choongang.template.Templates;

public class MainController extends AbstractController {
    @Override
    public void show() {
        Templates.getInstance().render(MainMenu.MAIN);
    }
}
