package bioskop.dao;

import bioskop.config.DatabaseConnection;
import bioskop.model.Studio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudioDAO {

    // READ: Mengambil semua data studio dari database
    public List<Studio> getAllStudios() {
        List<Studio> listStudio = new ArrayList<>();
        String sql = "SELECT * FROM studios";

        // Menggunakan try-with-resources untuk memastikan resource otomatis ditutup
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Studio studio = new Studio(
                    rs.getInt("id_studio"),
                    rs.getString("nama_studio"),
                    rs.getString("jenis_studio"),
                    rs.getInt("kapasitas")
                );
                listStudio.add(studio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listStudio;
    }

    // CREATE: Menambahkan data studio baru
    public boolean insertStudio(Studio studio) {
        String sql = "INSERT INTO studios (nama_studio, jenis_studio, kapasitas) VALUES (?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setString(1, studio.getNamaStudio());
            ps.setString(2, studio.getJenisStudio());
            ps.setInt(3, studio.getKapasitas());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // UPDATE: Mengubah data studio yang sudah ada
    public boolean updateStudio(Studio studio) {
        String sql = "UPDATE studios SET nama_studio=?, jenis_studio=?, kapasitas=? WHERE id_studio=?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setString(1, studio.getNamaStudio());
            ps.setString(2, studio.getJenisStudio());
            ps.setInt(3, studio.getKapasitas());
            ps.setInt(4, studio.getIdStudio());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE: Menghapus data studio berdasarkan ID
    public boolean deleteStudio(int idStudio) {
        String sql = "DELETE FROM studios WHERE id_studio=?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setInt(1, idStudio);
            
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}