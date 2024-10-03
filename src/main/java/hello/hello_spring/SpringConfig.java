package hello.hello_spring;

import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import hello.hello_spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
//    @Bean
//    public MemberService memeberService() {
//        return new MemberService(memberRepository());
//    }
//    @Bean
//    public MemoryMemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
    //위의 방법은 @Service 와 @Repository를 사용하지 않고 직접 빈을 등록하는 방법이다
    //하지만 이것은 좋은 방법이 아니다 왜냐하면 @Service 와 @Repository를 사용하지 않고 직접 빈을 등록하는 방법은
    //컴포넌트 스캔을 사용하지 않는다는 것이다. 그래서 이것은 좋은 방법이 아니다
}
