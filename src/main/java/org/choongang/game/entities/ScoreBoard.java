package org.choongang.game.entities;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ScoreBoard {
    private long scoreNo;
    private long userNo;
    private String ptcPtp;
    private int win;
    private int lst;
    private String mode;
    private LocalDateTime scoreRegDt;

}
