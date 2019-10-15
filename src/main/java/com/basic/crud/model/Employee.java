package com.basic.crud.model;

import java.util.Date;

/**
 * @author lazaro on 10/13/2019.
 * @project basicCrud
 */
public class Employee extends Person {
    private String position;
    private String area;
    private String startDate;
    private double salary;

    public String getPosition() {
        return position;
    }

    public String getArea() {
        return area;
    }

    public String getStartDate() {
        return startDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
