package com.mindfire.feedback.client;

import com.mindfire.feedback.config.FeignConfig;
import com.mindfire.feedback.dto.employee.EmployeeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * The {@code EmployeeApi} interface is a Feign client used for communicating with the
 * Employee Management Service. It provides methods to interact with the service's
 * REST endpoints for employee-related operations.
 */
@FeignClient(name = "EMPLOYEE-MANAGEMENT-SERVICE", configuration = FeignConfig.class)
public interface EmployeeApi {

    /**
     * Fetches an employee's details by their ID from the Employee Management Service.
     *
     * @param id The unique identifier of the employee.
     * @return A {@link ResponseEntity} containing the employee's data as an {@link EmployeeDto} object.
     * Returns 404 if the employee is not found.
     */
    @GetMapping("/api/v1/employees/{id}")
    public ResponseEntity<EmployeeDto> getById(@PathVariable int id);
}
