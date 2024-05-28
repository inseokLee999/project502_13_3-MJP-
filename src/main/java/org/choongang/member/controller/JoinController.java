package org.choongang.member.controller;

import org.choongang.global.AbstractController;
import org.choongang.global.constants.Menu;
import org.choongang.template.Templates;

public class JoinController extends AbstractController {
    @Override
    public void show() {
        Templates.getInstance().render(Menu.JOIN);
    }
}
