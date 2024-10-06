package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{
    //SpringDataJpaMemberRepository는 JpaRepository를 상속받아서 사용한다 이거를 구현체를 자동으로 만들어준다
    //SpringDataJpa는 인터페이스만 정의해놓으면 구현체를 자동으로 만들어준다
    //나머지 method는 자동으로 구현된다
    //기본적인 crud들이 JpaRepository안에 구현이 되어있따
    //paging and sortion 기능도 제공한다
    //SpringDataJpaMemberRepository를 만들면 스프링데이터 jpa가 구현체를 만들어서 스프링 빈에 등록해준다
    @Override
    Optional<Member> findByName(String name); // 이렇게 value로 찾는거는 모든 비즈니스 마다 변수명이 다르므ㅡ로 이렇게 따로 만들어준다
    //이렇게 하면 findByName이라는 메서드를 만들어서 name이라는 필드를 찾는다 findBy(변수) 하면 변수명에 맞는 함수를 만든다 (sql문) ex) findByEmail 이렇게 하면 email을 찾는다
    //findByNameAndId 이렇게 하면 name과 id를 찾는다 findByNameAndId(String name, Long id) 이렇게 사용한다
    //findByNameOrId 이렇게 하면 name이나 id를 찾는다 findByNameOrId(String name, Long id) 이렇게 사용한다
    //findByNameOrderByIdDesc 이렇게 하면 name을 찾고 id를 내림차순으로 정렬한다
//feat : SpringDataJpa는 JpaRepository에 extend를 하면 스프링빈에 알아서 등록이 되고 이 리포지토리는 자동으로 CRUD가 구현이 되어있지만 member와 같은
// table명은 비즈니스마다 다르므로 그 부분은 우리가 구현을 해야한다 ex)findByEmail , FindByName
}
