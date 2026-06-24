/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bioskop.model;

import java.sql.Date;
import java.sql.Time;

public class Showtime {
    private int idJadwal;
    private int idFilm;
    private int idStudio;
    private Date tanggalTayang;
    private Time jamTayang;
    private double hargaTiket;
    
    private String judulFilm;
    private String namaStudio;
    
    public Showtime(){}

    public Showtime(int idJadwal, int idFilm, int idStudio, Date tanggalTayang, Time jamTayang, double hargaTiket) {
        this.idJadwal = idJadwal;
        this.idFilm = idFilm;
        this.idStudio = idStudio;
        this.tanggalTayang = tanggalTayang;
        this.jamTayang = jamTayang;
        this.hargaTiket = hargaTiket;
    }
    
    public Showtime(int idJadwal, int idFilm, int idStudio, java.sql.Date tanggalTayang, java.sql.Time jamTayang, double hargaTiket, String judulFilm, String namaStudio) {
    this.idJadwal = idJadwal;
    this.idFilm = idFilm;
    this.idStudio = idStudio;
    this.tanggalTayang = tanggalTayang;
    this.jamTayang = jamTayang;
    this.hargaTiket = hargaTiket;
    this.judulFilm = judulFilm;
    this.namaStudio = namaStudio;
}
    
    
    public int getIdJadwal() { return idJadwal; }
    public void setIdJadwal(int idJadwal) { this.idJadwal = idJadwal; }
    
    public int getIdFilm() { return idFilm; }
    public void setIdFilm(int idFilm) { this.idFilm = idFilm; }
    
    public int getIdStudio() { return idStudio; }
    public void setIdStudio(int idStudio) { this.idStudio = idStudio; }
    
    public Date getTanggalTayang() { return tanggalTayang; }
    public void setTanggalTayang(Date tanggalTayang) { this.tanggalTayang = tanggalTayang; }
    
    public Time getJamTayang() { return jamTayang; }
    public void setJamTayang(Time jamTayang) { this.jamTayang = jamTayang; }
    
    public double getHargaTiket() { return hargaTiket; }
    public void setHargaTiket(double hargaTiket) { this.hargaTiket = hargaTiket; }

    // Getter & Setter untuk variabel tambahan GUI
    public String getJudulFilm() { return judulFilm; }
    public void setJudulFilm(String judulFilm) { this.judulFilm = judulFilm; }
    
    public String getNamaStudio() { return namaStudio; }
    public void setNamaStudio(String namaStudio) { this.namaStudio = namaStudio; }
    
    @Override
    public String toString() {
        return tanggalTayang + " | " + jamTayang + " (" + namaStudio + ")";
    }
}
