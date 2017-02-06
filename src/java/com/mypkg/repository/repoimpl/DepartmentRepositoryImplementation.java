/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mypkg.repository.repoimpl;

import com.mypkg.domain.Department;
import com.mypkg.domain.Employee;
import com.mypkg.repository.DepartmentRepository;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;


@Repository
public class DepartmentRepositoryImplementation implements DepartmentRepository {
     private List<Department> listOfDepartments;
        
    
    @Override
    public List<Department> getAllDepartments()
    {
        listOfDepartments = new ArrayList<Department>();
        Configuration cf=new Configuration();
            cf.configure("hibernate.cfg.xml");
            
            SessionFactory sf=cf.buildSessionFactory();
            Session hsession=sf.openSession();
            Transaction tx=hsession.beginTransaction();     
           List<Object[]> deptObjects=hsession.createSQLQuery("SELECT dept_id,dept_name FROM department").list();
                for(Object[] deptObject: deptObjects) {
            Department dept = new Department();
            int id = ((int) deptObject[0]);         
            
           
            String dname = (String) deptObject[1];
            dept.setDeptId(id);
            dept.setDeptName(dname);
            
            listOfDepartments.add(dept);
        }

            tx.commit();
            return listOfDepartments;
        
    }
}
