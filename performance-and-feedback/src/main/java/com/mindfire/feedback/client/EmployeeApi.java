package com.mindfire.feedback.client;

import com.mindfire.feedback.config.FeignConfig;
import com.mindfire.feedback.dto.employee.EmployeeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "EMPLOYEE-MANAGEMENT-SERVICE", configuration = FeignConfig.class)
public interface EmployeeApi {
    @GetMapping("/api/v1/employees/{id}")
    public ResponseEntity<EmployeeDto> getById(@PathVariable int id);
}
