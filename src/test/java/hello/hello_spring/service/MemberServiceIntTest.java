package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntTest {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository ;

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("hello2");

        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveId).get();
        assertEquals(member.getName(), findMember.getName()); // 이름이 같은지 확인
        // 처음 assertEquals 괄호의 들어가는것과 뒤에 들어가는것이 같은지 확인하는것
    }
    @Test
    public void 중복회원() {
        //given
        Member member1 = new Member();
        member1.setName("Spring3");

        Member member2 = new Member();
        member2.setName("Spring3");
        //when
        memberService.join(member1);
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));


    }
}