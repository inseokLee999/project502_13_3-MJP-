package org.choongang.game.mapper;

import org.choongang.game.entities.ScoreBoard;
import org.choongang.game.entities.ScoreRank;

import java.util.List;

public interface ScoreBoardMapper {
    int register(ScoreBoard data);
    List<ScoreRank> getRank();
}
