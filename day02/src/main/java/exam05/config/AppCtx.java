package exam05.config;

import exam05.Message;
import exam05.Message2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration("exam05")
@ComponentScan
public class AppCtx {

    @Bean
    @Scope("prototype") // 매번 가져올 때 마다 새로운 객체를 생성해낸다.
    public Message message() {
        return new Message();
    }

    @Bean(initMethod = "init", destroyMethod = "close")
    public Message2 message2() {
        return new Message2();
    }

}
