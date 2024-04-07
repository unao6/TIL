package com.elice.post.repository;

import com.elice.post.domain.Post;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcTemplatePostRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplatePostRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Post> findAll() {
        String sql = "select * from post";
        return jdbcTemplate.query(sql, postRowMapper());
    }

    public Optional<Post> findById(Long id) {
        String sql = "select * from post where id = ?";
        return jdbcTemplate.query(sql, postRowMapper(), id).stream().findAny();
    }


    // JdbcTemplate를 이용하여 게시글을 입력하는 기능을 작성해봅니다.
    public Post save(Post post) {
        String sql = "insert into post (title, content) values (?, ?)";
        // 1. JdbcTemplate으로 insert를 실행할 때 자동 증가되는 key 값을 얻고 싶을때는 KeyHolder를 사용해야 합니다.
        KeyHolder keyHolder = new GeneratedKeyHolder();
        // 2. update 내부에서도 다음과 같은 형태로 PreparedState 문을 사용해야합니다.
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
            ps.setString(1, post.getTitle());
            ps.setString(2, post.getContent());
            return ps;
        }, keyHolder);  
        // 3. 그리고 반환 받은 key 값을 다음과 같이 저장하여 사용합니다.
        Long postId = keyHolder.getKey().longValue();
        post.setId(postId);
        return post;
    }

    private RowMapper<Post> postRowMapper() {
        return (rs, rowNum) -> {
            Post post = new Post();
            post.setId(rs.getLong("id"));
            post.setTitle(rs.getString("title"));
            post.setContent(rs.getString("content"));
            return post;
        };
    }

}
