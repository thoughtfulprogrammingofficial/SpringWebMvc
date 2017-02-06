<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2 style="text-align: center">Employees</h2>
        <table border="1" style="margin-left:auto; margin-right:auto;">
            <tr>
                <td>id</td>
                <td>Employee Name</td>
                <td>Department Name</td>
                <td>Action</td>
            </tr>
        <c:forEach items="${Employee}" var="employee">
            <tr>
                <td>
            ${employee.id}
            </td>
            
            <td>
${employee.empName}
</td>
<td>
    ${employee.deptName}
</td>
<td>
    <a href="./employees/delete?id=${employee.id}">Delete</a>    
</td>
</tr>
</c:forEach>
</table>
        <br/>
        <br/>
        
        <h2 style="text-align: center">Add Record</h2>
        
        
        
        <table style="margin-left:auto; margin-right:auto;">
        <form method="get" action="./employees/add" >
            <tr><td>ID</td><td><input type="text" name="id"/></td></tr>
            <tr><td>Name</td><td><input type="text" name="emp_name"/></td></tr>
            <tr><td>Department</td><td>
                    <select name="dept_id">
                        <c:forEach items="${Department}" var="department">
                            <option value="${department.deptId}">${department.deptName}</option>
                        </c:forEach>
                    </select>                    
                    
                    </td></tr>
            <tr><td colspan="2" style="text-align: center"><input type="submit" value="Add Record"/></td></tr>
        </form>
            </table>
    </body>
</html>
