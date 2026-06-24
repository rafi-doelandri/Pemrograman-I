package bioskop.dao;

import bioskop.config.DatabaseConnection;
import bioskop.model.Film;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO {
    private Connection conn;

    public FilmDAO() {
        conn = DatabaseConnection.getConnection();
    }

    // READ: Menampilkan semua film
    public List<Film> getAllFilms() {
        List<Film> listFilm = new ArrayList<>();
        String sql = "SELECT * FROM films";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Film film = new Film(
                    rs.getInt("id_film"),
                    rs.getString("judul_film"),
                    rs.getString("genre"),
                    rs.getInt("durasi"),
                    rs.getString("sinopsis"),
                    rs.getString("status_tayang")
                );
                listFilm.add(film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listFilm;
    }

    // CREATE: Menambah film baru
    public boolean insertFilm(Film film) {
        String sql = "INSERT INTO films (judul_film, genre, durasi, sinopsis, status_tayang) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, film.getJudulFilm());
            ps.setString(2, film.getGenre());
            ps.setInt(3, film.getDurasi());
            ps.setString(4, film.getSinopsis());
            ps.setString(5, film.getStatusTayang());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // UPDATE: Mengubah data film
    public boolean updateFilm(Film film) {
        String sql = "UPDATE films SET judul_film=?, genre=?, durasi=?, sinopsis=?, status_tayang=? WHERE id_film=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, film.getJudulFilm());
            ps.setString(2, film.getGenre());
            ps.setInt(3, film.getDurasi());
            ps.setString(4, film.getSinopsis());
            ps.setString(5, film.getStatusTayang());
            ps.setInt(6, film.getIdFilm());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE: Menghapus film
    public boolean deleteFilm(int idFilm) {
        String sql = "DELETE FROM films WHERE id_film=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idFilm);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}