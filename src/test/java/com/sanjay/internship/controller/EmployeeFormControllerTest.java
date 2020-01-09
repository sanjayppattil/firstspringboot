package com.sanjay.internship.controller;

import com.sanjay.internship.model.EmployeeForm;
import com.sanjay.internship.repogitory.EmployeeFormRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeeFormControllerTest {
    @InjectMocks
    private EmployeeFormController employeeFormController;
    @Mock
    private EmployeeFormRepository employeeFormRepository;
    @Test
    public void create_OrderProduct_success(){
        EmployeeForm employeeForm =new EmployeeForm();
        employeeForm.setEndDate("2019/10/9");
        employeeForm.setStartDate("2019/10/9");
        employeeForm.setAddress("bengalure");
        employeeForm.setDepartment("HR");
        employeeForm.setEmail("sanjay@gmail.com");
        employeeForm.setEmployeeId("133e");
        employeeForm.setName("sanjay");
        employeeForm.setPassword("sanjay");
        employeeForm.setSalary(40000);
        employeeForm.setTelephone("948116649");
        //employeeFormController.create(employeeForm);
        Mockito.verify(employeeFormRepository, Mockito.times(1)).save(employeeForm);

    }

}
