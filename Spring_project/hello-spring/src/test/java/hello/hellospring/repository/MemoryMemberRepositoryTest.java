package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // 어떤 메서드가 끝나면 얘를 실행함
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");
        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        //System.out.println("result = " + (result==member)); 로 해도 되지만
        //Assertions.assertEquals(member,result); //터이멀에 출력되는 것은 없지만, 초록불이면 성공 / 실패시 빨간색 나옴 이건 jupiter
        assertThat(member).isEqualTo(result); //core거. 위에 import static org.assertj.core.api.Assertions.*; 하면 앞에 Assertions. 생략 가능
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByname("spring2").get();
        assertThat(result).isEqualTo(member2);
    }
    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
        // 위에 @AferEach가 없을 때 얘기
        // 이때 클래스 전체를 test하면 에러가 나옴. (test할 때 순서는 고려하지 않음. 순서에 의존적으로 작성하면 안됨)
        // 그 이유는 다른 곳에서 먼저 member 객체를 만들어버렸기 때문.
        // 그래서 메서드마다 객체를 다 초기화 시켜줄 필요가있음. 그래서 사용하는게 @AfterEach


        // 현재 강의에서는 구현 클래스를 먼저 만들고 그것을 테스트 하는 과정을 거쳤는데,
        // test를 먼저 만들어놓고 구현 클래스를 만드는 것을 '테스트 주도 개발' TDD


    }
}
