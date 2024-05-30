package org.choongang.game.Services;

import org.choongang.game.entities.ScoreBoard;
import org.choongang.game.mapper.ScoreBoardMapper;
import org.choongang.global.Service;
import org.choongang.member.controllers.RequestLogin;

public class ResultService implements Service<ScoreBoard> {


    private ScoreBoardMapper mapper;

    public ResultService(ScoreBoardMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void process(ScoreBoard form) {

        if (mapper.exists(form) > 0) { // 이미 기록이 있다면 update
            mapper.update(form);
        } else { // 없다면 새로 추가
            mapper.register(form);
        }
    }
}
