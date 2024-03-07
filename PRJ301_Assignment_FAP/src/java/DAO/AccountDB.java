/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Account;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class AccountDB extends DBContext {

    public Account getAccountByUsernameandPassword(String username, String password) {
        try {
            String sql = "SELECT [id]\n"
                    + "      ,[username]\n"
                    + "      ,[password]\n"
                    + "      ,[isTeacher]\n"
                    + "  FROM [MY_FAP_PROJECT].[dbo].[Account]\n"
                    + "  WHERE [username] = ? AND [password] = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Account a = new Account();
                a.setId(rs.getInt("id"));
                a.setUsername(rs.getString("username"));
                a.setPassword(rs.getString("password"));
                a.setIsTeacher(rs.getBoolean("isTeacher"));
                return a;
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(AccountDB.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    
    public static void main(String[] args) {
        AccountDB db = new AccountDB();
        Account a = db.getAccountByUsernameandPassword("HE170155", "123");
        System.out.println(a.getUsername());
    }
}
