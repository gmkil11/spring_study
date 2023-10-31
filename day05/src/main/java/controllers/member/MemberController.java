package controllers.member;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
/*    @Autowired
    private HttpServletRequest request;


    @GetMapping("/member/login")
    public String login(RequestLogin form, HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(form);
        req.setAttribute("message", form);
        System.out.println(resp);
        System.out.println(request.getParameter("userId"));
        return "member/login";
    }
 */

    @GetMapping("/member/login")
    public String login(RequestLogin form, Model model) {
        // Servlet 의 request.setAttribute 대신 사용이 가능한 기능
        model.addAttribute("message" , "안녕하세요");
        return "member/login";
    }
}
