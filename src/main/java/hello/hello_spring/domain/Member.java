package hello.hello_spring.domain;

public class Member {
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
}
//여기가 model이 되는 class로 해당필드에 접근하고 값을 설정할수있따.
// domain 객체로서 데이터를 담고있는 간단한구조체

