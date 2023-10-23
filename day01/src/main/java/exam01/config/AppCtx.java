package exam01.config;

import exam01.Greet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {

    // 스프링의 관련 객차라는 것을 알려주는 애노테이션
    @Bean
    public Greet greet(){
        return new Greet();
    }
}
