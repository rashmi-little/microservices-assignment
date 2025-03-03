package com.mindfire.feedback.service;

import com.mindfire.feedback.dto.EmployeeWithFeedback;
import com.mindfire.feedback.dto.performance.FeedbackRequestDto;
import com.mindfire.feedback.dto.performance.FeedbackResponseDto;

import java.util.List;

public interface FeedbackService {
    /**
     * Saves the feedback for a specific employee.
     *
     * @param employeeId         The ID of the employee for whom the feedback is being saved.
     * @param feedbackRequestDto The DTO containing the feedback details from the client.
     * @return A DTO containing the saved feedback details with employee details
     */
    EmployeeWithFeedback saveFeedback(int employeeId, FeedbackRequestDto feedbackRequestDto);

    /**
     * Retrieves all feedback records for a specific employee.
     *
     * @param employeeId The ID of the employee whose feedback records are to be fetched.
     * @return  A DTO containing the feedback details with employee details
     */
    EmployeeWithFeedback getAllFeedback(int employeeId);
}
