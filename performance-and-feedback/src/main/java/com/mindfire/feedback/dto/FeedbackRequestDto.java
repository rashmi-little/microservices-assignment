package com.mindfire.feedback.dto;

import com.mindfire.feedback.constant.FeedbackStatus;

public record FeedbackRequestDto(FeedbackStatus feedbackStatus, String description) {
}
