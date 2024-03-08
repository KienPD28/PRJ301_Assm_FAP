/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Room;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class RoomDB extends DBContext{
    public Room getRoomById(String rid) {
        try {
            String sql = "SELECT [rid]\n"
                    + "      ,[rname]\n"
                    + "      ,[rbuilding]\n"
                    + "  FROM [MY_FAP_PROJECT].[dbo].[Room]\n"
                    + "  WHERE [rid] = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, rid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Room r = new Room();
                r.setId(rs.getString("rid"));
                r.setRname(rs.getString("rname"));
                r.setRbuilding(rs.getString("rbuilding"));
                return r;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RoomDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void main(String[] args) {
        RoomDB db = new RoomDB();
        Room r = db.getRoomById("r1");
        System.out.println(r.getRname());
        
    }
}
