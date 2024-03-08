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

/**
 *
 * @author DELL
 */
public class SessionDB extends DBContext{
    public List<Session> getAllSession() {
        List<Session> list = new ArrayList();
        GroupDB group = new GroupDB();
        LecturersDB lec = new LecturersDB();
        TimeSlotDB tslot = new TimeSlotDB();
        RoomDB room = new RoomDB();
        SlotDB slot = new SlotDB();
        SubjectDB subject = new SubjectDB();
        String sql = "SELECT [seid]\n"
                + "      ,[gid]\n"
                + "      ,[Slid]\n"
                + "      ,[Tid]\n"
                + "      ,[rid]\n"
                + "      ,[Date]\n"
                + "      ,[subid]\n"
                + "      ,[lid]\n"
                + "      ,[isTaken]\n"
                + "  FROM [MY_FAP_PROJECT].[dbo].[Session]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int seid = rs.getInt("seid");
                String gid = rs.getString("gid");
                int Slid = rs.getInt("Slid");
                int Tid = rs.getInt("Tid");
                String rid = rs.getString("rid");
                Date date = rs.getDate("date");
                String subid = rs.getString("subid");
                String lid = rs.getString("lid");
                boolean isTaken = rs.getBoolean("isTaken");

                Group gr = group.getGroupByID(gid);
                Lecturers l = lec.getLecturersById(lid);
                Room r = room.getRoomById(rid);
                TimeSlot time = tslot.getTimeSlotbyid(Tid);
                Slot s = slot.getSlotBySlotId(Slid);
                Subject sub = subject.getSubjectById(subid);

                Session se = new Session(seid, gr, s, time, r, sub, date, l, isTaken);
                list.add(se);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Session getSessionBySid(int id) {
        List<Session> list = new ArrayList();
        GroupDB group = new GroupDB();
        LecturersDB lec = new LecturersDB();
        TimeSlotDB tslot = new TimeSlotDB();
        RoomDB room = new RoomDB();
        SlotDB slot = new SlotDB();
        SubjectDB subject = new SubjectDB();
        Session ses = null;
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
                + "  WHERE [seid] = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int seid = rs.getInt("seid");
                String gid = rs.getString("gid");
                int Slid = rs.getInt("Slid");
                int Tid = rs.getInt("Tid");
                String rid = rs.getString("rid");
                Date date = rs.getDate("date");
                String subid = rs.getString("subid");
                String lid = rs.getString("lid");
                boolean isTaken = rs.getBoolean("isTaken");

                Group gr = group.getGroupByID(gid);
                Lecturers l = lec.getLecturersById(lid);
                Room r = room.getRoomById(rid);
                TimeSlot time = tslot.getTimeSlotbyid(Tid);
                Slot s = slot.getSlotBySlotId(Slid);
                Subject sub = subject.getSubjectById(subid);
                ses = new Session(seid, gr, s, time, r, sub, date, l, isTaken);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return ses;
    }
    
    public List<Session> getSessionByLid(String username) {
        List<Session> list = new ArrayList();
        GroupDB group = new GroupDB();
        LecturersDB lec = new LecturersDB();
        TimeSlotDB tslot = new TimeSlotDB();
        RoomDB room = new RoomDB();
        SlotDB slot = new SlotDB();
        SubjectDB subject = new SubjectDB();
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
                + "  WHERE [lid] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int seid = rs.getInt("seid");
                String gid = rs.getString("gid");
                int slotid = rs.getInt("Slid");
                int tid = rs.getInt("Tid");
                String roomid = rs.getString("rid");
                Date date = rs.getDate("date");
                String subid = rs.getString("subid");
                String lid = rs.getString("lid");
                boolean isTaken = rs.getBoolean("isTaken");
                Group gr = group.getGroupByID(gid);
                Lecturers l = lec.getLecturersById(lid);
                Room r = room.getRoomById(roomid);
                TimeSlot time = tslot.getTimeSlotbyid(tid);
                Slot s = slot.getSlotBySlotId(slotid);
                Subject sub = subject.getSubjectById(subid);

                Session ses = new Session(seid, gr, s, time, r, sub, date, l, isTaken);
                list.add(ses);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Session> getSessionBySid(String username) {
        List<Session> list = new ArrayList();
        GroupDB group = new GroupDB();
        LecturersDB lec = new LecturersDB();
        TimeSlotDB tslot = new TimeSlotDB();
        RoomDB room = new RoomDB();
        SlotDB slot = new SlotDB();
        SubjectDB subject = new SubjectDB();
        String sql = "SELECT se.seid, se.rid, se.date, se.gid, se.isTaken,\n"
                + "       se.lid, se.tid, se.subid, se.Slid\n"
                + "FROM [Session] se\n"
                + "INNER JOIN [Group] g ON se.gid = g.gid\n"
                + "INNER JOIN [Enrollment] e ON g.gid = e.gid\n"
                + "INNER JOIN [Student] s ON s.stuid = e.stuid\n"
                + "WHERE s.stuid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int seid = rs.getInt("seid");
                String gid = rs.getString("gid");
                int Slid = rs.getInt("Slid");
                int Tid = rs.getInt("Tid");
                String rid = rs.getString("rid");
                Date date = rs.getDate("date");
                String subid = rs.getString("subid");
                String lid = rs.getString("lid");
                boolean isTaken = rs.getBoolean("isTaken");

                Group gr = group.getGroupByID(gid);
                Lecturers l = lec.getLecturersById(lid);
                Room r = room.getRoomById(rid);
                TimeSlot time = tslot.getTimeSlotbyid(Tid);
                Slot s = slot.getSlotBySlotId(Slid);
                Subject sub = subject.getSubjectById(subid);

                Session ses = new Session(seid, gr, s, time, r, sub, date, l, isTaken);
                list.add(ses);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    
}
