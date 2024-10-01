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
        Assertions.assertEquals(member, null); // result == member 같은지 확인

    }
}
