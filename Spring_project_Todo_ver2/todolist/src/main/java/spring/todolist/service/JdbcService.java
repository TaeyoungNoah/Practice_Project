package spring.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.todolist.domain.JdbcRepository;
import spring.todolist.domain.Todo;

@Service
public class JdbcService {
    JdbcRepository jdbcRepository;
    @Autowired
    public JdbcService(JdbcRepository jdbcRepository) {
        this.jdbcRepository = jdbcRepository;
    }

    public void test(Todo todo) {
        jdbcRepository.run(todo);
    }
}
