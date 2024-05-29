package org.choongang.Game.mapper;

import org.choongang.Game.entities.PointLog;
import org.choongang.Game.entities.Rank;

import java.util.List;

public interface PointLogMapper {
    int register(PointLog pointLog);
    List<Rank> getRank();
}
