package org.choongang.Game.Services;

import org.choongang.Game.entities.Rank;
import org.choongang.Game.mapper.PointLogMapper;
import org.choongang.global.Service;

import java.util.List;

public class RankingInfoService implements Service<List<Rank>> {
    private final PointLogMapper mapper;
    public RankingInfoService(PointLogMapper mapper){this.mapper = mapper;}
    @Override
    public List<Rank> process() {
        return mapper.getRank();
    }
}
