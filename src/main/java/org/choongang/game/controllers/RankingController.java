package org.choongang.game.controllers;

import org.choongang.game.Services.GameServiceLocator;
import org.choongang.game.constants.SubMenu;
import org.choongang.game.entities.ScoreRank;
import org.choongang.global.AbstractController;
import org.choongang.global.Service;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.template.Templates;

import java.util.List;
import java.util.stream.Collectors;

public class RankingController extends AbstractController {
    @Override
    public void show() {

        Service<List<ScoreRank>> service = GameServiceLocator.getInstance().find(SubMenu.RANKING);
        List<ScoreRank> ranks = service.process();
        String ranking = ranks.stream()
                .map(r -> String.format("%d등 - %s(%s)/ %d승 %d패 / 승률 %.2f%%", r.getRank(), r.getUserNm(), r.getUserId(),r.getWin(),r.getLost(), r.getRate()))
                .collect(Collectors.joining("\n"));

        Templates.getInstance().render(SubMenu.RANKING, () -> ranking);
        // 랭킹 출력 후 게임 메뉴 이동
        MainRouter.getInstance().change(MainMenu.GAME);
    }
}
