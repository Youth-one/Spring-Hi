package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class JdbcTemplateMemberRepository implements MemberRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateMemberRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource); // 이것은 생성자를 통해서 dataSource를 주입받는다
        //datasource란 데이터베이스 커넥션을 획득할때 사용하는 인터페이스이다
        //그러면 jdbcTemplate란 무엇인가 이것은 스프링이 제공하는 JdbcTemplate이라는 것을 사용하는 것이다
        //근데 이 jdbcTemplate에 왜 dataSource를 주입하는 것인가
        // 이것은 jdbcTemplate이 데이터베이스 커넥션을 획득할때 사용하는 인터페이스인 dataSource를 사용하기 때문이다

        // 이게 주입식이라는데 아직도 이게 뭔 소리인지 잘 이해가 안간다
        // 이게 무슨 의미인지 알아보자 그리고 이것을 사용하는 이유는 무엇인지 알아보자
        // 이것은 스프링이 제공하는 JdbcTemplate이라는 것을 사용하는 것이다
        // JdbcTemplate은 순수 JDBC API에서 반복적으로 하는 try/catch문을 제거해준다
        // 그리고 SQL문을 실행하는 코드를 작성해야하는데 이것을 작성하는데 도움을 준다
        // 그리고 결과를 객체로 매핑하는데 도움을 준다
        // 이것을 사용하는 이유는 JDBC API를 사용할때는 매번 try/catch문을 작성해야하고
        // SQL문을 실행하는 코드를 작성해야하고 결과를 객체로 매핑하는 코드를 작성해야한다
        // 이것을 사용하면 이것을 사용하지 않을때보다 훨씬 간단하게 작성할수있다
        //
    }

    @Override
    public Member save(Member member) {
        return null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        List<Member> result = jdbcTemplate.query("select * from member where id = ?", memberRowMapper(), id);
        return result.stream().findAny();
    }
//stream은 배열과 컬렉션 여러 object들을 함수형으류 간단하게 처리할수 있게끔 변경시켜주는 것이다 stream().findAny()는 하나라도 찾는것이다
    //findAny말고도 여러가지 필터링이라던가 중복제거 매핑등 여러가지 기능들이 있으니 잘 검색해 보도록 하자
    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return List.of();
    }
    private RowMapper<Member> memberRowMapper() {
        return (rs, rowNum) -> {
            Member member = new Member();
            member.setId(rs.getLong("id"));
            member.setName(rs.getString("name"));
            return member;
        };
    }
}
