package org.choongang.game.mapper;

import org.choongang.game.ScoreBoardMapper;
import org.choongang.game.ScoreBoard;
import org.choongang.game.ScoreRank;
import org.choongang.global.DBConn;
import org.choongang.member.Member;
import org.choongang.member.MemberMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

public class ScoreBoardMapperTest {

    private ScoreBoardMapper mapper;
    private MemberMapper memberMapper;

    @BeforeEach
    void init() {
        mapper = DBConn.getSession().getMapper(ScoreBoardMapper.class);
        memberMapper = DBConn.getSession().getMapper(MemberMapper.class);
    }

    @Test
    void mapperTest1() {
        IntStream.range(0, 10).forEach(i -> {
            Member member = Member.builder()
                    .userId("u" + System.currentTimeMillis())
                    .userNm("사용자")
                    .userPw("12345678")
                            .build();
            memberMapper.register(member);


            int win = (int)(Math.random() * 30) + 1;
            int lst = (int)(Math.random() * 30) + 1;
            ScoreBoard sb = ScoreBoard.builder()
                    .userNo(member.getUserNo())
                    .ptcPtp("ptc")
                    .win(win)
                    .lst(lst)
                    .build();

            mapper.register(sb);

        });

    }

    @Test
    void mapperTest2() {
        List<ScoreRank> ranks = mapper.getRank();
        ranks.forEach(System.out::println);
    }
}
