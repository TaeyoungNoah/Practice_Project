package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // loaclhost:8080/hello 여기 hello가 들어가면 여기로 와서 hello 리턴, 그럼 탬플릿 hello 실행
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){ // http://localhost:8080/hello-mvc?name=spring! ?name=spring! 이 @RequestParam 내용
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // HTTP Body부에 아래 데이터를 직접 넣어주겠다!
    public String helloString(@RequestParam("name") String name) {
        return "hello "+name; // 파라미터에 spring 넣으면 옆의 리턴값이 hello spring 이 될거임
    }

    // 위는 그냥 문자를 내놓으라고 한거라면 아래는 data를 내놓으라고 한다면?
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
        // json이라는 걸로 나옴 (옛날에는 XML , 최근에는 거의 다 json으로)
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

