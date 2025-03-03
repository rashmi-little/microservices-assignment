package com.mindfire.feedback.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class HandleException {

    /**
     * Handles general exceptions thrown in the application.
     * <p>
     * This method catches all exceptions of type {@link Exception} and returns a {@link ProblemDetail}
     * with a status code of 500 (Internal Server Error) and the exception message as the detail.
     *
     * @param exception the exception that was thrown
     * @return a {@link ProblemDetail} representing the error response with HTTP status 500
     */
    @ExceptionHandler(Exception.class)
    public ProblemDetail handleException(Exception exception) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.valueOf(500), exception.getMessage());
    }

    /**
     * Handles exceptions thrown when an employee is not found.
     * <p>
     * This method specifically handles the {@link EmployeeNotFound} exception and returns a {@link ProblemDetail}
     * with a status code of 404 (Not Found) and the exception message as the detail.
     *
     * @param exception the {@link EmployeeNotFound} exception that was thrown
     * @return a {@link ProblemDetail} representing the error response with HTTP status 404
     */
    @ExceptionHandler(EmployeeNotFound.class)
    public ProblemDetail notFound(EmployeeNotFound exception) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.valueOf(404), exception.getMessage());
    }

    /**
     * Handles validation exceptions that occur when method argument validation fails.
     * <p>
     * This method catches {@link MethodArgumentNotValidException} exceptions and returns a {@link ResponseEntity}
     * with a map of validation error messages. The response has HTTP status 400 (Bad Request), and each field
     * that failed validation will have its corresponding error message.
     *
     * @param exception the {@link MethodArgumentNotValidException} exception containing validation errors
     * @return a {@link ResponseEntity} containing a map of field names and error messages with HTTP status 400
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();

        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
