package com.elice.post.repository;

import com.elice.post.domain.Post;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcTemplatePostRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplatePostRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // postRowMapper 메소드가 리턴하는 함수는 조회 결과를 Post 객체에 매핑하는 역할을 수행합니다.
    private RowMapper<Post> postRowMapper() {  
        return (rs, rowNum) -> {
            Post post = new Post();
            post.setId(rs.getLong("id"));
            post.setTitle(rs.getString("title"));
            post.setContent(rs.getString("content"));
            return post;
        };
    }

    // 입력
    public Post save(Post post) {
        String sql = "insert into post(title, content) values(?, ?)";
        int postId = jdbcTemplate.update(sql, post.getTitle(), post.getContent());
        post.setId((long) postId);
        return post;
    }

    // 업데이트
    public int update(Post post) {
        String sql = "update post set title = ?, content = ? where id = ?";
        int result = jdbcTemplate.update(sql, post.getTitle(), post.getContent(), post.getId());
        return result;
    }

    // 전체 조회
    public List<Post> findAll() {
        String sql = "select * from post";
        return jdbcTemplate.query(sql, postRowMapper());
    }
    // 특정 Id로 조회 - queryForObject
    public Optional<Post> findById(long id) {
        String sql = "select * from post where id = ?";
        try {
            Post post = jdbcTemplate.queryForObject(
                    sql,
                    postRowMapper(),
                    new Object[]{id}
            );
            return Optional.ofNullable(post);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
    

    // 삭제
    public void deleteById(Long id) {
        String sql = "delete from post where id = ?";
        jdbcTemplate.update(sql, id);
    }

    
}
