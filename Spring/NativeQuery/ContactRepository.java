package com.elice.repository;

import java.util.List;
import com.elice.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    
    // 지시사항에 따라 코드를 작성해 보세요.
    @Query(value="Select * from contact WHERE name LIKE ?1%", nativeQuery = true)
    List<Contact> findByNameStartingWith(String name);

    @Query(value="SELECT * FROM contact WHERE email LIKE %?1", nativeQuery = true)
    List<Contact> findByEmailEndingWith(String email);
}
