/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mypkg.repository.repoimpl;

import com.mypkg.domain.Employee;
import com.mypkg.repository.EmployeeRepository;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepositoryImplementation implements EmployeeRepository {
     private SessionFactory sf;
    
    
    private List<Employee> listOfEmployees;
    
      
    @Override
    public List<Employee> getAllEmployees()
    {
        listOfEmployees = new ArrayList<Employee>();
          Configuration cf=new Configuration();
            cf.configure("hibernate.cfg.xml");
            
            SessionFactory sf=cf.buildSessionFactory();
            Session hsession=sf.openSession();
            Transaction tx=hsession.beginTransaction();     
           List<Object[]> empObjects=hsession.createSQLQuery("SELECT id,emp_name,dept_name FROM employee e, department d where e.dept_id=d.dept_id").list();
                for(Object[] employeeObject: empObjects) {
            Employee employee = new Employee();
            int id = ((int) employeeObject[0]);         
            
            String ename = (String) employeeObject[1];
            String dname = (String) employeeObject[2];
            employee.setId(id);
            employee.setEmpName(ename);
            employee.setDeptName(dname);
            
            listOfEmployees.add(employee);
        }

            tx.commit();
            return listOfEmployees;

    }
    
    @Override
    public void deleteEmployee(int id)
    {
      //  String sql = "DELETE FROM employee WHERE id=?";
    //jdbc.update(sql, id);
        Configuration cf=new Configuration();
            cf.configure("hibernate.cfg.xml");
            
            SessionFactory sf=cf.buildSessionFactory();
            Session hsession=sf.openSession();
            Transaction tx=hsession.beginTransaction();
            String hql="DELETE from Employee where id=:emp_id";
            Query q=hsession.createQuery(hql);
            q.setParameter("emp_id", id);
            int result=q.executeUpdate();
          
            if(result==1)
            {
            tx.commit();
            }
            else{
                tx.rollback();
            }
    }
    
    @Override
    public void addEmployee(int id, String emp_name,int dept_id)
    {
       Configuration cf=new Configuration();
                cf.configure("hibernate.cfg.xml");
                
                SessionFactory sf=cf.buildSessionFactory();
                Session hsession=sf.openSession();
                Transaction tx=hsession.beginTransaction();
                Query query = hsession.createSQLQuery("INSERT INTO EMPLOYEE VALUES (:id,:ename,:deptid)");
query.setInteger("id", id); 
query.setString("ename", emp_name);
query.setInteger("deptid", dept_id);
query.executeUpdate();
                tx.commit();
                
    }
    
}
