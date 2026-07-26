# SBMS – Service Business Management System

A simple web-based management system for service businesses built with **Spring Boot, Thymeleaf, and MySQL**.  
This project allows admin users to manage customers, job orders, and view basic dashboard statistics.

---

## Features

### 1️⃣ Authentication
- Admin login system
- Simple username/password check

### 2️⃣ Dashboard
- Displays key statistics:
  - Total Customers
  - Total Job Orders
  - Today’s Sales
  - Monthly Sales
- Buttons to navigate to **Customer Management** and **Job Orders**

### 3️⃣ Customer Management
- Add, edit, delete customers
- Search by name/contact
- Fields:
  - Name
  - Contact Number
  - Address
  - Notes

### 4️⃣ Job Order Management
- Manage service job orders
- Fields:
  - Job ID
  - Customer
  - Service Type
  - Description
  - Status (Pending / In Progress / Done)
  - Amount
  - Payment Status (Paid / Unpaid)
  - Date
- Validation ensures proper binding between job and customer
- Dropdown selection for customer and service type for consistency

---

## Project Structure

sbms/
├─ src/
│ ├─ main/
│ │ ├─ java/com/michael/sbms/
│ │ │ ├─ controller/ ← Spring Controllers
│ │ │ ├─ model/ ← JPA Entities (Customer, JobOrder)
│ │ │ ├─ repository/ ← Spring Data Repositories
│ │ │ ├─ service/ ← Business logic
│ │ │ └─ SbmsApplication.java
│ │ └─ resources/
│ │ ├─ templates/ ← Thymeleaf HTML pages
│ │ └─ application.properties
├─ pom.xml
└─ README.md


---

## How to Run

### Prerequisites
- Java 17+
- Maven
- MySQL database

### Steps

1. Clone the repository:

```bash
git clone https://github.com/MichaelVernGG/sbms.git
```

2.Create MySQL database:
CREATE DATABASE sbms;

3.Configure src/main/resources/application.properties with your database credentials:
spring.datasource.url=jdbc:mysql://localhost:3306/sbms
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

4.Run the application:
mvn spring-boot:run

5.Open browser:
http://localhost:8080

Navigation

Dashboard → Overview & statistics

Customers → Customer Management (Add/Edit/Delete/Search)

Job Orders → Manage all service jobs

Adding New Features

To add a new page:

Create a new HTML file in templates/

Create a new controller method with @GetMapping or @PostMapping

Add navigation link to dashboard or menu bar

To add new service types:

Update the dropdown in job-form.html and JobOrder entity if needed

Author

Created by Michael Vern
---



