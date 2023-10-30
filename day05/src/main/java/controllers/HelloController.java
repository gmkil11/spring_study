package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Spring 에게 컨트롤러라고 알려줌
@Controller
public class HelloController {
    @GetMapping("/hello") // /hello 라는 주소가 검색이 되면 스프링 컨테이너 안에서 매칭되는 객체를 찾아서 연결해준다
    public String hello() {
        return "hello";
    }
}
