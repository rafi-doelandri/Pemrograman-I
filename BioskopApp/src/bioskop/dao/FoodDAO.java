/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bioskop.dao;

import bioskop.config.DatabaseConnection;
import bioskop.model.Food;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodDAO {
    // READ: Menampilkan semua makanan/minuman
    public List<Food> getAllFoods() {
        List<Food> listFood = new ArrayList<>();
        String sql = "SELECT * FROM foods ORDER BY kategori ASC, nama_food ASC";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                Food food = new Food(
                    rs.getInt("id_food"),
                    rs.getString("nama_food"),
                    rs.getString("kategori"),
                    rs.getDouble("harga"),
                    rs.getInt("stok")
                );
                listFood.add(food);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listFood;
    }

    // CREATE: Menambah makanan/minuman baru
    public boolean insertFood(Food food) {
        String sql = "INSERT INTO foods (nama_food, kategori, harga, stok) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setString(1, food.getNamaFood());
            ps.setString(2, food.getKategori());
            ps.setDouble(3, food.getHarga());
            ps.setInt(4, food.getStok());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // UPDATE: Mengubah data makanan/minuman
    public boolean updateFood(Food food) {
        String sql = "UPDATE foods SET nama_food=?, kategori=?, harga=?, stok=? WHERE id_food=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setString(1, food.getNamaFood());
            ps.setString(2, food.getKategori());
            ps.setDouble(3, food.getHarga());
            ps.setInt(4, food.getStok());
            ps.setInt(5, food.getIdFood());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE: Menghapus makanan/minuman
    public boolean deleteFood(int idFood) {
        String sql = "DELETE FROM foods WHERE id_food=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setInt(1, idFood);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
