package org.choongang.global;


import org.choongang.global.constants.GameMenu;

public interface GMControllerLocator {
    GMController find(GameMenu gameMenu);
}
