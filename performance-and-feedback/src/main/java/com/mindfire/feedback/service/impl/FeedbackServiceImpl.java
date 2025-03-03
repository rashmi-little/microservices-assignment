package com.mindfire.feedback.service.impl;

import com.mindfire.feedback.client.EmployeeApi;
import com.mindfire.feedback.constant.FeedbackStatus;
import com.mindfire.feedback.constant.MessageConstants;
import com.mindfire.feedback.dto.EmployeeWithFeedback;
import com.mindfire.feedback.dto.employee.EmployeeDto;
import com.mindfire.feedback.dto.performance.FeedbackRequestDto;
import com.mindfire.feedback.dto.performance.FeedbackResponseDto;
import com.mindfire.feedback.exception.EmployeeNotFound;
import com.mindfire.feedback.helper.FallBackResponse;
import com.mindfire.feedback.mapper.FeedbackMapper;
import com.mindfire.feedback.model.Feedback;
import com.mindfire.feedback.repository.FeedbackRepository;
import com.mindfire.feedback.service.FeedbackService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final EmployeeApi employeeApi;

    @Override
    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "saveFeedbackFallback")
    public EmployeeWithFeedback saveFeedback(int employeeId, FeedbackRequestDto feedbackRequestDto) {
        EmployeeDto employeeDto = getEmployee(employeeId);

        Feedback feedback = FeedbackMapper.mapRequest(feedbackRequestDto);
        feedback.setEmployeeId(employeeId);

        feedbackRepository.save(feedback);

        FeedbackResponseDto responseDto = FeedbackMapper.mapResponse(feedback);

        return new EmployeeWithFeedback(employeeDto, List.of(responseDto));

    }

    @Override
    @CircuitBreaker(name = "performance-and-feedback", fallbackMethod = "getAllFeedbackFallback")
    public EmployeeWithFeedback getAllFeedback(int employeeId) {
        EmployeeDto employeeDto = getEmployee(employeeId);

        List<Feedback> feedbacks = feedbackRepository.findAllByEmployeeId(employeeId);

        List<FeedbackResponseDto> feedbackResponseDtos = feedbacks.stream().map(FeedbackMapper::mapResponse).toList();
        return new EmployeeWithFeedback(employeeDto, feedbackResponseDtos);
    }

    // fall back method for the saveFeedback if employee service is unavailable
    public EmployeeWithFeedback saveFeedbackFallback(int employeeId, FeedbackRequestDto feedbackRequestDto, Throwable throwable) {
        if (throwable instanceof EmployeeNotFound) {
            // Let the global exception handler handle the not found case
            throw new EmployeeNotFound(MessageConstants.EMPLOYEE_NOT_FOUND);
        }
        return FallBackResponse.getDummyRespones();
    }

    // fall back method for the getAllFeedback if employee service is unavailable
    public EmployeeWithFeedback getAllFeedbackFallback(int employeeId, Throwable throwable) {
        if (throwable instanceof EmployeeNotFound) {
            // Let the global exception handler handle the not found case
            throw new EmployeeNotFound(MessageConstants.EMPLOYEE_NOT_FOUND);
        }
        return FallBackResponse.getDummyRespones();
    }

    private EmployeeDto getEmployee(int employeeId) {
        ResponseEntity<EmployeeDto> employee = employeeApi.getById(employeeId);

        return employee.getBody();
    }
}
