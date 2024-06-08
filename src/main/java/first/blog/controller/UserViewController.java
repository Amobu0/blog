package first.blog.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class UserViewController {

    @GetMapping("/login")
    public String login() {
        log.info("화면이 왜 안 열리냐");
        return "/oauthLogin";
    }

    @GetMapping("/signup")
    public String signup() {
        log.info("signup 화면이 왜 안 열리냐");
        return "/signup";
    }
}
