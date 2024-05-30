package org.choongang.game.entities;

import lombok.Data;

@Data
public class ScoreRank {
    private int rank;
    private long userNo;
    private String userId;
    private String userNm;
    private int win;
    private int lost;
    private double rate;

}
