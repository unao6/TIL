package io.elice.elcademy.registration;

import io.elice.elcademy.subject.entity.Subject;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RegistrationSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registrationSubjectId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "registration_id")
    private Registration registration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    private int price;
}