package com.michael.sbms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.michael.sbms.service.DashboardService;

@Controller
public class DashboardController {

    private final DashboardService dashboardService;

    // Constructor Injection (Manual)
    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        model.addAttribute("totalCustomers", dashboardService.getTotalCustomers());
        model.addAttribute("totalJobOrders", dashboardService.getTotalJobOrders());
        model.addAttribute("todaySales", dashboardService.getTodaySales());
        model.addAttribute("monthlySales", dashboardService.getMonthlySales());
        model.addAttribute("totalSales", dashboardService.getTotalSales());

        return "dashboard";
    }
}
