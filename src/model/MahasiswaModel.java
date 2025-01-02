package model;

public class MahasiswaModel {
    private int idMahasiswa;
    private String nim;
    private String nama;
    private String jurusan;

    public MahasiswaModel(int idMahasiswa, String nim, String nama, String jurusan) {
        this.idMahasiswa = idMahasiswa;
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
    }

    public int getIdMahasiswa() {
        return idMahasiswa;
    }

    public void setIdMahasiswa(int idMahasiswa) {
        this.idMahasiswa = idMahasiswa;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }
}
