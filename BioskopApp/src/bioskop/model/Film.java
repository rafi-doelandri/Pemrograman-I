package bioskop.model;

public class Film {
    private int idFilm;
    private String judulFilm;
    private String genre;
    private int durasi;
    private String sinopsis;
    private String statusTayang;

    // Constructor, Getter, dan Setter
    public Film() {}

    public Film(int idFilm, String judulFilm, String genre, int durasi, String sinopsis, String statusTayang) {
        this.idFilm = idFilm;
        this.judulFilm = judulFilm;
        this.genre = genre;
        this.durasi = durasi;
        this.sinopsis = sinopsis;
        this.statusTayang = statusTayang;
    }

    public int getIdFilm() { return idFilm; }
    public void setIdFilm(int idFilm) { this.idFilm = idFilm; }
    public String getJudulFilm() { return judulFilm; }
    public void setJudulFilm(String judulFilm) { this.judulFilm = judulFilm; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public int getDurasi() { return durasi; }
    public void setDurasi(int durasi) { this.durasi = durasi; }
    public String getSinopsis() { return sinopsis; }
    public void setSinopsis(String sinopsis) { this.sinopsis = sinopsis; }
    public String getStatusTayang() { return statusTayang; }
    public void setStatusTayang(String statusTayang) { this.statusTayang = statusTayang; }
    
    @Override
    public String toString(){
        return judulFilm;
    }
}