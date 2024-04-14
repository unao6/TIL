package io.elice.elcademy.review;

import io.elice.elcademy.subject.entity.Subject;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectReviewId;

    @Column(nullable = false)
    private int numberOfReviews;

    @Column(nullable = false)
    private int rating;

    @OneToOne
    @JoinColumn(name = "subjectId")
    private Subject subject;

    public SubjectReview(int numberOfReviews, int rating, Subject subject) {
        this.numberOfReviews = numberOfReviews;
        this.rating = rating;
        this.subject = subject;
    }
}