/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Attendance;
import Entity.Group;
import Entity.Session;
import Entity.Student;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class AttendanceDB extends DBContext {
    
    public static void main(String[] args) {
        AttendanceDB db = new AttendanceDB();
        List<Attendance> list = db.getAtteandanceBySeid(1);
        for (Attendance s : list) {
            System.out.println(s);
        }
    }

    public List<Attendance> getAtteandanceBySeid(int seid) {
        List<Attendance> list = new ArrayList<>();
        try {

            String sql = " SELECT\n"
                    + "    s.stuid,\n"
                    + "    s.[name],\n"
                    + "    a.aid,\n"
                    + "    a.[Description],\n"
                    + "    a.isPresent,\n"
                    + "    a.[DateTime],\n"
                    + "	   g.gid,\n"
                    + "    g.[gname]\n"
                    + "FROM\n"
                    + "    Student s\n"
                    + "INNER JOIN\n"
                    + "    Enrollment e ON s.stuid = e.stuid\n"
                    + "INNER JOIN\n"
                    + "    [Group] g ON g.gid = e.gid\n"
                    + "INNER JOIN\n"
                    + "    [Session] ses ON ses.gid = g.gid\n"
                    + "LEFT JOIN\n"
                    + "    Attendance a ON a.seid = ses.seid AND a.stuid = s.stuid\n"
                    + "WHERE\n"
                    + "    ses.seid = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, seid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Attendance attendance = new Attendance();
                Student student = new Student();

                student.setStuid(rs.getString("stuid"));
                student.setName(rs.getString("name"));
                attendance.setStuid(student);

                Group group = new Group();
                group.setGid(rs.getString("gid"));
                group.setGname(rs.getString("gname"));
                attendance.setGid(group);

                Session session = new Session();
                session.setSeid(seid);
                session.setGid(group);

                attendance.setSeid(session);
                attendance.setAid(rs.getInt("aid"));

                if (attendance.getAid() != 0) {
                    attendance.setDescription(rs.getString("Description"));
                    attendance.setIsPresent(rs.getBoolean("isPresent"));
                    attendance.setDateTime(rs.getDate("DateTime"));
                }

                list.add(attendance);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void takeAttendancesforStudent(int seid, List<Attendance> list) {
        try {
            connection.setAutoCommit(false);

            String sql_delete = "DELETE FROM [dbo].[Attendance] WHERE seid = ?";
            PreparedStatement ps_delete = connection.prepareStatement(sql_delete);
            ps_delete.setInt(1, seid);
            ps_delete.executeUpdate();

            String sql_insert = "INSERT INTO [dbo].[Attendance] ([seid], [stuid], [isPresent], [Description], [DateTime]) \n"
                    + "VALUES (?, ?, ?, ?, GETDATE())";
            PreparedStatement ps_insert = connection.prepareStatement(sql_insert);
            for (Attendance a : list) {
                ps_insert.setInt(1, seid);
                ps_insert.setString(2, a.getStuid().getStuid());
                ps_insert.setBoolean(3, a.isIsPresent());
                ps_insert.setString(4, a.getDescription());
                ps_insert.addBatch();
            }
            ps_insert.executeBatch();

            String sql_update = "UPDATE [dbo].[Session] SET [isTaken] = 1 WHERE seid = ?";
            PreparedStatement ps_update = connection.prepareStatement(sql_update);
            ps_update.setInt(1, seid);
            ps_update.executeUpdate();

            connection.commit();
        } catch (SQLException ex) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e) {
                Logger.getLogger(SessionDB.class.getName()).log(Level.SEVERE, "Failed to rollback transaction", e);
            }
            Logger.getLogger(SessionDB.class.getName()).log(Level.SEVERE, "Error occurred during attendance taking", ex);
        } finally {
            try {
                if (connection != null) {
                    connection.setAutoCommit(true);
                }
            } catch (SQLException e) {
                Logger.getLogger(SessionDB.class.getName()).log(Level.SEVERE, "Failed to set auto-commit to true", e);
            }
        }
    }
}
