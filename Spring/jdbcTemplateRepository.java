package io.elice.elcademy.subject.repository;

import io.elice.elcademy.subject.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class SubjectJdbcTemplateRepository implements JdbcTemplateRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SubjectJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    private final RowMapper<Subject> subjectRowMapper = (rs, rowNum) -> {
        Subject subject = new Subject();
        subject.setSubjectId(rs.getLong("subject_id"));
        subject.setName(rs.getString("name"));
        subject.setPrice((int) rs.getDouble("price"));

        return subject;
    };

    //GET
    public List<Subject> findAll() {
        String sql = "SELECT * FROM subject";
        return jdbcTemplate.query(sql, subjectRowMapper);
    }

    public Optional<Subject> findById(Long id) {
        String sql = "SELECT * FROM subject WHERE subject_id = ?";
        return jdbcTemplate.query(sql, new Object[]{id}, subjectRowMapper).stream().findFirst();
    }

    // POST(생성, 업데이트)
    public Subject save(Subject subject) {
        if(subject.getSubjectId()==null) {
            String insertSql = "INSERT INTO subject (name, price) VALUES (?, ?) ";
            jdbcTemplate.update(insertSql, subject.getName(), subject.getPrice());
        }
        else {
            String updateSql = "UPDATE subject SET name = ?, price = ? where SUBJECT_ID = ?";
            jdbcTemplate.update(updateSql, subject.getName(), subject.getPrice(), subject.getSubjectId());
        }
        return subject;
    }

    public void delete(Subject subject) {
        jdbcTemplate.update(
                "DELETE FROM contact WHERE contact_id = ?",
                subject.getSubjevtId()
        );
    }

    
}
