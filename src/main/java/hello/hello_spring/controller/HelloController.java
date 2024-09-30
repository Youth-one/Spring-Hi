package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
    // 자바스프링에서 Mvc는 Model, View, Controller를 의미한다.
    // model은 데이터와 비즈니스 로직을 포함하며 데베와 상호작용하며 데이터를 갱신 저장 삭제 기능을 제공한다
    // view는 사용자에게 보여지는 화면을 의미한다 또한 사용자와 상호작용하는 인터페이스를 제공한다
    // controller는 사용자의 입력을 받아서 처리하는 역할을 한다 여기서는 model과 상호작용을 한
    // controller의 결과를 view로 출력한
    // mvc 동작과정은 1. 사용자가 url에  요청을 보낸다
    // 2. 디스패처 서블렛이 요청을 받아 컨트롤러로 보낸다
    // 3. 컨트롤러는 요청을 처리하고 model에 데이터를 담아 view에 전달한다
    // 4. 디스패처 서블렛은 뷰 리졸버(View Resolver)를 통해 view를 찾아 사용자에게 응답한다
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello {
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
    //api 는 사용자가 url에 요청을 보낸다 - > responsebody가 붙어있다면
    // View resolver 대신에 HttpMessageConverter가 동작한다
    //객체 -> jsonconverter 문자 - > stringConverter


}
