package com.mindfire.feedback.dto.performance;

import com.mindfire.feedback.constant.FeedbackStatus;

public record FeedbackResponseDto(long id, FeedbackStatus feedbackStatus, String description) {
}
