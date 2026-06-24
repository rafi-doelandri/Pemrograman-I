/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bioskop.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aryab
 */
public class Order {
    private int idOrder;
    private int idUser;
    // Menggunakan Integer (bukan int) agar bisa diset Null jika user hanya beli makanan (tanpa tiket film)
    private Integer idJadwal; 
    private java.sql.Timestamp tanggalOrder;
    private double totalHarga;
    private String statusPembayaran;

    // Keranjang belanjaan user
    private List<OrderFoodDetail> listFoodDetails;
    private List<OrderPackageDetail> listPackageDetails;
    private List<OrderTicketDetail> listTiket;

    public Order() {
        this.listFoodDetails = new ArrayList<>();
        this.listPackageDetails = new ArrayList<>();
        this.listTiket = new ArrayList<>();
    }

    // Getter dan Setter
    public int getIdOrder() { return idOrder; }
    public void setIdOrder(int idOrder) { this.idOrder = idOrder; }
    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }
    public Integer getIdJadwal() { return idJadwal; }
    public void setIdJadwal(Integer idJadwal) { this.idJadwal = idJadwal; }
    public java.sql.Timestamp getTanggalOrder() { return tanggalOrder; }
    public void setTanggalOrder(java.sql.Timestamp tanggalOrder) { this.tanggalOrder = tanggalOrder; }
    public double getTotalHarga() { return totalHarga; }
    public void setTotalHarga(double totalHarga) { this.totalHarga = totalHarga; }
    public String getStatusPembayaran() { return statusPembayaran; }
    public void setStatusPembayaran(String statusPembayaran) { this.statusPembayaran = statusPembayaran; }

    public List<OrderFoodDetail> getListFoodDetails() { return listFoodDetails; }
    public void setListFoodDetails(List<OrderFoodDetail> listFoodDetails) { this.listFoodDetails = listFoodDetails; }
    public List<OrderPackageDetail> getListPackageDetails() { return listPackageDetails; }
    public void setListPackageDetails(List<OrderPackageDetail> listPackageDetails) { this.listPackageDetails = listPackageDetails; }
    public List<OrderTicketDetail> getListTiket() { return listTiket; }
    public void setListTiket(List<OrderTicketDetail> listTiket) { this.listTiket = listTiket; }
}
