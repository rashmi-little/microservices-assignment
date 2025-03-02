package com.mindfire.feedback.dto;

import com.mindfire.feedback.constant.FeedbackStatus;

public record FeedbackResponseDto(long id, FeedbackStatus feedbackStatus, String description) {
}
