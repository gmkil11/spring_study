package exam01.config;

import exam01.Greet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {

    @Bean // 스프링에게 관리할 객체를 알려주는 애노테이션
    public Greet greet() {
        return new Greet();
    }
}
