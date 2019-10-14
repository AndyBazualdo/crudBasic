package com.basic.crud.controller;

import com.basic.crud.model.DBManager;
import com.basic.crud.model.Employee;
import com.basic.crud.model.ListEmployees;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lazaro on 10/12/2019.
 * @project basicCrud
 */
@RestController
public class EmployeesController {
    @GetMapping
    @RequestMapping("/employees")
    public String listEmployees() throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        Gson gson = new Gson();
        ListEmployees listEmployees = new ListEmployees();
        employeeList = listEmployees.returnEmployees();
        String jsonInString = gson.toJson(employeeList);
        return jsonInString;
    }
    @GetMapping
    @RequestMapping("/employees/employee")
    public String listEmployee(@RequestParam("id") int id) throws SQLException {
        Employee employee = new Employee();
        Gson gson = new Gson();
        ListEmployees listEmployees = new ListEmployees();
        employee = listEmployees.returnEmployee(id);
        String jsonInString = gson.toJson(employee);
        return jsonInString;
    }
    @PostMapping
    @RequestMapping("/employees/add")
    public String setEmployee(@RequestParam("name") String name,
                              @RequestParam("lastName") String lastName,
                              @RequestParam("nickName") String nickName,
                              @RequestParam("id") int id,
                              @RequestParam("position") String position,
                              @RequestParam("area") String area,
                              @RequestParam("startDate")String startDate,
                              @RequestParam("salary") double salary) throws SQLException {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setLastName(lastName);
        employee.setNickName(nickName);
        employee.setPosition(position);
        employee.setArea(area);
        employee.setStartDate(startDate);
        employee.setSalary(salary);
        ListEmployees listEmployees = new ListEmployees();
        boolean result = listEmployees.addEmployee(employee);
        if (result) {
            return "added";
        } else {
            return "error";
        }

    }
    @PutMapping
    @RequestMapping("/employees/update")
    public String updateEmployee(@RequestParam("name") String name,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("nickName") String nickName,
                                 @RequestParam("id") int id,
                                 @RequestParam("position") String position,
                                 @RequestParam("area") String area,
                                 @RequestParam("startDate")String startDate,
                                 @RequestParam("salary") double salary) throws SQLException {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setLastName(lastName);
        employee.setNickName(nickName);
        employee.setPosition(position);
        employee.setArea(area);
        employee.setStartDate(startDate);
        employee.setSalary(salary);
        ListEmployees listEmployees = new ListEmployees();
        listEmployees.updateEmployee(employee);
        return "Hello3";
    }
    @DeleteMapping
    @RequestMapping("/employees/delete")
    public String deleteEmployee(@RequestParam("id") int id) throws SQLException {
        ListEmployees listEmployees = new ListEmployees();
        boolean result = listEmployees.deleteEmployee(id);
        if (result){
            return "deleted ";
        } else {
            return "error";
        }
    }
}
