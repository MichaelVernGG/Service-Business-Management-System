package com.michael.sbms.service;

import com.michael.sbms.model.JobOrder;
import com.michael.sbms.repository.JobOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobOrderService {

    @Autowired
    private JobOrderRepository repository;

    public void save(JobOrder jobOrder) {
        repository.save(jobOrder);
    }

    public List<JobOrder> getAll() {
        return repository.findAll();
    }

    public JobOrder getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
