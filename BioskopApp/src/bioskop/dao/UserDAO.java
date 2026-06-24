/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bioskop.dao;

import bioskop.config.DatabaseConnection;
import bioskop.model.User;
import java.sql.*;

/**
 *
 * @author aryab
 */
public class UserDAO {
    public User loginUser(String email, String password){
        User user = null;
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            // Jika data ditemukan, buat objek User
            if (rs.next()) {
                user = new User(
                    rs.getInt("id_user"), // Sesuaikan nama kolom dengan yang ada di phpMyAdmin
                    rs.getString("nama"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("no_hp")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return user;
    }
    
    public boolean registerUser(User user){
        String sql = "INSERT INTO users (nama, email, password, no_hp) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setString(1, user.getNama());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getNoHp());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            // Error sering terjadi di sini jika email diset UNIQUE di database dan user mendaftar dengan email yang sama
            e.printStackTrace();
            return false; 
        }
    }
}
