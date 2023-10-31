package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(name="nm", defaultValue = "이름없음") String name, int num1, boolean agree) {
        System.out.printf("name=%s, num1=%d, agree=%s%n", name, num1, agree);

        return "hello"; // /WEB-INF/templates/hello.jsp
    }


    /*
    @GetMapping("/hello")
    public ModelAndView hello() {

        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "반갑습니다.");
        mv.setViewName("hello");

        return mv;
    }

     */
}