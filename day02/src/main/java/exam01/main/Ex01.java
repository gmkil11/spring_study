package exam01.main;

import exam01.Greet;
import exam01.config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    public static void main(String[] args) {
        // ctx 라는 객체 상자에 AppCtx.class 를 넣는다.
        // 생성자 매개변수에 AppCtx.class 넣기
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        // 클래스 안에 매서드 명이 스프링 컨테이너에서 꺼내올 객체 이름이다.
        Greet g1 = ctx.getBean("greet", Greet.class);
        g1.hello("이이름");

        Greet g2 = ctx.getBean("greet", Greet.class);
        System.out.println(g1 == g2); // 같은 주소가 나온다. 즉, 싱글턴 패턴으로 객체를 하나만 만들고 관리한다.

        // 불러온 스프링 객체를 메모리에서 해제한다.
        ctx.close();
    }
}
