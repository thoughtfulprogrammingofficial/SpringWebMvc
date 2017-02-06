package com.mypkg.domain;
// Generated 6 Feb, 2017 2:08:30 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;


public class Department  implements java.io.Serializable {


     private int deptId;
     private String deptName;
     private Set employees = new HashSet(0);

    public Department() {
    }

	
    public Department(int deptId) {
        this.deptId = deptId;
    }
    public Department(int deptId, String deptName, Set employees) {
       this.deptId = deptId;
       this.deptName = deptName;
       this.employees = employees;
    }
   
    public int getDeptId() {
        return this.deptId;
    }
    
    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
    public String getDeptName() {
        return this.deptName;
    }
    
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public Set getEmployees() {
        return this.employees;
    }
    
    public void setEmployees(Set employees) {
        this.employees = employees;
    }




}


