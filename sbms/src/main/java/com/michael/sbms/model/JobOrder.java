package com.michael.sbms.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class JobOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Job ID

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private String serviceType;
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    private LocalDate date;

    // Enums
    public enum Status {
        PENDING, IN_PROGRESS, DONE
    }

    public enum PaymentStatus {
        PAID, UNPAID
    }

    // Constructors
    public JobOrder() {}

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public PaymentStatus getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(PaymentStatus paymentStatus) { this.paymentStatus = paymentStatus; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
}
