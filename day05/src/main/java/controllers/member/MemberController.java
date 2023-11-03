package controllers.member;


import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import models.member.JoinService;
import models.member.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/member") // 공통 URL 을 설정하는 것이라서 다른 mapping url에 /member를 빼도 된다.
@RequiredArgsConstructor // 스프링이 객체를 관리할 수 있게 롬복을 통해 생성자를 상수화를 통해 건내준다.
public class MemberController {


    private final JoinValidator joinValidator;
    private final JoinService joinService;
    private final LoginService loginService;
    private final LoginValidator loginValidator;

    @GetMapping("/join")
    public String join(@ModelAttribute RequestJoin join){
        // @ModelAttribute("명칭") -> 명칭 안 적을 시 클래스명(기본값)

        return "member/join";
    }

//    @RequestMapping(method = RequestMethod.POST , path="/member/join")
    @PostMapping("/join")
    public String joinPs(@Valid RequestJoin join, Errors errors){ // 순서가 중요하다. 커맨드 객체 바로 뒤에 존재해야 인식한다.
        System.out.println("데이터 확인 : " + join );

        joinValidator.validate(join,errors); // 검증 / 하지만 현재 MvcConfig에서 전역 Validator를 설정해줬기 때문에 필요 없다.

        if (errors.hasErrors()){
            // 검증 실패시 유입
            return "member/join";
        }
        // 검증 성공시 유입
        joinService.join(join);
        return  "member/login";
//        return "redirect:/member/login"; // 로그인 페이지로 리다이렉트
    }

    @GetMapping("/login")  // /member/login
    public String login(@ModelAttribute RequestLogin form, @CookieValue(name ="saveId" ,required = false) String userId) {


        return "member/login";
    }

    @PostMapping("/login")
    public String loginPs(@Valid RequestLogin form, Errors errors) {

        loginValidator.validate(form, errors);

        if (errors.hasErrors()) {
            return "member/login";
        }



        // 유효성 검사 성공 -> 로그인 처리
          loginService.login(form);
        return "redirect:/";

    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/member/login";
    }


//    @InitBinder
//    public void initBinder(WebDataBinder binder){
//        binder.setValidator(joinValidator);
//    }











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
