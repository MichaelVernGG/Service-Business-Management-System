package com.michael.sbms.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

import com.michael.sbms.repository.CustomerRepository;
import com.michael.sbms.repository.JobOrderRepository;
import com.michael.sbms.util.FormatUtil;
import com.michael.sbms.model.JobOrder;

@Service
public class DashboardService {

    private final CustomerRepository customerRepository;
    private final JobOrderRepository jobOrderRepository;
    private final FormatUtil formatUtil;
    // Constructor Injection (Manual)
    public DashboardService(CustomerRepository customerRepository,
                            JobOrderRepository jobOrderRepository, FormatUtil formatUtil) {
        this.customerRepository = customerRepository;
        this.jobOrderRepository = jobOrderRepository;
        this.formatUtil = formatUtil;
    }

    public long getTotalCustomers() {
        return customerRepository.count();
    }

    public long getTotalJobOrders() {
        return jobOrderRepository.count();
    }

    public String getTodaySales() {
    	double todaySales = 0;
        List<JobOrder> todayOrders = jobOrderRepository.findByDate(LocalDate.now());
        todaySales = todayOrders.stream()
                .mapToDouble(JobOrder::getAmount)
                .sum();
        
        return FormatUtil.formatMoney(BigDecimal.valueOf(todaySales));
    }

    public String getMonthlySales() {
    	double monthlySales = 0;
        YearMonth currentMonth = YearMonth.now();
        LocalDate start = currentMonth.atDay(1);
        LocalDate end = currentMonth.atEndOfMonth();

        List<JobOrder> monthlyOrders =
                jobOrderRepository.findByDateBetween(start, end);

        monthlySales = monthlyOrders.stream()
                .mapToDouble(JobOrder::getAmount)
                .sum();

        return FormatUtil.formatMoney(BigDecimal.valueOf(monthlySales));
    }
    
    public String getTotalSales() {
    	
    	double totalSales = 0;
    	List<JobOrder> listOfTotalSales = jobOrderRepository.findAll();
    	for(JobOrder listOfTotalSale : listOfTotalSales) {
    		totalSales +=  listOfTotalSale.getAmount();
    	}
    	return FormatUtil.formatMoney(BigDecimal.valueOf(totalSales));
    }
}
