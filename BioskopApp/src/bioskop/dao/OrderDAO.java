/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bioskop.dao;

import bioskop.config.DatabaseConnection;
import bioskop.model.Order;
import bioskop.model.OrderFoodDetail;
import bioskop.model.OrderPackageDetail;
import bioskop.model.OrderTicketDetail;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author aryab
 */
public class OrderDAO {
    public boolean insertOrderLengkap(Order order) {
        Connection conn = DatabaseConnection.getConnection();
        
        String sqlOrder = "INSERT INTO orders (id_user, id_jadwal, total_harga, status_pembayaran) VALUES (?, ?, ?, ?)";
        String sqlTicket = "INSERT INTO order_ticket_details (id_order, id_kursi, harga) VALUES (?, ?, ?)";
        String sqlDetailFood = "INSERT INTO order_food_details (id_order, id_food, jumlah, subtotal) VALUES (?, ?, ?, ?)";
        String sqlDetailPackage = "INSERT INTO order_package_details (id_order, id_paket, jumlah, subtotal) VALUES (?, ?, ?, ?)";
        
        try {
            conn.setAutoCommit(false);
            
            // 1. Simpan Nota Utama
            PreparedStatement psOrder = conn.prepareStatement(sqlOrder, Statement.RETURN_GENERATED_KEYS);
            psOrder.setInt(1, order.getIdUser());
            if (order.getIdJadwal() != null) {
                psOrder.setInt(2, order.getIdJadwal());
            } else {
                psOrder.setNull(2, java.sql.Types.INTEGER);
            }
            psOrder.setDouble(3, order.getTotalHarga());
            psOrder.setString(4, order.getStatusPembayaran());
            psOrder.executeUpdate();
            
            // Ambil Nomor Struk (ID Order)
            ResultSet rsKeys = psOrder.getGeneratedKeys();
            int idOrderBaru = 0;
            if (rsKeys.next()) {
                idOrderBaru = rsKeys.getInt(1);
            }
            
            // 2. SIMPAN KERANJANG TIKET (TABEL TICKETS)
            if (!order.getListTiket().isEmpty()) {
                PreparedStatement psTicket = conn.prepareStatement(sqlTicket);
                for (OrderTicketDetail tiket : order.getListTiket()) {
                    psTicket.setInt(1, idOrderBaru);
                    psTicket.setInt(2, tiket.getIdKursi());
                    psTicket.setDouble(3, tiket.getHarga());
                    psTicket.addBatch();
                }
                psTicket.executeBatch();
            }
            
            // 3. Simpan Keranjang Makanan
            if (!order.getListFoodDetails().isEmpty()) {
                PreparedStatement psFood = conn.prepareStatement(sqlDetailFood);
                for (OrderFoodDetail food : order.getListFoodDetails()) {
                    psFood.setInt(1, idOrderBaru);
                    psFood.setInt(2, food.getIdFood());
                    psFood.setInt(3, food.getJumlah());
                    psFood.setDouble(4, food.getSubtotal());
                    psFood.addBatch();
                }
                psFood.executeBatch();
            }
            
            // 4. Simpan Keranjang Paket Makanan
            if (!order.getListPackageDetails().isEmpty()) {
                PreparedStatement psPaket = conn.prepareStatement(sqlDetailPackage);
                for (OrderPackageDetail paket : order.getListPackageDetails()) {
                    psPaket.setInt(1, idOrderBaru);
                    psPaket.setInt(2, paket.getIdPaket());
                    psPaket.setInt(3, paket.getJumlah());
                    psPaket.setDouble(4, paket.getSubtotal());
                    psPaket.addBatch();
                }
                psPaket.executeBatch();
            }
            
            conn.commit();
            return true;
            
        } catch (SQLException e) {
            try { conn.rollback(); } catch (SQLException ex) {}
            e.printStackTrace();
            return false;
        } finally {
            try { conn.setAutoCommit(true); } catch (SQLException ex) {}
        }
    }
    
    public List<Order> getRiwayatOrderByUser(int idUser) {
        List<Order> listOrder = new ArrayList<>();
        // Gunakan LEFT JOIN ke showtimes dan films agar kita bisa tahu tiket film apa yang dibeli
        String sql = "SELECT o.*, f.judul_film FROM orders o "
                   + "LEFT JOIN showtimes s ON o.id_jadwal = s.id_jadwal "
                   + "LEFT JOIN films f ON s.id_film = f.id_film "
                   + "WHERE o.id_user = ? "
                   + "ORDER BY o.tanggal_order DESC"; // Riwayat terbaru muncul paling atas
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, idUser);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Order order = new Order();
                order.setIdOrder(rs.getInt("id_order"));
                order.setIdUser(rs.getInt("id_user"));
                
                // Ambil id_jadwal, jika null di database akan diset null di objek
                int idJadwal = rs.getInt("id_jadwal");
                order.setIdJadwal(rs.wasNull() ? null : idJadwal);
                
                order.setTanggalOrder(rs.getTimestamp("tanggal_order"));
                order.setTotalHarga(rs.getDouble("total_harga"));
                order.setStatusPembayaran(rs.getString("status_pembayaran"));
                
                listOrder.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOrder;
    }

    // 2. MENGAMBIL RINCIAN DETAIL MAKANAN SATUAN BERDASARKAN ID_ORDER
    public List<OrderFoodDetail> getDetailFoodByOrder(int idOrder) {
        List<OrderFoodDetail> list = new ArrayList<>();
        String sql = "SELECT ofd.*, f.nama_food FROM order_food_details ofd "
                   + "JOIN foods f ON ofd.id_food = f.id_food WHERE ofd.id_order = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idOrder);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderFoodDetail d = new OrderFoodDetail(rs.getInt("id_detail_food"), rs.getInt("id_order"), rs.getInt("id_food"), rs.getInt("jumlah"), rs.getDouble("subtotal"));
                d.setNamaFood(rs.getString("nama_food"));
                list.add(d);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    // 3. MENGAMBIL RINCIAN DETAIL PAKET MAKANAN BERDASARKAN ID_ORDER
    public List<OrderPackageDetail> getDetailPackageByOrder(int idOrder) {
        List<OrderPackageDetail> list = new ArrayList<>();
        String sql = "SELECT opd.*, fp.nama_paket FROM order_package_details opd "
                   + "JOIN food_packages fp ON opd.id_paket = fp.id_paket WHERE opd.id_order = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idOrder);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderPackageDetail d = new OrderPackageDetail(rs.getInt("id_detail_paket_order"), rs.getInt("id_order"), rs.getInt("id_paket"), rs.getInt("jumlah"), rs.getDouble("subtotal"));
                d.setNamaPaket(rs.getString("nama_paket"));
                list.add(d);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    // 4. MENGAMBIL RINCIAN DETAIL TIKET BERDASARKAN ID_ORDER
    public List<OrderTicketDetail> getDetailTicketByOrder(int idOrder) {
        List<OrderTicketDetail> list = new ArrayList<>();
        String sql = "SELECT otd.*, s.nomor_kursi FROM order_ticket_details otd "
                   + "JOIN seats s ON otd.id_kursi = s.id_kursi WHERE otd.id_order = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idOrder);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderTicketDetail d = new OrderTicketDetail(rs.getInt("id_detail_ticket"), rs.getInt("id_order"), rs.getInt("id_kursi"), rs.getDouble("harga"));
                d.setNomorKursi(rs.getString("nomor_kursi"));
                list.add(d);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }
}
