package controllers.yeohaeng;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/yeohaeng")
public class MainController {

    @GetMapping("/main")
    public String main() {

        return "yeohaeng/main";
    }

    @GetMapping("/room")
    public String viewRoom() {

        return "yeohaeng/room";
    }
}
