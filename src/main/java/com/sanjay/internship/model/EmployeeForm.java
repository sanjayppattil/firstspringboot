package com.sanjay.internship.model;

import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;
@Data
@Document("form")
public class EmployeeForm {
    @Id
    private String employeeId;
    @NotNull
    @Size(min = 3, max = 10, message = "length shoud be in between 3 to 10")
    private String name;
    @NotNull
    @Size(min = 3, max = 20)
    private String address;
    @NotEmpty(message = "Email field should not be empty")
    @Email(regexp = "^(.+)@(.+)$", message = "Invalid email pattern")
    private String email;
    @NotNull
    @Size(min = 3, max = 20,message = "password must be enter")
    private String password;
    @Pattern(regexp = "[7-9][0-9]{9}", message = "invalid mobile number.")
    @Size(max = 10, message = "digits should be 10")
    private String  telephone;
    @NotNull
    @Size(min = 2, max = 20,message = "Department must be enter")
    private String department;
    @NotNull(message = "please enter salary")
    private float salary;
    private String endDate;
    private String startDate;


    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

 }
