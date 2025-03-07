package com.mindfire.feedback.model;

import com.mindfire.feedback.constant.FeedbackStatus;
import com.mindfire.feedback.constant.MessageConstants;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
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
    @Column(name = "feedback_status", nullable = false)
    private FeedbackStatus feedbackStatus;

    @Column(name = "description", length = 300, nullable = false)
    private String description;

    @Column(name = "emp_id", nullable = false)
    private int employeeId;
}
