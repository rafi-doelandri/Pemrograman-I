package bioskop.dao;

import bioskop.config.DatabaseConnection;
import bioskop.model.Showtime;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShowtimeDAO {
    
    // READ: Menampilkan jadwal beserta Judul Film dan Nama Studio menggunakan JOIN
    public List<Showtime> getAllShowtimes() {
        List<Showtime> listJadwal = new ArrayList<>();
        String sql = "SELECT s.id_jadwal, s.id_film, s.id_studio, s.tanggal_tayang, s.jam_tayang, s.harga_tiket, "
                   + "f.judul_film, st.nama_studio "
                   + "FROM showtimes s "
                   + "JOIN films f ON s.id_film = f.id_film "
                   + "JOIN studios st ON s.id_studio = st.id_studio "
                   + "ORDER BY s.tanggal_tayang DESC, s.jam_tayang ASC";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                Showtime jadwal = new Showtime();
                jadwal.setIdJadwal(rs.getInt("id_jadwal"));
                jadwal.setIdFilm(rs.getInt("id_film"));
                jadwal.setIdStudio(rs.getInt("id_studio"));
                jadwal.setTanggalTayang(rs.getDate("tanggal_tayang"));
                jadwal.setJamTayang(rs.getTime("jam_tayang"));
                jadwal.setHargaTiket(rs.getDouble("harga_tiket"));
                
                // Set data tambahan hasil JOIN
                jadwal.setJudulFilm(rs.getString("judul_film"));
                jadwal.setNamaStudio(rs.getString("nama_studio"));
                
                listJadwal.add(jadwal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listJadwal;
    }

    // CREATE: Menambah jadwal tayang baru
    public boolean insertShowtime(Showtime jadwal) {
        String sql = "INSERT INTO showtimes (id_film, id_studio, tanggal_tayang, jam_tayang, harga_tiket) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setInt(1, jadwal.getIdFilm());
            ps.setInt(2, jadwal.getIdStudio());
            ps.setDate(3, jadwal.getTanggalTayang());
            ps.setTime(4, jadwal.getJamTayang());
            ps.setDouble(5, jadwal.getHargaTiket());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // UPDATE: Mengubah data jadwal tayang
    public boolean updateShowtime(Showtime jadwal) {
        String sql = "UPDATE showtimes SET id_film=?, id_studio=?, tanggal_tayang=?, jam_tayang=?, harga_tiket=? WHERE id_jadwal=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setInt(1, jadwal.getIdFilm());
            ps.setInt(2, jadwal.getIdStudio());
            ps.setDate(3, jadwal.getTanggalTayang());
            ps.setTime(4, jadwal.getJamTayang());
            ps.setDouble(5, jadwal.getHargaTiket());
            ps.setInt(6, jadwal.getIdJadwal());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE: Menghapus jadwal tayang
    public boolean deleteShowtime(int idJadwal) {
        String sql = "DELETE FROM showtimes WHERE id_jadwal=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setInt(1, idJadwal);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<Showtime> getJadwalByFilm(int idFilm) {
        List<Showtime> listJadwal = new ArrayList<>();
        
        // Query menggunakan JOIN agar kita juga mendapatkan judul film dan nama studio
        String sql = "SELECT s.id_jadwal, s.id_film, s.id_studio, s.tanggal_tayang, s.jam_tayang, s.harga_tiket, "
                   + "f.judul_film, st.nama_studio "
                   + "FROM showtimes s "
                   + "JOIN films f ON s.id_film = f.id_film "
                   + "JOIN studios st ON s.id_studio = st.id_studio "
                   + "WHERE s.id_film = ? "
                   + "ORDER BY s.tanggal_tayang ASC, s.jam_tayang ASC";
        
        try (java.sql.Connection conn = bioskop.config.DatabaseConnection.getConnection();
             java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setInt(1, idFilm);
            java.sql.ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                // Menggunakan Constructor 8 Parameter
                Showtime jadwal = new Showtime(
                    rs.getInt("id_jadwal"),
                    rs.getInt("id_film"),
                    rs.getInt("id_studio"),
                    rs.getDate("tanggal_tayang"),
                    rs.getTime("jam_tayang"),
                    rs.getDouble("harga_tiket"),
                    rs.getString("judul_film"),
                    rs.getString("nama_studio")
                );
                listJadwal.add(jadwal);
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return listJadwal;
    }
}