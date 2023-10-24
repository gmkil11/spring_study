package exam02.main;

import exam02.config.AppCtx;
import exam02.models.member.JoinService;
import exam02.models.member.Member;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
        JoinService joinService = ctx.getBean("joinService", JoinService.class);
        Member member = Member.builder()
                        .userId("user01")
                        .userPw("1234")
                        .confirmUserPw("1234")
                        .userNm("사용자01")
                        .email("test1@test.org")
                        .agree(true)
                        .build();

        joinService.join(member);

        ctx.close();
    }
}
