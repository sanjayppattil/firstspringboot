package com.sanjay.internship.dao;

import com.sanjay.internship.model.EmployeeForm;
import com.sanjay.internship.repogitory.EmployeeFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeFormDAO {
    @Autowired
    private EmployeeFormRepository employeeFormRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private MongoOperations mongoOperations;
    public void createForm(EmployeeForm employeeForm)
    {
        employeeFormRepository.save(employeeForm);
    }
    public EmployeeForm getUserById(String employeeId, String name, String department) {
        Query query = new Query();
        query.addCriteria(new Criteria().andOperator(Criteria.where("employeeId").is(employeeId),Criteria.where("name").is(name),Criteria.where("department").is(department)));
        return mongoTemplate.findOne(query, EmployeeForm.class);
    }
    public List<EmployeeForm> getAll(float salary){
        Query query=new Query();
        query.addCriteria(Criteria.where("salary").gt(salary));
        return mongoOperations.find(query, EmployeeForm.class);
    }
    public void deleteAll(){
        employeeFormRepository.deleteAll();
    }
    public List<EmployeeForm> getAllLt(float salary){
        Query query=new Query();
        query.addCriteria(Criteria.where("salary").lt(salary));
        return mongoOperations.find(query, EmployeeForm.class);
    }
    public List<EmployeeForm> getAllBetween(float salary, float salary1){
        Query query=new Query();
        query.addCriteria(Criteria.where("salary").lt(salary).gt(salary1));
        return mongoOperations.find(query, EmployeeForm.class);
    }

  public List<EmployeeForm> getNameStartA(String name) {
    Query query = new Query();
    query.addCriteria(Criteria.where("name").regex("^"+name));
    return mongoTemplate.find(query, EmployeeForm.class);
    }
}
