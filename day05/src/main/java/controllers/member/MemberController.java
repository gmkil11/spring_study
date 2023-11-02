package controllers.member;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member") // 공통 URL 을 설정하는 것이라서 다른 mapping url에 /member를 빼도 된다.
public class MemberController {

    @GetMapping("/join")
    public String join(){
        return "member/join";
    }

//    @RequestMapping(method = RequestMethod.POST , path="/member/join")
    @PostMapping("/join")
    public String joinPs(){
        System.out.println("post Mapping 유입 완료");
        return "redirect:/member/login"; // 로그인 페이지로 리다이렉트
    }

    @GetMapping("/login")
    public String login(){
        return "member/login";
    }

    @PostMapping("/login")
    public String loginPs(){
        return "member/login";
    }
/*    @Autowired
    private HttpServletRequest request;


    @GetMapping("/login")
    public String login(RequestLogin form, HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(form);
        req.setAttribute("message", form);
        System.out.println(resp);
        System.out.println(request.getParameter("userId"));
        return "member/login";
    }


    @GetMapping("/login")
    public String login(RequestLogin form, Model model) {
        // Servlet 의 request.setAttribute 대신 사용이 가능한 기능
        model.addAttribute("message" , "안녕하세요");
        return "member/login";
    }

    @GetMapping("/join")
    public String join(Model model){
        String[] addCss = {"member/test1", "member/test2"};
        List<String> addScript = Arrays.asList("member/script1", "member/script2");
        model.addAttribute("addCss",addCss);
        model.addAttribute("addScript", addScript);
        model.addAttribute("pageTitle", "회원가입");
        return "member/join";
    }

    @GetMapping("/login")
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

    @GetMapping("/list")
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

*/
}
