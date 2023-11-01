package controllers.member;


import models.member.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

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


    @GetMapping("/member/login")
    public String login(RequestLogin form, Model model) {
        // Servlet 의 request.setAttribute 대신 사용이 가능한 기능
        model.addAttribute("message" , "안녕하세요");
        return "member/login";
    }*/

    @GetMapping("/member/join")
    public String join(Model model){
        String[] addCss = {"member/test1", "member/test2"};
        List<String> addScript = Arrays.asList("member/script1", "member/script2");
        model.addAttribute("addCss",addCss);
        model.addAttribute("addScript", addScript);
        model.addAttribute("pageTitle", "회원가입");
        return "member/join";
    }

    @GetMapping("/member/login")
    public String login(Model model) {
        model.addAttribute("userId", "user99");
        model.addAttribute("userPw", "12345678");
        return "member/login";
    }

    @GetMapping("/member/info")
    public String info(Model model){
        Member member = Member.builder()
                .userNo(1L)
                .userId("user01")
                .userPw("123456")
                .userNm("사용자01")
                .email("user01@test.org")
                .mobile("010-0000-0000")
                .build();

        model.addAttribute("member", member);

        return "member/info";

    }

    @GetMapping("/member/list")
    public String memberList(Model model){
        List<Member> members = IntStream.rangeClosed(1, 10).mapToObj(this::addMember).toList();
        model.addAttribute("members",members);
        return "member/list";
    }

    private Member addMember(int i){

        return Member.builder()
                .userNo(i * 10000)
                .userId("user" + i)
                .userPw("123456")
                .userNm("사용자" + i)
                .email("user" + i + "@test.org")
                .regDt(LocalDateTime.now())
                .build();
    }


}
