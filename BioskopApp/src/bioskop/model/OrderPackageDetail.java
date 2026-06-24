/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bioskop.model;

/**
 *
 * @author aryab
 */
public class OrderPackageDetail {
    private int idDetailPaketOrder;
    private int idOrder;
    private int idPaket;
    private int jumlah;
    private double subtotal;

    private String namaPaket; // Tambahan GUI

    public OrderPackageDetail() {}

    public OrderPackageDetail(int idDetailPaketOrder, int idOrder, int idPaket, int jumlah, double subtotal) {
        this.idDetailPaketOrder = idDetailPaketOrder;
        this.idOrder = idOrder;
        this.idPaket = idPaket;
        this.jumlah = jumlah;
        this.subtotal = subtotal;
    }

    // Getter dan Setter
    public int getIdDetailPaketOrder() { return idDetailPaketOrder; }
    public void setIdDetailPaketOrder(int idDetailPaketOrder) { this.idDetailPaketOrder = idDetailPaketOrder; }
    public int getIdOrder() { return idOrder; }
    public void setIdOrder(int idOrder) { this.idOrder = idOrder; }
    public int getIdPaket() { return idPaket; }
    public void setIdPaket(int idPaket) { this.idPaket = idPaket; }
    public int getJumlah() { return jumlah; }
    public void setJumlah(int jumlah) { this.jumlah = jumlah; }
    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }

    public String getNamaPaket() { return namaPaket; }
    public void setNamaPaket(String namaPaket) { this.namaPaket = namaPaket; }
}
