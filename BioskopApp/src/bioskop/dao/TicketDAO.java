/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bioskop.dao;

import bioskop.config.DatabaseConnection;
import bioskop.model.Seat;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aryab
 */
public class TicketDAO {
    public List<Seat> getKursiTersedia(int idJadwal, int idStudio) {
        List<Seat> listKursiKosong = new ArrayList<>();
        
        // Query Sub-Select: Mencari kursi di studio tersebut yang TIDAK ADA di tabel tiket pada jadwal ini
        String sql = "SELECT * FROM seats WHERE id_studio = ? AND id_kursi NOT IN ("
                   + "    SELECT otd.id_kursi FROM order_ticket_details otd "
                   + "    JOIN orders o ON otd.id_order = o.id_order "
                   + "    WHERE o.id_jadwal = ?"
                   + ") ORDER BY nomor_kursi ASC";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setInt(1, idStudio);
            ps.setInt(2, idJadwal);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Seat kursi = new Seat();
                kursi.setIdKursi(rs.getInt("id_kursi"));
                kursi.setIdStudio(rs.getInt("id_studio"));
                kursi.setNomorKursi(rs.getString("nomor_kursi"));
                kursi.setJenisKursi(rs.getString("jenis_kursi"));
                kursi.setStatus(rs.getString("status"));
                
                listKursiKosong.add(kursi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listKursiKosong;
    }
}
