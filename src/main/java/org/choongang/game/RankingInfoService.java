package org.choongang.game;

import org.choongang.global.Service;

import java.util.List;

public class RankingInfoService implements Service<List<ScoreRank>> {
    private final ScoreBoardMapper mapper;
    public RankingInfoService(ScoreBoardMapper mapper){
        this.mapper = mapper;
    }
    @Override
    public List<ScoreRank> process() {
        return mapper.getRank();
    }
}
