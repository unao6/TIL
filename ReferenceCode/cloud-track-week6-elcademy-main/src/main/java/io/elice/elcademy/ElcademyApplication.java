package io.elice.elcademy;

import io.elice.elcademy.member.repository.MemberRepository;
import io.elice.elcademy.subject.repository.SubjectRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class ElcademyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElcademyApplication.class, args);
	}

	@Bean
	@Profile("local")
	public DataInit stubDataInit(SubjectRepository subjectRepository, MemberRepository memberRepository) {
		return new DataInit(subjectRepository, memberRepository);
	}
}