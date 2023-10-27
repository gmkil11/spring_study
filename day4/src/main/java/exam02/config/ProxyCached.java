package exam02.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.HashMap;
import java.util.Map;

@Order(1)
@Aspect
public class ProxyCached {
    private Map<Long, Object> cache = new HashMap<>();

    @Pointcut("execution(long exam02.aopex..*(long))")
    public void publicTarget() {}

    @Around("publicTarget()")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable{
        Object[] args = joinPoint.getArgs();
        long num = (long) args[0];
        // 캐쉬에 값이 있다면 해쉬맵에서 가져오는 형태로 수행이 되어서 연산에 부담이 줄어든다.
        if (cache.containsKey(num)){
            System.out.println("캐쉬에서 결과를 가져왔습니다.");
            return cache.get(num);
        }

        System.out.println(num);
        Object result = joinPoint.proceed(); // 핵심 기능 수행
        cache.put(num, result);
        System.out.println("캐쉬에 값을 저장했습니다.");

        return result;
    }
}
