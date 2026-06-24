/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bioskop.dao;

import bioskop.config.DatabaseConnection;
import bioskop.model.Admin;
import java.sql.*;

/**
 *
 * @author aryab
 */
public class AdminDAO {
    public Admin loginAdmin(String email, String password){
        Admin admin = null;
        String sql = "SELECT * FROM admins WHERE email = ? AND password = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            // Jika data ditemukan, buat objek Admin
            if (rs.next()) {
                admin = new Admin(
                    rs.getInt("id_admin"), // Sesuaikan nama kolom dengan yang ada di phpMyAdmin
                    rs.getString("nama_admin"),
                    rs.getString("email"),
                    rs.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return admin;
    }
}
