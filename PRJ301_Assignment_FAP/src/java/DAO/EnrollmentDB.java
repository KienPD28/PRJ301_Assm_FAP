/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Student;
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
public class EnrollmentDB extends DBContext{
    
    public List<Student> getEnrollBygid(String gid) {
        List<Student> list = new ArrayList<>();
        StudentDB db = new StudentDB();
        try {
            String sql = "SELECT [eid]\n"
                    + "      ,[gid]\n"
                    + "      ,[stuid]\n"
                    + "  FROM [MY_FAP_PROJECT].[dbo].[Enrollment]\n"
                    + "  where [gid] = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, gid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Student s = db.getStudentByID(rs.getString("stuid"));
                
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnrollmentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public static void main(String[] args) {
        EnrollmentDB db = new EnrollmentDB();
        List<Student> e = db.getEnrollBygid("G03");
        for (Student student : e) {
            System.out.println(student);
        }
    }
}
