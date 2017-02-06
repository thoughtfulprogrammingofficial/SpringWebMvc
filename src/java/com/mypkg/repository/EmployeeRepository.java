package com.mypkg.repository;

import java.util.List;
import com.mypkg.domain.Employee;
public interface EmployeeRepository {
     List <Employee> getAllEmployees();
    void deleteEmployee(int id);
    void addEmployee(int id, String emp_name,int dept_id);
}
