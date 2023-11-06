package controllers.admin;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminMemberController")
@RequestMapping("/admin/member")
public class MemberController {

    @GetMapping
     // ModelAttribute -> 객체가 없을때도 자동으로 속성값이 추가되어서 NullPointerException 을 예방 가능
    public String list(@ModelAttribute @Valid MemberSearch search, Errors errors) {

        System.out.println(search);


        return "admin/member/list";
    }

    @GetMapping("/{num}/info/{id}")
    // @PathVariable -> 매개변수값을 주소로 넣을때 사용
    public String info(@PathVariable(name = "id", required = false) String userId,@PathVariable Integer num) {
        System.out.println(userId);
        System.out.println(num);
        return "/admin/member/info";
    }

}
