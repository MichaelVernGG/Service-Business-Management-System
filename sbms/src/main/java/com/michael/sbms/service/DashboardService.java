package com.michael.sbms.service;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

import com.michael.sbms.repository.CustomerRepository;
import com.michael.sbms.repository.JobOrderRepository;
import com.michael.sbms.model.JobOrder;

@Service
public class DashboardService {

    private final CustomerRepository customerRepository;
    private final JobOrderRepository jobOrderRepository;

    // Constructor Injection (Manual)
    public DashboardService(CustomerRepository customerRepository,
                            JobOrderRepository jobOrderRepository) {
        this.customerRepository = customerRepository;
        this.jobOrderRepository = jobOrderRepository;
    }

    public long getTotalCustomers() {
        return customerRepository.count();
    }

    public long getTotalJobOrders() {
        return jobOrderRepository.count();
    }

    public double getTodaySales() {
        List<JobOrder> todayOrders = jobOrderRepository.findByDate(LocalDate.now());
        return todayOrders.stream()
                .mapToDouble(JobOrder::getAmount)
                .sum();
    }

    public double getMonthlySales() {
        YearMonth currentMonth = YearMonth.now();
        LocalDate start = currentMonth.atDay(1);
        LocalDate end = currentMonth.atEndOfMonth();

        List<JobOrder> monthlyOrders =
                jobOrderRepository.findByDateBetween(start, end);

        return monthlyOrders.stream()
                .mapToDouble(JobOrder::getAmount)
                .sum();
    }
}
