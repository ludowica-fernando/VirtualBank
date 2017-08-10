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
public class ApprovedFixedAcc {

    private String fname;
    private String lname;
    private String gender;
    private String telephone;
    private String nic;
    private double amount;
    private String term;
    private String acno;
    private double newAmount;
    Connection con;
    Statement stmt;

    public ApprovedFixedAcc() {
        this.setCon(new DbConnector().connectDb());
    }

    public boolean approveFixed(String acno) {
        boolean flag = false;
        try {
            stmt = con.createStatement();
            String sqlc = "SELECT * FROM PENDINGFIXEDACC WHERE acno = '" + acno + "' ";
            ResultSet rs = stmt.executeQuery(sqlc);
            while (rs.next()) {
                fname = rs.getString("fname");
                lname = rs.getString("lname");
                gender = rs.getString("gender");
                telephone = rs.getString("tel");
                nic = rs.getString("nic");
                amount = rs.getDouble("amount");
                term = rs.getString("term");
                acno = rs.getString("acno");
                newAmount = rs.getDouble("newamount");
                flag = true;
            }

            String sqlA = "INSERT INTO APPROVEDFIXEDACC  VALUES ('" + fname + "' , '" + lname + "' , '" + gender + "' , '" + telephone + "' , '" + nic + "', " + amount + ",'" + term + "', '" + acno + "', " + newAmount + ") ";

            if (stmt.executeUpdate(sqlA) > 0) {
                flag = true;
            }

            String updateSQL = "DELETE FROM PENDINGFIXEDACC WHERE acno = '" + acno + "'";

            if (stmt.executeUpdate(updateSQL) > 0) {
                flag = true;
            }

        } catch (SQLException err) {
            System.err.println(err.getMessage());
        }

        return flag;
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

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getAcno() {
        return acno;
    }

    public void setAcno(String acno) {
        this.acno = acno;
    }

    public double getNewAmount() {
        return newAmount;
    }

    public void setNewAmount(double newAmount) {
        this.newAmount = newAmount;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

}
