package com.mindfire.feedback.model;

import com.mindfire.feedback.constant.FeedbackStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "feedback_status")
    @NotNull
    private FeedbackStatus feedbackStatus;

    @Column(name = "description", length = 300)
    private String description;
}
