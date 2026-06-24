/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bioskop.model;

import java.util.ArrayList;
import java.util.List;

public class FoodPackage {
    private int idPaket;
    private String namaPaket;
    private String deskripsi;
    private double harga;
    
    private List<FoodPackageDetail> details;
    
    public FoodPackage(){
        this.details = new ArrayList<>();
    }

    public FoodPackage(int idPaket, String namaPaket, String deskripsi, double harga) {
        this.idPaket = idPaket;
        this.namaPaket = namaPaket;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.details = new ArrayList<>();
    }

    public int getIdPaket() { return idPaket; }
    public void setIdPaket(int idPaket) { this.idPaket = idPaket; }

    public String getNamaPaket() { return namaPaket; }
    public void setNamaPaket(String namaPaket) { this.namaPaket = namaPaket; }

    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }

    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }

    public List<FoodPackageDetail> getDetails() { return details; }
    public void setDetails(List<FoodPackageDetail> details) { this.details = details; }
    
    public void addDetail(FoodPackageDetail detail) {
        this.details.add(detail);
    }
    
    @Override
    public String toString(){
        return namaPaket;
    }
}
