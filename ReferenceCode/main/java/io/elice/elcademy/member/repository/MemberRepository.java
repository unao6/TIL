package io.elice.elcademy.member.repository;

import io.elice.elcademy.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // 지시사항을 참고하여 코드를 작성해 보세요. 
    List<Member> findByEmailEndingWith(String email);
}