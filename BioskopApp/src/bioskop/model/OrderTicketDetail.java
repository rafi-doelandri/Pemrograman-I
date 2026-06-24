/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bioskop.model;

/**
 *
 * @author aryab
 */
public class OrderTicketDetail {
    private int idDetailTiket;
    private int idOrder;
    private int idKursi;
    private double harga;

    // Field tambahan untuk GUI (Keranjang Tiket)
    private String nomorKursi;

    public OrderTicketDetail() {}

    public OrderTicketDetail(int idDetailTiket, int idOrder, int idKursi, double harga) {
        this.idDetailTiket = idDetailTiket;
        this.idOrder = idOrder;
        this.idKursi = idKursi;
        this.harga = harga;
    }

    public int getIdTiket() { return idDetailTiket; }
    public void setIdTiket(int idDetailTiket) { this.idDetailTiket = idDetailTiket; }

    public int getIdOrder() { return idOrder; }
    public void setIdOrder(int idOrder) { this.idOrder = idOrder; }

    public int getIdKursi() { return idKursi; }
    public void setIdKursi(int idKursi) { this.idKursi = idKursi; }

    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }

    public String getNomorKursi() { return nomorKursi; }
    public void setNomorKursi(String nomorKursi) { this.nomorKursi = nomorKursi; }   
}
