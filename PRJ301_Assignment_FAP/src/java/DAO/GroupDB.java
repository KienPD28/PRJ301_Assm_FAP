/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Group;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class GroupDB extends DBContext{
    public Group getGroupByID(String gid) {
        try {
            LecturersDB lec = new LecturersDB();
            SubjectDB sub = new SubjectDB();
            String sql = "SELECT [gid]\n"
                    + "      ,[gname]\n"
                    + "      ,[subid]\n"
                    + "      ,[PIC]\n"
                    + "  FROM [MY_FAP_PROJECT].[dbo].[Group]\n"
                    + "  WHERE [gid] = ?\n"
                    + "";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, gid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Group g = new Group();
                g.setGid(rs.getString("gid"));
                g.setGname(rs.getString("gname"));
                String subid = rs.getString("subid");
                g.setSubid(sub.getSubjectById(subid));
                String lid = rs.getString("PIC");
                g.setLid(lec.getLecturersById(lid));
                return g;

            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    public static void main(String[] args) {
        GroupDB db = new GroupDB();
        Group g = db.getGroupByID("G01");
        System.out.println(g.getGname());
    }
}
