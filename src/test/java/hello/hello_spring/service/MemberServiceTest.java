package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository ;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository(); // 인스턴스를 생성해서 넣어줌
        memberService = new MemberService(memberRepository); // 위에서만든 memberRepository를 넣어줌
        //그러면 같은 MemoryMemberRepository를 사용하게 된다.
    }

    @AfterEach
    public void afterEach() {
        memberRepository.afterEach();
    }

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("hello");

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
        member1.setName("Spring1");

        Member member2 = new Member();
        member2.setName("Spring1");
        //when
        memberService.join(member1);
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));


    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}