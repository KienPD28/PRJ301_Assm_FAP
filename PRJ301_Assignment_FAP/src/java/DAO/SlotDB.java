/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Slot;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class SlotDB extends DBContext {

    public List<Slot> getAllSlot() {
        List<Slot> list = new ArrayList<>();
        try {
            String sql = "SELECT [Slid]\n"
                    + "      ,[Slname]\n"
                    + "  FROM [MY_FAP_PROJECT].[dbo].[Slot]";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs  = ps.executeQuery();
            while(rs.next()){
                Slot s = new Slot();
                s.setSlid(rs.getInt("Slid"));
                s.setSlname(rs.getString("Slname"));
                list.add(s);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SlotDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public Slot getSlotBySlotId(int Slid) {
        List<Slot> list = new ArrayList();
        try {
            String sql = "SELECT [Slid]\n"
                    + "      ,[Slname]\n"
                    + "  FROM [MY_FAP_PROJECT].[dbo].[Slot]\n"
                    + "  WHERE [Slid] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, Slid);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Slot s = new Slot(rs.getInt("Slid"), rs.getString("Slname"));
                return s;
            }
        } catch (SQLException ex) {

        }
        return null;

    }
    
     public static void main(String[] args) {
        SlotDB db = new SlotDB();
        int s = db.getAllSlot().size();
        System.out.println(s);
    }

}
