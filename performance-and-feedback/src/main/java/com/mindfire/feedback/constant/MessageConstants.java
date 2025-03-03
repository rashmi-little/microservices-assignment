package com.mindfire.feedback.constant;

public class MessageConstants {
    public static final String REQUIRED_FIELD = "Must provide value for the field";
    public static final String SERVICE_UNAVAILABLE = "Service is currently unavailable. Please try again later";
    public static final String INTERNAL_SERVER_ERROR = "Internal server error. Please try again later";
    public static final String EMPLOYEE_NOT_FOUND = "Employee not found in the service";
    public static final String SOMETHING_WENT_WRONG = "Something went wrong please try again later";

    public static final String DUMMY_USER = "Dummy user";
    public static final String DUMMY_USER_EMAIL = "Dummy@gmail.com";
    public static final String MAX_Length = "field size can not be more than 300";
    public static final String POSITIVE_CONSTRAINT = "field value must be positive";
    public static final String FEEDBACK_STATUS = "^(?i)(SLOW|AVERAGE|FAST|EXCEPTIONAL)$";
    public static final String FEEDBACK_STATUS_CONSTRAIN_MESSAGE = "Field value can be of only slow,average,fast,exceptional";
}
