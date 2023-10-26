package exam05.main;
import exam05.Message2;
import exam05.config.*;
import exam05.Message;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    public static void main(String[] args) {
        // 객체 생성 -> 의존성 주입 -> 초기화
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
        Message message = ctx.getBean(Message.class);
        message.send("안녕하세요");

        Message2 message2 = ctx.getBean(Message2.class);
        ctx.close();
    }
}
