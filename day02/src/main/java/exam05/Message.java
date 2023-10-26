package exam05;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Message implements InitializingBean, DisposableBean {
    public void send(String message){
        System.out.println("["+ message + "]를 전달했습니다.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet!!!");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy!!!");
    }
}
