package controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("controllers") // 공통적으로 적용될 수 있는 컨트롤러 -> 적용될 수 있는 범위를 설정 할 수 있다.
public class CommonController {
     //MemberController 한정 예외 페이지 처리
    @ExceptionHandler(Exception.class)
    public String errorHandler(Exception e, Model model) {
        e.printStackTrace();
        model.addAttribute("message", e.getMessage());
        return "error/common";
    }
}
