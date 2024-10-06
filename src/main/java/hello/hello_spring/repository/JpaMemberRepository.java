package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }


    @Override
    public Member save(Member member) {
        em.persist(member);
        //persist라는 메서드를 사용해서 member라는 객체를 저장한다
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        //find라는 메서드를 사용해서 Member라는 클래스를 찾는다. 그리고 받은 Id값을 넣어주고 그거랑같은 값을 찾는다
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
       List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
               // member라는 객체를 조회 -> 그중에서는 name이라는 필드를 조회 -> 그중에서는 name이라는 필드가 파라미터로 들어온 name과 같은것을 조회
                .setParameter("name", name)
               //위에서 파라미터로 들어온 name을 name이라는 필드에 넣어준다
                .getResultList();
       //결과를 리스트로 받아온다
        return result.stream().findAny();
        //결과를 스트림으로 받아온다
    }

    @Override
    public List<Member> findAll() {
        return  em.createQuery("select m from Member m", Member.class)
                //jpql이라는 객체지향 쿼리언어를 사용한다. 이 쿼리는 멤버로 하는 테이블의 모든것을 가져온다
                .getResultList();

    }
}
