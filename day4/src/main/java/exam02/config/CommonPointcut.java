package exam02.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CommonPointcut {

  @Pointcut("excution(*exam02.aopex..*(..)"){

  }
}
