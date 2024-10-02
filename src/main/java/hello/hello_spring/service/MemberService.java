package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemoryMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    // memberRepository 필드를 생성함과 동시에 MemoryMemberRepository 객체를 외부에서 주입
    //애초애 변경한 이유는 Test코드를 작성할때 MemoryMemberRepository를 사용하지 않고
    // MemberRepository를 사용하기 위함이다. 그리고 각각의 인스턴스가 다르기때문에 왜냐면 그때마다 새로운 인스턴스를 생성하기 서로 다른 db라고 판단할수있다.

//private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 위의 코드는 memberRepository 필드를 선언함과 동시에 MemoryMemberReposiotry
    // 의 인스턴스를 생성 및 할당을 한다
    //
    public Long join(Member member){
        //같은 이름 중복회원 x
        validateDuplicateMember(member);//중복회원검증
        memberRepository.save(member);
        return member.getId();

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
