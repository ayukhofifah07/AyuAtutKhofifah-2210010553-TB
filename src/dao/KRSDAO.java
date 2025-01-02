package dao;

import model.KRSModel;
import utils.DatabaseConnection;
import model.MahasiswaModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KRSDAO {

   public List<MahasiswaModel> getAllMahasiswa() {
    List<MahasiswaModel> mahasiswaList = new ArrayList<>();
    try (Connection conn = DatabaseConnection.getConnection()) {
        String query = "SELECT id_mahasiswa, nim, nama, jurusan FROM Mahasiswa";
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            mahasiswaList.add(new MahasiswaModel(
                    rs.getInt("id_mahasiswa"),
                    rs.getString("nim"),
                    rs.getString("nama"),
                    rs.getString("jurusan")
            ));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return mahasiswaList;
}
    
    // Create: Menambahkan data KRS baru
    public boolean addKRS(KRSModel krs) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO KRS (id_mahasiswa, kode_mk, nama_mk, sks) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, krs.getIdMahasiswa());
            stmt.setString(2, krs.getKodeMk());
            stmt.setString(3, krs.getNamaMk());
            stmt.setInt(4, krs.getSks());
            return stmt.executeUpdate() > 0; // Mengembalikan true jika berhasil
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Read: Mendapatkan semua data KRS
    public List<KRSModel> getAllKRS() {
        List<KRSModel> krsList = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM KRS";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                KRSModel krs = new KRSModel(
                        rs.getInt("id_krs"),
                        rs.getInt("id_mahasiswa"),
                        rs.getString("kode_mk"),
                        rs.getString("nama_mk"),
                        rs.getInt("sks")
                );
                krsList.add(krs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return krsList;
    }

    // Update: Memperbarui data KRS berdasarkan ID
    public boolean updateKRS(KRSModel krs) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "UPDATE KRS SET id_mahasiswa = ?, kode_mk = ?, nama_mk = ?, sks = ? WHERE id_krs = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, krs.getIdMahasiswa());
            stmt.setString(2, krs.getKodeMk());
            stmt.setString(3, krs.getNamaMk());
            stmt.setInt(4, krs.getSks());
            stmt.setInt(5, krs.getIdKrs());
            return stmt.executeUpdate() > 0; // Mengembalikan true jika berhasil
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete: Menghapus data KRS berdasarkan ID
    public boolean deleteKRS(int idKrs) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM KRS WHERE id_krs = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, idKrs);
            return stmt.executeUpdate() > 0; // Mengembalikan true jika berhasil
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get By ID: Mendapatkan data KRS berdasarkan ID
    public KRSModel getKRSById(int idKrs) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM KRS WHERE id_krs = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, idKrs);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new KRSModel(
                        rs.getInt("id_krs"),
                        rs.getInt("id_mahasiswa"),
                        rs.getString("kode_mk"),
                        rs.getString("nama_mk"),
                        rs.getInt("sks")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Mengembalikan null jika tidak ditemukan
    }
}