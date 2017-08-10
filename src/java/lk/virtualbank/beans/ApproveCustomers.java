/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.virtualbank.beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import lk.virtualbank.dao.DbConnector;

/**
 *
 * @author Ludowica
 */
public class ApproveCustomers implements Serializable {

    private String fname;
    private String lname;
    private String address;
    private String gender;
    private String telephone;
    private String email;
    private String nic;
    private String acno;
    private String username;
    private String password;
    Connection con;
    Statement stmt;

    public ApproveCustomers() {
        this.setCon(new DbConnector().connectDb());
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public boolean selectOnlinePortal(String acno) {
        boolean flag = false;
        try {
            stmt = con.createStatement();
            String sqlc = "SELECT * FROM USERDETAILS WHERE acno = '" + acno + "' ";
            ResultSet rs = stmt.executeQuery(sqlc);
            while (rs.next()) {
                fname = rs.getString("fname");
                lname = rs.getString("lname");
                address = rs.getString("address");
                gender = rs.getString("gender");
                telephone = rs.getString("telephone");
                email = rs.getString("email");
                nic = rs.getString("nic");
                username = rs.getString("username");
                password = rs.getString("password");
                flag = true;
            }

            String sqlA = "INSERT INTO APPROVEDCUSTOMERS VALUES ('" + fname + "' , '" + lname + "' , '" + address + "'  , '" + gender + "' , '" + telephone + "' , '" + email + "' , '" + nic + "', '" + acno + "') ";
            stmt.executeUpdate(sqlA);
//            if (stmt.executeUpdate(sqlA) > 0) {
//                flag = true;
//            }

            String sqlB = "INSERT INTO LOGINDETAIL VALUES ('" + username + "' , '" + password + "','" + nic + "' ) ";
            stmt.executeUpdate(sqlB);

//            if (stmt.executeUpdate(sqlB) > 0) {
//                flag = true;
//            }
            String updateSQL = "DELETE FROM USERDETAILS WHERE acno = '" + acno + "'";
            stmt.executeUpdate(updateSQL);

//            if (stmt.executeUpdate(updateSQL) > 0) {
            flag = true;
//            }

        } catch (SQLException err) {
            System.err.println(err.getMessage());
        }

        return flag;
    }

    public String fnameGet(String username) {
        String name = null;

        try {
            stmt = con.createStatement();
            String sql = "select * from approvedcustomers where nic = '" + username + "'  ";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                name = rs.getString("fname");
            }

        } catch (SQLException err) {
            System.err.println(err.getMessage());
        }

        return name;

    }


    public String getAcno() {
        return acno;
    }

    public void setAcno(String acno) {
        this.acno = acno;
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
}
