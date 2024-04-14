package io.elice.elcademy.subject.entity;

import io.elice.elcademy.registration.RegistrationSubject;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectId;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, updatable = false)
    private int price;

    // 지시사항을 참고하여 코드를 작성해 보세요.
    @OneToMany(mappedBy = "subject")
    private List<RegistrationSubject> registrationSubjects = new ArrayList<>();

    public Subject(String name, int price) {
        this.name = name;
        this.price = price;
    }
}