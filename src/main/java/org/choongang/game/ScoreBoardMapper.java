package org.choongang.game;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ScoreBoardMapper {
    int register(ScoreBoard data);
    int update(ScoreBoard data);
    List<ScoreRank> getRank();

    @Select("SELECT COUNT(*) FROM SCORE_BOARD WHERE USER_NO=#{userNo} AND PTOC_PTOP=#{ptcPtp}")
    int exists(ScoreBoard data);



}
