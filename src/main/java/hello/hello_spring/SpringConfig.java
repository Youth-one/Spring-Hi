package hello.hello_spring;

import hello.hello_spring.repository.JdbcMemberRepository;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.swing.*;

// autowired 를 통한 Di는 스프링이 관리하는 객체에서만 동작한다 내가 직접 생성한 객체에서는 동작하지 않느다

@Configuration
public class SpringConfig {
    private DataSource dataSource;
    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memeberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
    //위의 방법은 @Service 와 @Repository를 사용하지 않고 직접 빈을 등록하는 방법이다
    //하지만 이것은 좋은 방법이 아니다 왜냐하면 @Service 와 @Repository를 사용하지 않고 직접 빈을 등록하는 방법은
    //컴포넌트 스캔을 사용하지 않는다는 것이다. 그래서 이것은 좋은 방법이 아니다
}
