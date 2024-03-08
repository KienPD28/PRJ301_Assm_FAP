/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Subject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class SubjectDB extends DBContext{
    public Subject getSubjectById(String subid) {
        try {
            String sql = "SELECT [subid]\n"
                    + "      ,[subname]\n"
                    + "      ,[Term]\n"
                    + "      ,[credit]\n"
                    + "      ,[department]\n"
                    + "      ,[Prerequisite]\n"
                    + "  FROM [MY_FAP_PROJECT].[dbo].[Subject]\n"
                    + "  WHERE [subid] = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, subid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Subject s = new Subject();
                s.setSubid(rs.getString("subid")); 
                s.setSubname(rs.getString("subname"));
                s.setTerm(rs.getInt("Term"));
                s.setCredits(rs.getInt("credit"));
                s.setDepartment(rs.getString("department"));
                s.setPrerequisite(rs.getString("Prerequisite"));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void main(String[] args) {
        SubjectDB db = new SubjectDB();
        Subject r = db.getSubjectById("CSD201");
        System.out.println(r.getSubname());
        
    }
}
