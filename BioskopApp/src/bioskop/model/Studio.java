package bioskop.model;

public class Studio {
    private int idStudio;
    private String namaStudio;
    private String jenisStudio;
    private int kapasitas;

    // Constructor Kosong
    public Studio() {}

    // Constructor Lengkap
    public Studio(int idStudio, String namaStudio, String jenisStudio, int kapasitas) {
        this.idStudio = idStudio;
        this.namaStudio = namaStudio;
        this.jenisStudio = jenisStudio;
        this.kapasitas = kapasitas;
    }

    // Getter dan Setter
    public int getIdStudio() { return idStudio; }
    public void setIdStudio(int idStudio) { this.idStudio = idStudio; }

    public String getNamaStudio() { return namaStudio; }
    public void setNamaStudio(String namaStudio) { this.namaStudio = namaStudio; }

    public String getJenisStudio() { return jenisStudio; }
    public void setJenisStudio(String jenisStudio) { this.jenisStudio = jenisStudio; }

    public int getKapasitas() { return kapasitas; }
    public void setKapasitas(int kapasitas) { this.kapasitas = kapasitas; }

    // Trik agar saat objek dimasukkan ke JComboBox, yang tampil adalah Nama Studio
    @Override
    public String toString() {
        return namaStudio;
    }
}
