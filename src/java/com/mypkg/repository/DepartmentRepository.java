/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mypkg.repository;

import com.mypkg.domain.Department;
import java.util.List;


public interface DepartmentRepository {
     List <Department> getAllDepartments();
}
