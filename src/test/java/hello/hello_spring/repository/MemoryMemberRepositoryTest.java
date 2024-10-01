package hello.hello_spring.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import hello.hello_spring.domain.Member;

public class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName("sungwon");
        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        System.out.println("result = " + (result == member));
        Assertions.assertEquals(member, result); // result == member 같은지 확인

    }
    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("sungwon1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("sungwon2");
        repository.save(member2);

        Member result = repository.findByName("sungwon1").get();
        System.out.println("result = " + result.getId()+"그 이름은"+result.getName());
        Member result2 = repository.findByName("sungwon2").get();
        System.out.println("result2 = " + result2.getName());
    }
}
