package com.mindfire.feedback.error;

import com.mindfire.feedback.constant.MessageConstants;
import com.mindfire.feedback.exception.EmployeeNotFound;
import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        if (response.status() == HttpStatus.NOT_FOUND.value()) {
            throw new EmployeeNotFound(MessageConstants.EMPLOYEE_NOT_FOUND);
        } else if (response.status() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            throw new RuntimeException(MessageConstants.INTERNAL_SERVER_ERROR);
        }

        return new RuntimeException(MessageConstants.SOMETHING_WENT_WRONG);
    }
}
