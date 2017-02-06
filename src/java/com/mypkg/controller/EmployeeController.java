/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mypkg.controller;

import com.mypkg.domain.Employee;
import com.mypkg.repository.DepartmentRepository;
import com.mypkg.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class EmployeeController {
     @Autowired
    private EmployeeRepository empRepository;
    @Autowired
    private DepartmentRepository deptRepository;
    
    @RequestMapping(value = "/employees")
    public String listEmployees(Model model)
    {
        //empRepository=null;
         model.addAttribute("Employee",empRepository.getAllEmployees());
    model.addAttribute("Department",deptRepository.getAllDepartments());
     
        return "index";
    }
       @RequestMapping("/employees/delete")
    public ModelAndView delete(int id)
    {
        empRepository.deleteEmployee(id);
        return new ModelAndView("redirect:/employees");
    }
    
    @RequestMapping("/employees/add")
    public ModelAndView addEmployee(int id, String emp_name,int dept_id)
    {
        //Employee emp=new Employee();
        //emp.setId(id);
        //emp.setEmpName(emp_name);
        //emp.setDeptId(dept_id);
        empRepository.addEmployee(id, emp_name,dept_id);
        return new ModelAndView("redirect:/employees");
    }
}
