/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.virtualbank.beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import lk.virtualbank.dao.DbConnector;
import java.sql.Statement;
import java.util.Random;

/**
 *
 * @author Ludowica
 */
public class UserDetails {

    Connection con;
    Statement stmt;
    private String fname;
    private String lname;
    private String address;
    private String gender;
    private String telephone;
    private String email;
    private String nic;
    private String acno;
    private String password;

    public UserDetails() {
        this.setCon(new DbConnector().connectDb());
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    
    //method to check whether the registering customer already has an existing bank account
    public boolean checkUser(String acno) {
        boolean flag = false;

        try {
            stmt = con.createStatement();
            String checkSQL = "select * from manualacc where acno='" + acno + "' "; //checking from the existing account table
            ResultSet rs = stmt.executeQuery(checkSQL);

            while (rs.next()) {
                flag = true; //returns true if the record is found
            }

        } catch (SQLException err) {
            System.err.println(err.getMessage());
        }

        return flag;
    }

    //if the customer has an account, this method registers them for the online portal
    public boolean registerUser(String fname, String lname, String address, String gender, String telephone, String email, String nic, String acno, String username,String password) {
        boolean flag = false;

        try {
            stmt = con.createStatement();
            
            //inserts the details into the table for approval
            String sqlc = "INSERT INTO USERDETAILS VALUES ('" + fname + "' , '" + lname + "' , '" + address + "'  , '" + gender + "' , '" + telephone + "' , '" + email + "' , '" + nic + "', '" + acno + "', '" + username + "', '" + password + "') "; 

            if (stmt.executeUpdate(sqlc) > 0) {
                    flag = true; //returns true if it is inserted successfully
            }

        } catch (SQLException err) {
            System.err.println(err.getMessage());
        }

        return flag;
    }

    //method to generate a random password for the login credentials
    public String generatePassword(String nic) {
        int pass;
        Random rnd = new Random();
        pass = rnd.nextInt(99999) + 1;
        
        String password = Integer.toString(pass);
        return password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAcno() {
        return acno;
    }

    public void setAcno(String acno) {
        this.acno = acno;
    }

}