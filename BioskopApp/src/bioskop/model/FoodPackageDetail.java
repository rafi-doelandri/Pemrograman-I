/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bioskop.model;

/**
 *
 * @author aryab
 */
public class FoodPackageDetail {
    private int idDetailPaket;
    private int idPaket;
    private int idFood;
    private int jumlah;
    
    private String namaFood;
    
    public FoodPackageDetail(){}

    public FoodPackageDetail(int idDetailPaket, int idPaket, int idFood, int jumlah) {
        this.idDetailPaket = idDetailPaket;
        this.idPaket = idPaket;
        this.idFood = idFood;
        this.jumlah = jumlah;
    }

    public int getIdDetailPaket() {
        return idDetailPaket;
    }

    public void setIdDetailPaket(int idDetailPaket) {
        this.idDetailPaket = idDetailPaket;
    }

    public int getIdPaket() {
        return idPaket;
    }

    public void setIdPaket(int idPaket) {
        this.idPaket = idPaket;
    }

    public int getIdFood() {
        return idFood;
    }

    public void setIdFood(int idFood) {
        this.idFood = idFood;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getNamaFood() {
        return namaFood;
    }

    public void setNamaFood(String namaFood) {
        this.namaFood = namaFood;
    }
    
}
