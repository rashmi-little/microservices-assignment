package com.mindfire.feedback.dto;

import com.mindfire.feedback.dto.employee.EmployeeDto;
import com.mindfire.feedback.dto.performance.FeedbackResponseDto;

import java.util.List;

public record EmployeeWithFeedback(EmployeeDto employeeDto, List<FeedbackResponseDto> feedbackResponseDto) {
}
