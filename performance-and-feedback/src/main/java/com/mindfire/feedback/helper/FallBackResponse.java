package com.mindfire.feedback.helper;

import com.mindfire.feedback.constant.FeedbackStatus;
import com.mindfire.feedback.constant.MessageConstants;
import com.mindfire.feedback.dto.EmployeeWithFeedback;
import com.mindfire.feedback.dto.employee.EmployeeDto;
import com.mindfire.feedback.dto.performance.FeedbackResponseDto;

import java.util.List;

public class FallBackResponse {
    public static EmployeeWithFeedback getDummyRespones() {
        EmployeeDto dummyEmployee = new EmployeeDto(0, MessageConstants.DUMMY_USER, MessageConstants.DUMMY_USER_EMAIL, 0, null);
        FeedbackResponseDto feedbackResponseDto = new FeedbackResponseDto(0, FeedbackStatus.SLOW, MessageConstants.SERVICE_UNAVAILABLE);
        return new EmployeeWithFeedback(dummyEmployee, List.of(feedbackResponseDto));
    }
}
