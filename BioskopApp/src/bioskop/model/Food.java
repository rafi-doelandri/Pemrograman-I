package bioskop.model;

public class Food {
    private int idFood;
    private String namaFood;
    private String kategori;
    private double harga;
    private int stok;
    
    public Food() {}

    public Food(int idFood, String namaFood, String kategori, double harga, int stok) {
        this.idFood = idFood;
        this.namaFood = namaFood;
        this.kategori = kategori;
        this.harga = harga;
        this.stok = stok;
    }

    public int getIdFood() {
        return idFood;
    }

    public void setIdFood(int idFood) {
        this.idFood = idFood;
    }

    public String getNamaFood() {
        return namaFood;
    }

    public void setNamaFood(String namaFood) {
        this.namaFood = namaFood;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
    
    @Override
    public String toString(){
        return namaFood;
    }
}
