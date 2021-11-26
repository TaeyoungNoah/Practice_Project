package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

//@Service // MemberController에서 Autowired를 하기 위해선 스프링 컨테이너가 만들어질 때 얘가 바로 생성이 되어야함. 그래서 이렇게 적어주면 됨
public class MemberService {
    //private final MemberRepository memberRepository = new MemoryMemberRepository(); 대신에
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원 가입
    public Long join(Member member){
        // 같은 이름이 있는 중복 회원 X
//        Optional<Member> result = memberRepository.findByname(member.getName()); // memberRepository.findByname(member.getName()); 까지 적고 cmd+option+v
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        }); 를 아래와 같이 간단하게 작성 가능
//        memberRepository.findByname(member.getName())
//                .ifPresent(m -> {
//                    throw new IllegalStateException("이미 존재하는 회원입니다.");
//                }); // 이렇게 새로운 논리구조가 나오면 메서드로 빼는게 좋음
//        command+T 하고 extract method 누르면 됨

        validateDuplicateMember(member);  // 중복 회원 검증

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent((Member m) -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers(){ // service는 좀 비즈니스에 의존적으로 개발함. 용어도 비즈니스적으로 지어어야함
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

    // 테스트 하는법: 클래스에서  cmd+shift+T
}

