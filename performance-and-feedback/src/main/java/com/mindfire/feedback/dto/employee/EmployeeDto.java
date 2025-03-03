package com.mindfire.feedback.dto.employee;

import java.time.LocalDate;

public record EmployeeDto(int id, String name, String email, double salary, LocalDate dateOfJoining) {
}

