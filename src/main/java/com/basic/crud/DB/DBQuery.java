package com.basic.crud.DB;

import java.sql.*;
import java.util.Date;

/**
 * @author lazaro on 10/13/2019.
 * @project basicCrud
 */
public class DBQuery {
    private Connection connection;

    public DBQuery() {
        this.connection = DBConnection.getInstance().getConnection();
    }
    public boolean insert (String name, String lastName, String nickName, int id, String position, String area, String startDate, double salary){
        String sql = "insert into employees values( ? ,  ? , ? , ? , ? , ? , ? , ? );" ;
        boolean query = false;
        try (PreparedStatement prep = connection.prepareStatement(sql)) {
            prep.setString(1, String.valueOf(id));
            prep.setString(2, name);
            prep.setString(3, lastName);
            prep.setString(4, nickName);
            prep.setString(5, position);
            prep.setString(6, area);
            prep.setString(7, String.valueOf(startDate));
            prep.setString(8, String.valueOf(salary));
            query = prep.execute();
            System.out.println("testtttttttt");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }
    public boolean delete (int id){
        String sql = "DELETE FROM employees WHERE id = " + id + ";" ;
        boolean query = false;
        try (PreparedStatement prep = connection.prepareStatement(sql)) {
            query = prep.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }
    public ResultSet selectAll () throws SQLException{
        String sql = "SELECT * FROM employees;" ;
        ResultSet rs = null;
        Statement stmt  = null;
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return rs;
        }
    }
    public ResultSet select (int id){
        String sql = "SELECT * FROM employees WHERE id =" + id + ";" ;
        ResultSet rs = null;
        Statement stmt  = null;
        try {
            stmt = connection.createStatement();
            rs    = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return rs;
        }

    }
    public boolean update (String name, String lastName, String nickName, int id, String position, String area, String startDate, double salary){
        String sql = "UPDATE employees SET id = ? , name = ? , lastName = ? , nickName = ? , position = ? , area = ? , startDate = ? , salary = ? WHERE id = " + id + ";" ;
        boolean query = false;
        try (PreparedStatement prep = connection.prepareStatement(sql)) {
            prep.setString(1, String.valueOf(id));
            prep.setString(2, name);
            prep.setString(3, lastName);
            prep.setString(4, nickName);
            prep.setString(5, position);
            prep.setString(6, area);
            prep.setString(7, String.valueOf(startDate));
            prep.setString(8, String.valueOf(salary));
            query = prep.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }
}
