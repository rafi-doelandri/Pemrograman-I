package bioskop.dao;

import bioskop.config.DatabaseConnection;
import bioskop.model.Seat;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeatDAO {

    // READ: Menampilkan semua kursi beserta Nama Studio menggunakan JOIN
    public List<Seat> getAllSeats() {
        List<Seat> listKursi = new ArrayList<>();
        String sql = "SELECT s.id_kursi, s.id_studio, s.nomor_kursi, s.jenis_kursi, s.status, "
                   + "st.nama_studio "
                   + "FROM seats s "
                   + "JOIN studios st ON s.id_studio = st.id_studio "
                   + "ORDER BY st.nama_studio ASC, s.nomor_kursi ASC";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                Seat kursi = new Seat();
                kursi.setIdKursi(rs.getInt("id_kursi"));
                kursi.setIdStudio(rs.getInt("id_studio"));
                kursi.setNomorKursi(rs.getString("nomor_kursi"));
                kursi.setJenisKursi(rs.getString("jenis_kursi"));
                kursi.setStatus(rs.getString("status"));
                
                // Set data tambahan hasil JOIN
                kursi.setNamaStudio(rs.getString("nama_studio"));
                
                listKursi.add(kursi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listKursi;
    }

    // CREATE: Menambah data kursi baru
    public boolean insertSeat(Seat kursi) {
        String sql = "INSERT INTO seats (id_studio, nomor_kursi, jenis_kursi, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setInt(1, kursi.getIdStudio());
            ps.setString(2, kursi.getNomorKursi());
            ps.setString(3, kursi.getJenisKursi());
            ps.setString(4, kursi.getStatus());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // UPDATE: Mengubah data kursi
    public boolean updateSeat(Seat kursi) {
        String sql = "UPDATE seats SET id_studio=?, nomor_kursi=?, jenis_kursi=?, status=? WHERE id_kursi=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setInt(1, kursi.getIdStudio());
            ps.setString(2, kursi.getNomorKursi());
            ps.setString(3, kursi.getJenisKursi());
            ps.setString(4, kursi.getStatus());
            ps.setInt(5, kursi.getIdKursi());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE: Menghapus data kursi
    public boolean deleteSeat(int idKursi) {
        String sql = "DELETE FROM seats WHERE id_kursi=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setInt(1, idKursi);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}