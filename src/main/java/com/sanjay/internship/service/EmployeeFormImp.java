package com.sanjay.internship.service;

import com.sanjay.internship.dao.EmployeeFormDAO;
import com.sanjay.internship.model.EmployeeForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeFormImp {
  @Autowired private EmployeeFormDAO employeeFormDAO;
  private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

  public void formDetails(EmployeeForm employeeForm) {
    String uid = UUID.randomUUID().toString();
    employeeForm.setEmployeeId(uid.substring(uid.length() - 4));
    Date currentDate = new Date();
    employeeForm.setStartDate(dateFormat.format(currentDate));
    Calendar c = Calendar.getInstance();
    c.add(Calendar.YEAR, 1);
    Date currentDatePlusOne = c.getTime();
    employeeForm.setEndDate(dateFormat.format(currentDatePlusOne));
    employeeFormDAO.createForm(employeeForm);
  }

  public EmployeeForm getFormById(String id, String name, String course) {
    return employeeFormDAO.getUserById(id, name, course);
  }
 public List<EmployeeForm> getAllEmployee(float salary){
    return employeeFormDAO.getAll(salary);
 }
 public void delete(){
    employeeFormDAO.deleteAll();
 }
  public List<EmployeeForm> getAllEmployeelt(float salary){
    return employeeFormDAO.getAllLt(salary);
  }
  public List<EmployeeForm> getAllEmployeeBetween(float salary, float salary1){
    return employeeFormDAO.getAllBetween(salary,salary1);
  }
  public List<EmployeeForm> getNamestarA(String name){
    return employeeFormDAO.getNameStartA(name);
  }
}
