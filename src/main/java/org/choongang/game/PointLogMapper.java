package org.choongang.game;

import java.util.List;

public interface PointLogMapper {
    int register(PointLog pointLog);
    List<Rank> getRank();
}
