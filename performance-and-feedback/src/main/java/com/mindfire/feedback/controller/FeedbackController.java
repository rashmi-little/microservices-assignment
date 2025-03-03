package com.mindfire.feedback.controller;

import com.mindfire.feedback.dto.EmployeeWithFeedback;
import com.mindfire.feedback.dto.performance.FeedbackRequestDto;
import com.mindfire.feedback.dto.performance.FeedbackResponseDto;
import com.mindfire.feedback.service.FeedbackService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class FeedbackController {
    private final FeedbackService feedbackService;

    @GetMapping("/feedbacks/{employeeId}")
    public ResponseEntity<EmployeeWithFeedback> getAllFeedback(@PathVariable int employeeId) {
        EmployeeWithFeedback response = feedbackService.getAllFeedback(employeeId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/feedbacks/{employeeId}")
    public ResponseEntity<EmployeeWithFeedback> saveFeedback(@PathVariable int employeeId,
                                                             @Valid @RequestBody FeedbackRequestDto feedbackRequestDto) {
        EmployeeWithFeedback response = feedbackService.saveFeedback(employeeId, feedbackRequestDto);
        return new ResponseEntity<EmployeeWithFeedback>(response, HttpStatus.CREATED);
    }


}
