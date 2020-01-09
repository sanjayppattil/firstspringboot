package com.sanjay.internship.controller;

import com.sanjay.internship.model.EmployeeForm;
import com.sanjay.internship.service.EmployeeFormImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EmployeeFormController {
    @Autowired
    private EmployeeFormImp employeeFormImp;
    public static final String BASE_FORM = "register";

    @GetMapping("/")
    public String showForm(EmployeeForm employeeForm) {
      return "register";
    }

    @PostMapping("/")
    public String registerForm(@Valid EmployeeForm employeeForm, Errors errors, Model model) {
        if (errors.hasErrors()) {
          return "register";
        } else {
            model.addAttribute("message", "Registration successfully...");
            employeeFormImp.formDetails(employeeForm);
          return "register";
        }
    }

    @GetMapping("getbysalaryGt/{salary}")
    public List<EmployeeForm> getall(@PathVariable float salary) {
        return employeeFormImp.getAllEmployee(salary);
    }

    @GetMapping("getbysalaryLt/{salary}")
    public List<EmployeeForm> getallLt(@PathVariable float salary) {
        return employeeFormImp.getAllEmployeelt(salary);
    }

    @GetMapping("getbysalaryBw/{salary}/{salarylt}")
    public List<EmployeeForm> getallBetween(@PathVariable float salary, @PathVariable float salarylt) {
        return employeeFormImp.getAllEmployeeBetween(salary, salarylt);
    }

    @GetMapping("getnamestarta/{name}")
    public List<EmployeeForm> getNameA(@PathVariable String name) {
        return employeeFormImp.getNamestarA(name);
    }


}
