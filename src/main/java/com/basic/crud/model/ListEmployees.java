package com.basic.crud.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lazaro on 10/13/2019.
 * @project basicCrud
 */
public class ListEmployees {
    private List<Employee> employees;

    public Employee returnEmployee(int id) throws SQLException {
        Employee employee = new Employee();
        DBManager dbManager = new DBManager();
        employee = dbManager.getEmployee(id);
        return employee;
    }

    public List<Employee> returnEmployees() throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        Employee employee = new Employee();
        DBManager dbManager = new DBManager();
        employeeList = dbManager.getEmployees();
        return employeeList;
    }

    public boolean addEmployee(Employee employee) throws SQLException {
        DBManager dbManager = new DBManager();
        boolean result = dbManager.addEmployee(employee);
        return result;
    }

    public boolean deleteEmployee(int id) throws SQLException {
        DBManager dbManager = new DBManager();
        boolean result = dbManager.deleteEmployee(id);
        return result;
    }

    public boolean updateEmployee(Employee employee) throws SQLException {
        DBManager dbManager = new DBManager();
        boolean re = dbManager.updateEmployee(employee);
        return re;
    }
}
