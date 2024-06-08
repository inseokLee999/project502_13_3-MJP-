package org.choongang.template;

import java.util.function.Supplier;

public class RankTpl implements Template {
    private Supplier<String> hook;
    public void addHook(Supplier<String> hook){
        this.hook = hook;
    }
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000);
        sb.append("순위보기 (전체 게임수 2게임 이상, 10등까지만 랭킹에 올라갑니다)\n")
                .append(Templates.getInstance().doubleline());
        if(hook != null){
            sb.append(hook.get());
        }
        return sb.toString();
    }
}
