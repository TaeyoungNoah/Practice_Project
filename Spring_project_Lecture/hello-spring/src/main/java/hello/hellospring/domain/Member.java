package hello.hellospring.domain;

import javax.persistence.*;

@Entity //이걸 적으면 이제부터 JPA가 관리하는 Entity라고 표현함
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
