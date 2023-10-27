package exam02.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Order(2)
@Aspect
public class ProxyCalculator {
    // 프록시가 제공될 범위를 설정할 수 있다.
    @Pointcut("execution(* exam02.aopex..*(..))")
    public void publicTarget() {
    }

    @Around("publicTarget()")
    //반환값인 Object와 thorws Throwable은 필수다
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable{
        long sTime = System.nanoTime();
        Object[] args = joinPoint.getArgs(); // 투입된 매변수의 값
        long num = (Long)args[0];
        System.out.println("getArgs() = "+ num);

        String sig = joinPoint.toLongString(); // 매서드의 정보를 가져온다.
        System.out.println("getSignature() = " +sig);
        try {
            Object result = joinPoint.proceed(); // factorial(...) - 핵심기능 수행 (대신 수행)
            return result;
        } finally {
            long eTime = System.nanoTime();
            System.out.println("time = " + (eTime-sTime));
        }
    }
}
