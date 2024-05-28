package org.choongang.member.controller;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class RequestJoin {
    private String userId;
    private String userPw;
    private String confirmPw;
    private String userNm;
}
