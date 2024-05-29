package org.choongang.Game.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PointLog {
    private long seq;
    private long userNo;
    private long point;
    private String message;
}
