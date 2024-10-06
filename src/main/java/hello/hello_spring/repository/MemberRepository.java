package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // memeber객체를 저장한다 model이라고 생각하면된다
    Optional<Member> findById(Long id); // id에 해당되는 member객체를 찾는다
    Optional<Member> findByName(String name); // name에 해당되는 member객체를 찾는다
    List<Member> findAll(); // 모든 member객체를 찾는다
    // 여기서 id가 key값 name이 value값으로 생각하면 된다.
}
//MemberRepository 는 인터페이스 클래스로 데이터베이스와 상호작용하는 메서드를 정의한
// 실제데이터 액세스 로직은 이 인터페이스를 구현하는 클래스로 처리된다
//jpa 는 기존반복코드는 물론이고 기본적인 sql문을 직접 만들어서 실행해준다