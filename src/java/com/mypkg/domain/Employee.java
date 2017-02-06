package com.mypkg.domain;

public class Employee  implements java.io.Serializable {


     private int id;
     private Department department;
     private String empName;
     private int deptId;

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
     private String deptName;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Employee() {
    }

	
    public Employee(int id) {
        this.id = id;
    }
    public Employee(int id, Department department, String empName) {
       this.id = id;
       this.department = department;
       this.empName = empName;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Department getDepartment() {
        return this.department;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }
    public String getEmpName() {
        return this.empName;
    }
    
    public void setEmpName(String empName) {
        this.empName = empName;
    }




}


