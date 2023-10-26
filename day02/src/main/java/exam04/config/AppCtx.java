package exam04.config;

import exam04.models.member.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@Configuration
//@ComponentScan(basePackages = "exam04.models"
//// excludeFilters = 속성을 사용하면 스캔할 때 특정 대상을 자동 등록 대상에서 제외할 수 있다. 즉, 수동 스캔 상태가 된다.
//, excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = ManualBean.class))

//@ComponentScan(basePackages = "exam04.models", excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = MemberDao.class))

@ComponentScan(basePackages = "exam04.models", excludeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "exam04.models..*Dao"))
public class AppCtx {

//    @Bean
//    public MemberDao memberDao () {
//        System.out.println("여기?");
//        return new MemberDao(); // 이름이 겹치는 경우에는 자동스캔이 아닌 수동으로 스캔시킬 시 수동스캔이 우선순위가 더 높다.
//    }
}
