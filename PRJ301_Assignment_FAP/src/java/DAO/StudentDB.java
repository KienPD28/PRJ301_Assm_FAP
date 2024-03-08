/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class StudentDB extends DBContext{
    
    public Student getStudentByID(String id) {
  
        try {
            String sql = "SELECT [stuid]\n"
                    + "      ,[name]\n"
                    + "      ,[dob]\n"
                    + "      ,[Gender]\n"
                    + "      ,[Semester]\n"
                    + "      ,[Email]\n"
                    + "      ,[Major]\n"
                    + "  FROM [MY_FAP_PROJECT].[dbo].[Student]\n"
                    + "  WHERE [stuid] = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Student s = new Student();
                s.setStuid(rs.getString("stuid"));
                s.setName(rs.getString("name"));
                s.setDob(rs.getDate("dob"));
                s.setGender(rs.getBoolean("gender"));
                s.setSemester(rs.getInt("Semester"));
                s.setEmail(rs.getString("Email"));
                s.setMajor(rs.getString("Major"));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public static void main(String[] args) {
        StudentDB db = new StudentDB();
        Student s = db.getStudentByID("HE170155");
        System.out.println(s);
    }
}
