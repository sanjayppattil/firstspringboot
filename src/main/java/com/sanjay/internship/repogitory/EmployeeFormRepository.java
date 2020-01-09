package com.sanjay.internship.repogitory;

import com.sanjay.internship.model.EmployeeForm;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeFormRepository extends MongoRepository<EmployeeForm,String> {
}
