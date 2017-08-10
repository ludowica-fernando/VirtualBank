/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.virtualbank.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ludowica
 */
public class DbConnector {

    String dbUrl = "jdbc:derby://localhost:1527/dbstartrust";
    String dbUsername = "ludowica";
    String dbPassword = "ludowica";
    Connection con;
    Statement stmt;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    

    public void disconnectDb() {
        try {
            con.close();
        } catch (SQLException ex) {

        }
    }

    public Connection connectDb() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            try {
                con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            } catch (SQLException ex) {
            }
        } catch (ClassNotFoundException ex) {
        }
        return con;

    }

}
