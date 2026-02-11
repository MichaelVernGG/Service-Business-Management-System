package com.michael.sbms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.michael.sbms.model.Customer;
import com.michael.sbms.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public String listCustomers(Model model) {
        model.addAttribute("customers", service.getAll());
        return "customers";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute Customer customer) {
        System.out.println("Saving customer ID: " + customer.getId());
        service.save(customer);
        return "redirect:/customers";
    }


    @GetMapping("/edit/{id}")
    public String editCustomer(@PathVariable Long id, Model model) {
        Customer existing = service.getById(id);
        model.addAttribute("customer", existing);  // <-- passes full customer including ID
        return "customer-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/customers";
    }

    @GetMapping("/search")
    public String search(@RequestParam String name, Model model) {
        model.addAttribute("customers", service.searchByName(name));
        return "customers";
    }
}
