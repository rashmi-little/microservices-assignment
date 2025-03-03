package com.mindfire.feedback.dto.performance;

import com.mindfire.feedback.constant.FeedbackStatus;
import com.mindfire.feedback.constant.MessageConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record FeedbackRequestDto(@NotNull(message = MessageConstants.REQUIRED_FIELD)
                                 @Pattern(regexp = MessageConstants.FEEDBACK_STATUS, message = MessageConstants.FEEDBACK_STATUS_CONSTRAIN_MESSAGE)
                                 String feedbackStatus,

                                 @NotBlank(message = MessageConstants.REQUIRED_FIELD)
                                 @Size(max = 300, message = MessageConstants.MAX_Length)
                                 String description) {
}
