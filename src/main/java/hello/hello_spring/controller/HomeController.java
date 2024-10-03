package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // 도메인에 / 붙어있는거 즉 main page가 될것이다
    public String home() {
        return "home";
    }
}
