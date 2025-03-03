package com.mindfire.feedback.mapper;

import com.mindfire.feedback.constant.FeedbackStatus;
import com.mindfire.feedback.dto.performance.FeedbackRequestDto;
import com.mindfire.feedback.dto.performance.FeedbackResponseDto;
import com.mindfire.feedback.model.Feedback;
import org.springframework.beans.BeanUtils;

public class FeedbackMapper {
    /**
     * Maps the given FeedbackRequestDto to a Feedback entity.
     *
     * @param feedbackRequestDto The FeedbackRequestDto object containing the feedback data.
     * @return A Feedback entity populated with data from the FeedbackRequestDto.
     */
    public static Feedback mapRequest(FeedbackRequestDto feedbackRequestDto) {
        Feedback feedback = new Feedback();

        BeanUtils.copyProperties(feedbackRequestDto, feedback);

        feedback.setFeedbackStatus(FeedbackStatus.valueOf(feedbackRequestDto.feedbackStatus().toUpperCase()));

        return feedback;
    }

    /**
     * Maps the given Feedback entity to a FeedbackResponseDto.
     *
     * @param feedback The Feedback entity to be mapped.
     * @return A FeedbackResponseDto containing the data from the Feedback entity.
     */
    public static FeedbackResponseDto mapResponse(Feedback feedback) {

        return new FeedbackResponseDto(feedback.getId(),
                feedback.getFeedbackStatus(),
                feedback.getDescription());
    }
}
