/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Assignment;
import Entity.Exam;
import Entity.Grade;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class MarkDB extends DBContext {
    
    public static void main(String[] args) {
        MarkDB db = new MarkDB();
        List<Grade> list = db.getMarkByStuidandSubid("HE176719", "JPD123");
        for (Grade g : list) {
            System.out.println(g);
        }
    }

    public List<Grade> getMarkByStuidandSubid(String stuid, String subid) {
        List<Grade> list = new ArrayList<>();
        StudentDB studb = new StudentDB();
        SubjectDB subdb = new SubjectDB();
        try {
            String sql = "SELECT a.Assid, a.Assname, a.[weight], a.subid, e.[DateStart], e.[EndDate], g.stuid, g.[Score]\n"
                    + "FROM [MY_FAP_PROJECT].[dbo].[Assignment] a\n"
                    + "INNER JOIN [MY_FAP_PROJECT].[dbo].[Exam] e ON a.Assid = e.Assid\n"
                    + "INNER JOIN [MY_FAP_PROJECT].[dbo].[Grade] g ON g.eid = e.eid\n"
                    + "WHERE g.stuid = ? AND a.subid = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, stuid);
            ps.setString(2, subid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Assignment assign = new Assignment();
                Exam exam = new Exam();
                Grade grade = new Grade();
                
                String studentid = rs.getString("stuid");
                String subjectid = rs.getString("subid");
                
                //Assignment
                assign.setSubid(subdb.getSubjectById(subjectid));
                assign.setAssname(rs.getString("Assname"));
                assign.setAssid(rs.getString("Assid"));
                assign.setWeight(rs.getFloat("weight"));
                
                //Exam
                exam.setDateStart(rs.getDate("DateStart"));
                exam.setEndDate(rs.getDate("EndDate"));
                exam.setAssid(assign);
                
                //Grade
                grade.setEid(exam);
                grade.setScore(rs.getFloat("Score"));
                grade.setStuid(studb.getStudentByID(studentid));
                
                //addList
                list.add(grade);
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarkDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
