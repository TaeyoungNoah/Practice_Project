package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

//    @Autowired // 멤버 컨트롤러가 스프링 컨테이너가 뜰 때 생성이 됨, 그때 이 생성자를 호출을 하는데 이 문구가 적혀있으면,
               // 이 Autowired가 스프링 컨테이너에 있는 Memberservice와 딱 연결을 시켜줌
               // 근데 스프링이 실행될 때 이 Controller는 바로 컨테이너가 뜰 때 생성이 되는데 memberService는 그냥 순수 자바 클래스라 생성이 안된 상태
               // 그래서 스프링이 얘가 있는지 알수가 없음;;
               // '의존 관계를 주입한다' 라고 표현
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String creatForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }
}
