package bioskop.dao;

import bioskop.config.DatabaseConnection;
import bioskop.model.FoodPackage;
import bioskop.model.FoodPackageDetail;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodPackageDAO {

    // 1. MENGAMBIL SEMUA PAKET
    public List<FoodPackage> getAllFoodPackages() {
        List<FoodPackage> listPaket = new ArrayList<>();
        String sql = "SELECT * FROM food_packages";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                listPaket.add(new FoodPackage(
                    rs.getInt("id_paket"),
                    rs.getString("nama_paket"),
                    rs.getString("deskripsi"),
                    rs.getDouble("harga")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPaket;
    }

    // 2. MENGAMBIL DETAIL DARI SATU PAKET (MENGGUNAKAN JOIN UNTUK DAPAT NAMA MAKANAN)
    public List<FoodPackageDetail> getPackageDetails(int idPaket) {
        List<FoodPackageDetail> listDetail = new ArrayList<>();
        String sql = "SELECT fpd.*, f.nama_food FROM food_packages_detail fpd "
                   + "JOIN foods f ON fpd.id_food = f.id_food "
                   + "WHERE fpd.id_paket = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setInt(1, idPaket);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                FoodPackageDetail detail = new FoodPackageDetail(
                    rs.getInt("id_detail_paket"),
                    rs.getInt("id_paket"),
                    rs.getInt("id_food"),
                    rs.getInt("jumlah")
                );
                detail.setNamaFood(rs.getString("nama_food"));
                listDetail.add(detail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDetail;
    }

    // 3. CREATE: MENYIMPAN PAKET SEKALIGUS DETAILNYA (TRANSACTION)
    public boolean insertFoodPackage(FoodPackage paket) {
        Connection conn = DatabaseConnection.getConnection();
        String sqlHeader = "INSERT INTO food_packages (nama_paket, deskripsi, harga) VALUES (?, ?, ?)";
        String sqlDetail = "INSERT INTO food_packages_detail (id_paket, id_food, jumlah) VALUES (?, ?, ?)";
        
        try {
            // Matikan auto-commit untuk memulai transaksi
            conn.setAutoCommit(false);
            
            // Simpan Header dan minta MySQL mengembalikan ID yang baru dibuat
            PreparedStatement psHeader = conn.prepareStatement(sqlHeader, Statement.RETURN_GENERATED_KEYS);
            psHeader.setString(1, paket.getNamaPaket());
            psHeader.setString(2, paket.getDeskripsi());
            psHeader.setDouble(3, paket.getHarga());
            psHeader.executeUpdate();
            
            // Ambil ID Paket yang baru saja di-generate
            ResultSet rsKeys = psHeader.getGeneratedKeys();
            int idPaketBaru = 0;
            if (rsKeys.next()) {
                idPaketBaru = rsKeys.getInt(1);
            }
            
            // Simpan Details menggunakan ID Paket yang baru
            PreparedStatement psDetail = conn.prepareStatement(sqlDetail);
            for (FoodPackageDetail detail : paket.getDetails()) {
                psDetail.setInt(1, idPaketBaru);
                psDetail.setInt(2, detail.getIdFood());
                psDetail.setInt(3, detail.getJumlah());
                psDetail.addBatch(); // Kumpulkan query
            }
            psDetail.executeBatch(); // Eksekusi semua query detail sekaligus
            
            conn.commit(); // Permanenkan data jika semua sukses
            return true;
            
        } catch (SQLException e) {
            try { conn.rollback(); } catch (SQLException ex) {} // Batalkan jika ada yang error
            e.printStackTrace();
            return false;
        } finally {
            try { conn.setAutoCommit(true); } catch (SQLException ex) {} // Kembalikan ke normal
        }
    }

    // 4. DELETE: MENGHAPUS PAKET
    public boolean deleteFoodPackage(int idPaket) {
        // Karena di skema database sudah ada ON DELETE CASCADE, 
        // menghapus header otomatis menghapus detailnya di tabel food_packages_detail.
        String sql = "DELETE FROM food_packages WHERE id_paket=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setInt(1, idPaket);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
