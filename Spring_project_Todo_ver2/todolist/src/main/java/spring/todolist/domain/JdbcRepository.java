package spring.todolist.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Slf4j
@Repository
public class JdbcRepository {
    public void run(Todo todo){

        Connection connection = null;
        Statement stmt = null;
        ResultSet rs;

        // 연결
        try {
            // 접속 url과 사용자, 비밀번호
            String url = "jdbc:mysql://localhost:3306/Practice";
            String user = "root";
            String pwd = "toto7001*";

            connection = DriverManager.getConnection(url, user, pwd);
            System.out.println("DB와 정상적으로 연결되었습니다.");

            log.info("DB와 정상적으로 연결되었습니다.");

            // 기존 Table 출력
            stmt = connection.createStatement();

            // 전체 쿼리
            String query = "SELECT * FROM TODO";
            String sql = query;
            log.info("최종 sql : " + sql);

            // 쿼리 수행
            rs = stmt.executeQuery(sql);

            // 쿼리 결과 출력
            while(rs.next()){
                todo.setId(rs.getLong("id"));
                System.out.println(todo.getId());
                todo.setTask(rs.getString("task"));
                System.out.println(todo.getTask());
            }

        } catch (SQLException e){
            System.err.println("연결할 수 없습니다.");
            e.printStackTrace();
        }

        // 해제
        try {

            System.out.println("DB 연결을 종료합니다.");
            if (connection != null)
                connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
