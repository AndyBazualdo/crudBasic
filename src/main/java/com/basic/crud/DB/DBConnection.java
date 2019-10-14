package com.basic.crud.DB;

import java.sql.*;

/**
 * @author lazaro on 10/13/2019.
 * @project basicCrud
 */
public class DBConnection {
    private static Connection con;
    private static DBConnection dbConnection;
    private static boolean hasData = false;

    public DBConnection() throws SQLException, ClassNotFoundException {
        this.init();
    }
    private void init() throws ClassNotFoundException, SQLException {
        // sqlite driver
        Class.forName("org.sqlite.JDBC");
        // database path, if it's new database, it will be created in the project folder
        con = DriverManager.getConnection("jdbc:sqlite:Employees.db");
        //init2();
    }
    private void init2() throws SQLException {
        if( !hasData ) {
            hasData = true;
            // check for database table
            Statement state = con.createStatement();
            ResultSet res = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='employee'");
            if( !res.next()) {
                System.out.println("Building the User table with pre populated values.");
                // need to build the table
                Statement state2 = con.createStatement();
                state2.executeUpdate("create table employees(id integer, name varchar(100), " +
                        "lastName varchar(100), nickName varchar(100), position varchar(50), area varchar(50), " +
                        "startDate varchar(100), salary real, primary key (id));");
                // inserting some preloaded data
                PreparedStatement prep = con.prepareStatement("insert into employees values( ? ,  ? , ? , ? , ? , ? , ? , ? );");
                prep.setString(1, "123456");
                prep.setString(2, "John");
                prep.setString(3, "Smith");
                prep.setString(4, "Jhonny");
                prep.setString(5, "Admin");
                prep.setString(6, "Administration");
                prep.setString(7, "2019-01-01");
                prep.setString(8, "1000.01");
                prep.execute();
            }
        }
    }

    public Connection getConnection(){
        return con;
    }
    public static DBConnection getInstance() {
        try {
            if (dbConnection == null) {
                dbConnection = new DBConnection();
            } else if (dbConnection.getConnection().isClosed()) {
                dbConnection = new DBConnection();
            }
        } catch (Exception e) { e.printStackTrace(); }
        return dbConnection;
    }
}
