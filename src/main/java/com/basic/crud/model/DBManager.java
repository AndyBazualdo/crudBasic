package com.basic.crud.model;

import com.basic.crud.DB.DBQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lazaro on 10/13/2019.
 * @project basicCrud
 */
public class DBManager {
    private DBQuery dbQuery;
    public DBManager(){
        dbQuery = new DBQuery();
    }

    public boolean addEmployee (Employee employee) {
        int result = dbQuery.insert(employee.getName(), employee.getLastName(), employee.getNickName(),
                employee.getId(), employee.getPosition(), employee.getArea(), employee.getStartDate(), employee.getSalary());
        boolean res;
        if (result > 0){
            res = true;
        }
        else {
            res = false;
        }
        return res;
    }

    public Employee getEmployee (int id) throws SQLException {
        Employee employee = new Employee();
        ResultSet rs = dbQuery.select(id);

        try {
            while (rs.next()) {
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setLastName(rs.getString("lastName"));
                employee.setNickName(rs.getString("nickName"));
                employee.setPosition(rs.getString("position"));
                employee.setArea(rs.getString("area"));
                employee.setStartDate(rs.getString("startDate"));
                employee.setSalary(rs.getDouble("salary"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return employee;
    }

    public List<Employee> getEmployees () throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        ResultSet rs = dbQuery.selectAll();

        try {
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setLastName(rs.getString("lastName"));
                employee.setNickName(rs.getString("nickName"));
                employee.setPosition(rs.getString("position"));
                employee.setArea(rs.getString("area"));
                employee.setStartDate(rs.getString("startDate"));
                employee.setSalary(rs.getDouble("salary"));
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return employeeList;
    }

    public boolean deleteEmployee (int id) throws SQLException {
        int result = dbQuery.delete(id);
        boolean res;
        if (result > 0){
            res = true;
        }
        else {
            res = false;
        }
        return res;
    }
    public boolean updateEmployee(Employee employee){
        int result = dbQuery.update(employee.getName(), employee.getLastName(), employee.getNickName(),
        employee.getId(), employee.getPosition(), employee.getArea(), employee.getStartDate(), employee.getSalary());

        boolean result2;
        if (result>0){
            result2 = true;
        }
        else {
            result2 = false;
        }
        return result2;
    }
}
