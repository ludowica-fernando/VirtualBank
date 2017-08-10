/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.virtualbank.beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import lk.virtualbank.dao.DbConnector;

/**
 *
 * @author Ludowica
 */
public class Message {

    private String sender;
    private String name;
    private String receiver;
    private String message;
    private String nic;
    Connection con;
    Statement stmt;

    public Message() {
        this.setCon(new DbConnector().connectDb());
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    //method to check whether the sender of the message exists (account number of customer)
    public boolean checkSender(String sender) {
        boolean flag = false;
        try {
            stmt = con.createStatement();
            //retrieves details from the approved customer list
            String checkSQL = "select * from APPROVEDCUSTOMERS where acno='" + sender + "' ";
            ResultSet rs = stmt.executeQuery(checkSQL);

            while (rs.next()) {
                flag = true;
            }

        } catch (SQLException err) {
            System.err.println(err.getMessage());
        }
        return flag;
    }

    //method to check whether the receiving customer account exists (if employee sends a message)
    public boolean checkReceiver(String acno) {
        boolean flag = false;
        try {
            stmt = con.createStatement();
            String checkSQL = "select * from APPROVEDCUSTOMERS where acno='" + acno + "' ";
            ResultSet rs = stmt.executeQuery(checkSQL);

            while (rs.next()) {
                flag = true;
            }

        } catch (SQLException err) {
            System.err.println(err.getMessage());
        }
        return flag;
    }  
    
    //method to send the message to the table for later retrieval
    public boolean sendMessage(String sender, String message, String receiver) {
        boolean flag = false;
        try {
            stmt = con.createStatement();
            String sendSQL = "INSERT INTO MESSAGES VALUES ('" + sender + "' , '" + message + "' , '" + receiver + "') ";
            if (stmt.executeUpdate(sendSQL) > 0) {
                flag = true;
            }
        } catch (SQLException err) {
            System.err.println(err.getMessage());
        }
        return flag;
    }
    
    public boolean bankSendMessage(String sender, String message, String acno) {
        boolean flag = false;
        try {
            stmt = con.createStatement();
            String sendSQL = "INSERT INTO MESSAGES VALUES ('" + sender + "' , '" + message + "' , '" + acno + "') ";
            if (stmt.executeUpdate(sendSQL) > 0) {
                flag = true;
            }
        } catch (SQLException err) {
            System.err.println(err.getMessage());
        }
        return flag;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

}//end Message bean class
