package hello.hello_spring.domain;

import jakarta.persistence.*;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY는 기본키 생성을 데이터베이스에 위임하는 방법이다. value만 넣어주면 id값을 만들어준다고 생각 ㄱㄱ
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
//여기가 model이 되는 class로 해당필드에 접근하고 값을 설정할수있따.
// domain 객체로서 데이터를 담고있는 간단한구조체

