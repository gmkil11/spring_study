package exam02.main;

import exam02.config.*;
import exam02.aopex.*;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex02 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(appCtx.class);
        Calculator cal = ctx.getBean(Calculator.class);

        long result = cal.factorial(10);
        System.out.println("result1 = " + result);
        result = cal.factorial(10);
        System.out.println("result2 = " + result);
        result = cal.factorial(10);
        System.out.println("result3 = " + result);
        result = cal.factorial(10);
        System.out.println("result4 = " + result);
        result = cal.factorial(10);
        System.out.println("result5 = " + result);
        result = cal.factorial(10);
        System.out.println("result6 = " + result);
        result = cal.factorial(10);
        System.out.println("result7 = " + result);


    }
}
