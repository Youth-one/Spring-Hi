package hello.hello_spring;
// 여기서 부터.하위 패키지들을 자동적으로 컴포넌트 스캔을 떄려서 애노테이션들을 찾아 스프링빈에 등록해서 관리한다

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
