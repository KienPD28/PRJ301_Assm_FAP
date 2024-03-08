/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.TimeSlot;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class TimeSlotDB extends DBContext{
   
    
    public TimeSlot getTimeSlotbyid(int tid){
        try {
            String sql = "SELECT [Tid]\n"
                    + "      ,[StartTime]\n"
                    + "      ,[EndTime]\n"
                    + "  FROM [MY_FAP_PROJECT].[dbo].[TimeSlot]\n"
                    + "  where [Tid] = ?";
            PreparedStatement ps = connection.prepareStatement(sql); 
            ps.setInt(1, tid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TimeSlot t = new TimeSlot();
                t.setTid(rs.getInt("Tid"));
                t.setStartTime(rs.getTime("StartTime"));
                t.setEndTime(rs.getTime("EndTime"));
                return t;

            }
        } catch (SQLException ex) {
            Logger.getLogger(TimeSlotDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<TimeSlot> getAll() {
        List<TimeSlot> list = new ArrayList<>();
        try {
            String sql = "SELECT [Tid]\n"
                    + "      ,[StartTime]\n"
                    + "      ,[EndTime]\n"
                    + "  FROM [MY_FAP_PROJECT].[dbo].[TimeSlot]";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                TimeSlot t = new TimeSlot();
                t.setTid(rs.getInt("Tid"));
                t.setStartTime(rs.getTime("StartTime"));
                t.setEndTime(rs.getTime("EndTime"));
                list.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TimeSlotDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public static void main(String[] args) {
        TimeSlotDB db = new TimeSlotDB();
        List<TimeSlot> list = db.getAll();
        for (TimeSlot t : list) {
            System.out.println(t);
        }
    }
}
