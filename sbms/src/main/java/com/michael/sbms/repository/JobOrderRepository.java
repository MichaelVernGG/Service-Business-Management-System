package com.michael.sbms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.michael.sbms.model.JobOrder;

import java.time.LocalDate;
import java.util.List;

public interface JobOrderRepository extends JpaRepository<JobOrder, Long> {

    List<JobOrder> findByDate(LocalDate date);

    List<JobOrder> findByDateBetween(LocalDate start, LocalDate end);
}
