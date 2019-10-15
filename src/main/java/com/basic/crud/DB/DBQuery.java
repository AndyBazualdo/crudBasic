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
    public int insert (String name, String lastName, String nickName, int id, String position, String area, String startDate, double salary){
        String sql = "insert into employees values( ? ,  ? , ? , ? , ? , ? , ? , ? );" ;
        int query = 0;
        try (PreparedStatement prep = connection.prepareStatement(sql)) {
            prep.setString(1, String.valueOf(id));
            prep.setString(2, name);
            prep.setString(3, lastName);
            prep.setString(4, nickName);
            prep.setString(5, position);
            prep.setString(6, area);
            prep.setString(7, String.valueOf(startDate));
            prep.setString(8, String.valueOf(salary));
            query = prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }
    public int delete (int id){
        String sql = "DELETE FROM employees WHERE id = " + id + ";" ;
        int query = 0;
        try (PreparedStatement prep = connection.prepareStatement(sql)) {
            query = prep.executeUpdate();
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
    public int update (String name, String lastName, String nickName, int id, String position, String area, String startDate, double salary){
        String sql = "UPDATE employees SET id = ? , name = ? , lastName = ? , nickName = ? , position = ? , area = ? , startDate = ? , salary = ? WHERE id = " + id + ";" ;
        int rs = 0;
        try (PreparedStatement prep = connection.prepareStatement(sql)) {
            prep.setString(1, String.valueOf(id));
            prep.setString(2, name);
            prep.setString(3, lastName);
            prep.setString(4, nickName);
            prep.setString(5, position);
            prep.setString(6, area);
            prep.setString(7, String.valueOf(startDate));
            prep.setString(8, String.valueOf(salary));
            rs = prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
