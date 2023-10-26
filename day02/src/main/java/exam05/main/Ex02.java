package exam05.main;

import exam05.Message;
import exam05.config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex02 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
        Message message1 = ctx.getBean(Message.class);
        Message message2 = ctx.getBean(Message.class);

        System.out.printf("message1의 주소 = %s, message2의 주소 = %s", message1.hashCode(), message2.hashCode());
    }
}
