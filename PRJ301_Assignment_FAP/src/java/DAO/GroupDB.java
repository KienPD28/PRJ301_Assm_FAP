/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Group;
import Entity.Lecturers;
import Entity.Room;
import Entity.Session;
import Entity.Slot;
import Entity.Subject;
import Entity.TimeSlot;
import java.sql.Date;
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
public class GroupDB extends DBContext {

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
        List<Session> list = db.getSessionByGroupId("G01");
        for (Session s : list) {
            System.out.println(s);
        }
    }

    public List<Session> getSessionByGroupId(String gid) {
        List<Session> list = new ArrayList();
        GroupDB groupDB = new GroupDB();
        LecturersDB lecturersDB = new LecturersDB();
        TimeSlotDB timeSlotDB = new TimeSlotDB();
        RoomDB roomDB = new RoomDB();
        SlotDB slotDB = new SlotDB();
        SubjectDB subjectDB = new SubjectDB();
        try {
            String sql = "SELECT [seid]\n"
                    + "      ,[gid]\n"
                    + "      ,[Slid]\n"
                    + "      ,[Tid]\n"
                    + "      ,[rid]\n"
                    + "      ,[Date]\n"
                    + "      ,[subid]\n"
                    + "      ,[lid]\n"
                    + "      ,[isTaken]\n"
                    + "  FROM [MY_FAP_PROJECT].[dbo].[Session]\n"
                    + "  WHERE [gid] = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, gid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int seid = rs.getInt("seid");
                String groupId = rs.getString("gid"); 
                int slid = rs.getInt("Slid");
                int tid = rs.getInt("Tid");
                String rid = rs.getString("rid");
                Date date = rs.getDate("Date"); 
                String subid = rs.getString("subid");
                String lid = rs.getString("lid");
                boolean isTaken = rs.getBoolean("isTaken");

                Group group = groupDB.getGroupByID(groupId);
                Lecturers lecturer = lecturersDB.getLecturersById(lid);
                Room room = roomDB.getRoomById(rid);
                TimeSlot timeSlot = timeSlotDB.getTimeSlotbyid(tid);
                Slot slot = slotDB.getSlotBySlotId(slid);
                Subject subject = subjectDB.getSubjectById(subid);

                Session session = new Session(seid, group, slot, timeSlot, room, subject, date, lecturer, isTaken);
                list.add(session);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
