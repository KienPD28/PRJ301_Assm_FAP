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
        Attendance a = db.getStudentByAttendance(1, "HE176719");
        System.out.println(a);
    }

    public Attendance getStudentByAttendance(int seid, String stuid) {
        Attendance a = new Attendance();
        StudentDB db = new StudentDB();
        SessionDB sesDB = new SessionDB();
        try {
            String sql = "SELECT [aid]\n"
                    + "      ,[seid]\n"
                    + "      ,[stuid]\n"
                    + "      ,[isPresent]\n"
                    + "      ,[Description]\n"
                    + "      ,[DateTime]\n"
                    + "  FROM [MY_FAP_PROJECT].[dbo].[Attendance]\n"
                    + "  where seid = ? and stuid = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, seid);
            ps.setString(2, stuid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = db.getStudentByID(rs.getString("stuid"));
                a.setStuid(student);

                Session ses = sesDB.getSessionBySid(seid);
                a.setSeid(ses);

                a.setAid(rs.getInt("aid"));
                if (a.getAid() != 0) {
                    a.setIsPresent(rs.getBoolean("isPresent"));
                    a.setDescription(rs.getString("Description"));
                    a.setDateTime(rs.getTimestamp("DateTime"));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
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
                    attendance.setDateTime(rs.getTimestamp("DateTime"));
                }

                list.add(attendance);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Attendance takeAttendanceBySeidandStuid(int seid, String stuid) {
        Attendance a = new Attendance();
        try {
            String sql = "SELECT [isPresent]\n"
                    + "FROM [MY_FAP_PROJECT].[dbo].[Attendance]\n"
                    + "WHERE [seid] = ? and [stuid] = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, seid);
            ps.setString(2, stuid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                a.setIsPresent(rs.getBoolean("isPresent"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    public void takeAttendancesforStudent(int seid, List<Attendance> list) {
        try {
            connection.setAutoCommit(false);
            String sql_delete = "DELETE FROM [dbo].[Attendance] WHERE seid = ?";
            PreparedStatement ps_delete = connection.prepareStatement(sql_delete);
            ps_delete.setInt(1, seid);
            ps_delete.executeUpdate();

            for (Attendance a : list) {
                String sql_insert = "INSERT INTO [dbo].[Attendance]\n"
                        + "           ([seid]\n"
                        + "           ,[stuid]\n"
                        + "           ,[isPresent]\n"
                        + "           ,[Description]\n"
                        + "           ,[DateTime])\n"
                        + "     VALUES\n"
                        + "           (?,?,?,?,GETDATE())";
                PreparedStatement ps_insert = connection.prepareStatement(sql_insert);
                ps_insert.setInt(1, seid);
                ps_insert.setString(2, a.getStuid().getStuid());
                ps_insert.setBoolean(3, a.isIsPresent());
                ps_insert.setString(4, a.getDescription());
                ps_insert.executeUpdate();
            }

            String sql_update = "UPDATE [dbo].[Session]\n"
                    + "   SET [isTaken] = '1'\n"
                    + " WHERE [seid] = ?";
            PreparedStatement ps_insert = connection.prepareStatement(sql_update);
            ps_insert.setInt(1, seid);
            ps_insert.executeUpdate();

            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(SessionDB.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(SessionDB.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(SessionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
