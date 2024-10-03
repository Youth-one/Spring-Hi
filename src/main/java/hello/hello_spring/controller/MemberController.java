package hello.hello_spring.controller;


import hello.hello_spring.domain.Member;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
//    private final MemberService memberService = new MemberService();
    // 이렇게 가져다 쓸수있지만 이렇게 하면 안된다 왜냐하면 MemberService는 MemberRepository를 필요로하는데 이것을 주입해주지 않았기 때문이다
    // 그래서 차라리 컨테이너에 등록해두면 좋다
    private final MemberService memberService;

    @Autowired // 멤버서비스를 연결시켜준다
    public MemberController(MemberService memberService) { // 멤버컨트롤이 선언이 될때 멤버서비스를 @Service 가 되어 있으니 스프링이 컨테이너에 등록을 해두고
        // 이것을 가져다 쓸수있게 해준다 근데 멤버 서비스안에는 멤버 리포지토리가 필요하다
        //그래서 멤버 서비스가 선언이 될때 멤버 리포지토리도 스프링이 컨테이너에 등록을 해두고 이것을 가져다 쓸수있게 해준다
        this.memberService = memberService;
    }
    //스프링 빈을 등록하는 2가지 방법
    // 컴포넌트 스캔과 자동 의존관계 설정 ex) @Controller , @Service @ Repository , @AutoWired 처럼 애초애 어노테이션을 걸어두어
    // 자바코드가 이생퀴가 무엇인지 인지 할수 있게끔 설정을 해둔다. 위의 @ 애노테이션이 걸린것들 모두 컴포넌트로 지정이 된다 special한 컴포넌트라고 인지하면 된다
    // 애노테이션이 걸려있다면 빈에 자동적으로 등록을해준다

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }
    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/";
    }
    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
