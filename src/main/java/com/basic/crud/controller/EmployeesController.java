package com.basic.crud.controller;

import com.basic.crud.model.DBManager;
import com.basic.crud.model.Employee;
import com.basic.crud.model.ListEmployees;
import com.basic.crud.utils.Response;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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
    public Response listEmployees() {
        Response response = new Response();
        response.setUrl("none");
        try {
            List<Employee> employeeList = new ArrayList<>();
            Gson gson = new Gson();
            ListEmployees listEmployees = new ListEmployees();
            employeeList = listEmployees.returnEmployees();
            String jsonInString = gson.toJson(employeeList);
            response.setMessage(jsonInString);
            response.setStatus(Response.Status.Ok);
        } catch (SQLException e) {
            response.setMessage(e.getMessage());
            response.setStatus(Response.Status.BadRequest);
        }
        return response;
    }
    @GetMapping
    @RequestMapping("/employees/employee")
    public Response listEmployee(@RequestParam("id") int id) throws SQLException {
        Response response = new Response();
        response.setUrl("none");
        try {
            Employee employee = new Employee();
            Gson gson = new Gson();
            ListEmployees listEmployees = new ListEmployees();
            employee = listEmployees.returnEmployee(id);
            String jsonInString = gson.toJson(employee);
            response.setMessage(jsonInString);
            response.setStatus(Response.Status.Ok);
        } catch (SQLException e){
            response.setMessage(e.getMessage());
            response.setStatus(Response.Status.BadRequest);
        }
        return response;
    }
    @PostMapping
    @RequestMapping("/employees/add")
    public Response setEmployee(@RequestParam("name") String name,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("nickName") String nickName,
                                @RequestParam("id") int id,
                                @RequestParam("position") String position,
                                @RequestParam("area") String area,
                                @RequestParam("startDate")String startDate,
                                @RequestParam("salary") double salary) throws SQLException {
        Response response = new Response();
        response.setUrl("none");
        try {
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
                response.setMessage("Employee was added");
                response.setStatus(Response.Status.Ok);
            }
            else {
                response.setMessage("Employee was not added, query error");
                response.setStatus(Response.Status.Query_not_executed);
            }
        } catch (SQLException e) {
            response.setMessage(e.getMessage());
            response.setStatus(Response.Status.BadRequest);
        }
        return response;
    }
    @PutMapping
    @RequestMapping("/employees/update")
    public Response updateEmployee(@RequestParam("name") String name,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("nickName") String nickName,
                                 @RequestParam("id") int id,
                                 @RequestParam("position") String position,
                                 @RequestParam("area") String area,
                                 @RequestParam("startDate")String startDate,
                                 @RequestParam("salary") double salary) throws SQLException {
        Response response = new Response();
        response.setUrl("none");
        boolean finalResult;
        try {
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
            finalResult = listEmployees.updateEmployee(employee);
            if (finalResult) {
                response.setMessage("Employee information was updated");
                response.setStatus(Response.Status.Ok);
            }
            else {
                response.setMessage("Employee Information was not updated, query error");
                response.setStatus(Response.Status.Query_not_executed);
            }
        } catch (SQLException e) {
            response.setMessage(e.getMessage());
            response.setStatus(Response.Status.BadRequest);
        }
        return response;
    }
    @DeleteMapping
    @RequestMapping("/employees/delete")
    public Response deleteEmployee(@RequestParam("id") int id) throws SQLException {
        Response response = new Response();
        response.setUrl("none");
        try {
            ListEmployees listEmployees = new ListEmployees();
            boolean result = listEmployees.deleteEmployee(id);
            if (result) {
                response.setMessage("Employee information was deleted");
                response.setStatus(Response.Status.Ok);
            }
            else {
                response.setMessage("Employee Information was not deleted, query error");
                response.setStatus(Response.Status.Query_not_executed);
            }
        } catch (SQLException e) {
            response.setMessage(e.getMessage());
            response.setStatus(Response.Status.BadRequest);
        }
        return response;
    }
}
