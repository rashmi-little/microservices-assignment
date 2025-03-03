package com.mindfire.feedback.exception;

/*
 * Custom exception when employee not found
 *
 */
public class EmployeeNotFound extends RuntimeException {
    public EmployeeNotFound(String message) {
        super(message);
    }
}
