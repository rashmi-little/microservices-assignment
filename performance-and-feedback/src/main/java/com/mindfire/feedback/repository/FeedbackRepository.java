package com.mindfire.feedback.repository;

import com.mindfire.feedback.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    /**
     * Retrieves all feedback records associated with a specific employee.
     *
     * @param employeeId The ID of the employee whose feedback records are to be retrieved.
     * @return A list of Feedback entities associated with the given employee ID.
     */
    List<Feedback> findAllByEmployeeId(int employeeId);
}
