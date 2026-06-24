package bioskop.model;

public class Seat {
    // Field asli dari tabel database
    private int idKursi;
    private int idStudio;
    private String nomorKursi;
    private String jenisKursi;
    private String status;

    // Field tambahan untuk kebutuhan GUI (hasil JOIN)
    private String namaStudio;

    // 1. Constructor Kosong (Wajib ada untuk tarik data dari database)
    public Seat() {}

    // 2. Constructor 5 Parameter (Untuk proses Insert/Update dari GUI ke Database)
    public Seat(int idKursi, int idStudio, String nomorKursi, String jenisKursi, String status) {
        this.idKursi = idKursi;
        this.idStudio = idStudio;
        this.nomorKursi = nomorKursi;
        this.jenisKursi = jenisKursi;
        this.status = status;
    }

    // Getter dan Setter
    public int getIdKursi() { return idKursi; }
    public void setIdKursi(int idKursi) { this.idKursi = idKursi; }

    public int getIdStudio() { return idStudio; }
    public void setIdStudio(int idStudio) { this.idStudio = idStudio; }

    public String getNomorKursi() { return nomorKursi; }
    public void setNomorKursi(String nomorKursi) { this.nomorKursi = nomorKursi; }

    public String getJenisKursi() { return jenisKursi; }
    public void setJenisKursi(String jenisKursi) { this.jenisKursi = jenisKursi; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Getter dan Setter untuk field tambahan GUI
    public String getNamaStudio() { return namaStudio; }
    public void setNamaStudio(String namaStudio) { this.namaStudio = namaStudio; }
    
    @Override
    public String toString(){
        return nomorKursi;
    }
}