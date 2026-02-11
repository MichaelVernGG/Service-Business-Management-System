package com.michael.sbms.controller;

import com.michael.sbms.model.Customer;
import com.michael.sbms.model.JobOrder;
import com.michael.sbms.service.CustomerService;
import com.michael.sbms.service.JobOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/jobs")
public class JobOrderController {

    @Autowired
    private JobOrderService jobService;

    @Autowired
    private CustomerService customerService;

    // List all jobs
    @GetMapping
    public String listJobs(Model model) {
        List<JobOrder> jobs = jobService.getAll();
        model.addAttribute("jobs", jobs);
        return "job-list";
    }

    // New job form
    @GetMapping("/new")
    public String newJob(Model model) {
        model.addAttribute("jobOrder", new JobOrder());
        model.addAttribute("customers", customerService.getAll());
        return "job-form";
    }

    @PostMapping("/save")
    public String saveJob(@ModelAttribute JobOrder jobOrder) {
        if (jobOrder.getDate() == null) {
            jobOrder.setDate(LocalDate.now());
        }

        // Ensure Customer object is fully loaded
        Long customerId = jobOrder.getCustomer().getId();
        Customer customer = customerService.getById(customerId);
        jobOrder.setCustomer(customer);

        jobService.save(jobOrder);
        return "redirect:/jobs";
    }


    // Edit job
    @GetMapping("/edit/{id}")
    public String editJob(@PathVariable Long id, Model model) {
        JobOrder job = jobService.getById(id);
        model.addAttribute("jobOrder", job);
        model.addAttribute("customers", customerService.getAll());
        return "job-form";
    }

    // Delete job
    @GetMapping("/delete/{id}")
    public String deleteJob(@PathVariable Long id) {
        jobService.delete(id);
        return "redirect:/jobs";
    }
}
