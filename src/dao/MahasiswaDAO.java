package dao;

import model.MahasiswaModel;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MahasiswaDAO {

    // Create: Menambahkan data mahasiswa baru
    public boolean addMahasiswa(MahasiswaModel mahasiswa) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Mahasiswa (nim, nama, jurusan) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, mahasiswa.getNim());
            stmt.setString(2, mahasiswa.getNama());
            stmt.setString(3, mahasiswa.getJurusan());
            return stmt.executeUpdate() > 0; // Mengembalikan true jika berhasil
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Read: Mendapatkan semua data mahasiswa
    public List<MahasiswaModel> getAllMahasiswa() {
        List<MahasiswaModel> mahasiswaList = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Mahasiswa";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                MahasiswaModel mahasiswa = new MahasiswaModel(
                        rs.getInt("id_mahasiswa"),
                        rs.getString("nim"),
                        rs.getString("nama"),
                        rs.getString("jurusan")
                );
                mahasiswaList.add(mahasiswa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mahasiswaList;
    }

    // Update: Memperbarui data mahasiswa berdasarkan ID
    public boolean updateMahasiswa(MahasiswaModel mahasiswa) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "UPDATE Mahasiswa SET nim = ?, nama = ?, jurusan = ? WHERE id_mahasiswa = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, mahasiswa.getNim());
            stmt.setString(2, mahasiswa.getNama());
            stmt.setString(3, mahasiswa.getJurusan());
            stmt.setInt(4, mahasiswa.getIdMahasiswa());
            return stmt.executeUpdate() > 0; // Mengembalikan true jika berhasil
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete: Menghapus data mahasiswa berdasarkan ID
    public boolean deleteMahasiswa(int idMahasiswa) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM Mahasiswa WHERE id_mahasiswa = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, idMahasiswa);
            return stmt.executeUpdate() > 0; // Mengembalikan true jika berhasil
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get By ID: Mendapatkan data mahasiswa berdasarkan ID
    public MahasiswaModel getMahasiswaById(int idMahasiswa) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Mahasiswa WHERE id_mahasiswa = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, idMahasiswa);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new MahasiswaModel(
                        rs.getInt("id_mahasiswa"),
                        rs.getString("nim"),
                        rs.getString("nama"),
                        rs.getString("jurusan")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Mengembalikan null jika tidak ditemukan
    }
}
