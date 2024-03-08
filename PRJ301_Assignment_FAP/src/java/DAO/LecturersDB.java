/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Lecturers;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class LecturersDB extends DBContext {

    public List<Lecturers> getAll() {
        List<Lecturers> list = new ArrayList<>();
        try {
            String sql = "SELECT [lid]\n"
                    + "      ,[lname]\n"
                    + "      ,[Gender]\n"
                    + "      ,[dob]\n"
                    + "      ,[PhoneNum]\n"
                    + "      ,[IDCard]\n"
                    + "      ,[Address]\n"
                    + "      ,[Email]\n"
                    + "      ,[Major]\n"
                    + "      ,[NickName]\n"
                    + "  FROM [MY_FAP_PROJECT].[dbo].[Lecturer]";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Lecturers l = new Lecturers();
                l.setLid(rs.getString("lid"));
                l.setLname(rs.getString("lname"));
                l.setDob(rs.getDate("dob"));
                l.setPhoneNumber(rs.getString("PhoneNum"));
                l.setIDcard(rs.getString("IDCard"));
                l.setAddress(rs.getString("Address"));
                l.setEmail(rs.getString("Email"));
                l.setMajor(rs.getString("Major"));
                l.setnickName(rs.getString("NickName"));
                list.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LecturersDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public Lecturers getLecturersById(String lid) {
        try {
            String sql = "SELECT [lid]\n"
                    + "      ,[lname]\n"
                    + "      ,[Gender]\n"
                    + "      ,[dob]\n"
                    + "      ,[PhoneNum]\n"
                    + "      ,[IDCard]\n"
                    + "      ,[Address]\n"
                    + "      ,[Email]\n"
                    + "      ,[Major]\n"
                    + "      ,[NickName]\n"
                    + "  FROM [MY_FAP_PROJECT].[dbo].[Lecturer]\n"
                    + "  WHERE [lid] = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, lid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Lecturers l = new Lecturers();
                l.setLid(rs.getString("lid"));
                l.setLname(rs.getString("lname"));
                l.setDob(rs.getDate("dob"));
                l.setPhoneNumber(rs.getString("PhoneNum"));
                l.setIDcard(rs.getString("IDCard"));
                l.setAddress(rs.getString("Address"));
                l.setEmail(rs.getString("Email"));
                l.setMajor(rs.getString("Major"));
                l.setnickName(rs.getString("NickName"));
                return l;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LecturersDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void main(String[] args) {
        LecturersDB db = new LecturersDB();
        Lecturers l = db.getLecturersById("L01");
        System.out.println(l);
    }
}
