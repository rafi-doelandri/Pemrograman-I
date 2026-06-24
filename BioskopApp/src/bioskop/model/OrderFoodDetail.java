/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bioskop.model;

/**
 *
 * @author aryab
 */
public class OrderFoodDetail {
    private int idDetailFood;
    private int idOrder;
    private int idFood;
    private int jumlah;
    private double subtotal;

    // Tambahan untuk GUI agar mudah dibaca di keranjang
    private String namaFood;

    public OrderFoodDetail() {}

    public OrderFoodDetail(int idDetailFood, int idOrder, int idFood, int jumlah, double subtotal) {
        this.idDetailFood = idDetailFood;
        this.idOrder = idOrder;
        this.idFood = idFood;
        this.jumlah = jumlah;
        this.subtotal = subtotal;
    }

    // Getter dan Setter
    public int getIdDetailFood() { return idDetailFood; }
    public void setIdDetailFood(int idDetailFood) { this.idDetailFood = idDetailFood; }
    public int getIdOrder() { return idOrder; }
    public void setIdOrder(int idOrder) { this.idOrder = idOrder; }
    public int getIdFood() { return idFood; }
    public void setIdFood(int idFood) { this.idFood = idFood; }
    public int getJumlah() { return jumlah; }
    public void setJumlah(int jumlah) { this.jumlah = jumlah; }
    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }
    
    public String getNamaFood() { return namaFood; }
    public void setNamaFood(String namaFood) { this.namaFood = namaFood; }
}
