package com.elice.repository;

import com.elice.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcContactRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcContactRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Contact save(Contact contact) {
        if (contact.getContactId() == null) {
            // Insert new contact
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps = connection.prepareStatement(
                        "INSERT INTO contact (name, phone_number, email) VALUES (?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS
                    );
                    ps.setString(1, contact.getName());
                    ps.setString(2, contact.getPhoneNumber());
                    ps.setString(3, contact.getEmail());
                    return ps;
                },
                keyHolder
            );
            Number key = keyHolder.getKey();
            if (key != null) {
                contact.setContactId(key.longValue());
            } else {
                throw new RuntimeException("Failed to generate contactId for new contact");
            }
        } else {
            // Update existing contact
            jdbcTemplate.update(
                "UPDATE contact SET name = ?, phone_number = ?, email = ? WHERE contact_id = ?",
                contact.getName(), contact.getPhoneNumber(), contact.getEmail(), contact.getContactId()
            );
        }
        return contact;
    }

}
