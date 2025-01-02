package model;

public class KRSModel {
    private int idKrs;
    private int idMahasiswa;
    private String kodeMk;
    private String namaMk;
    private int sks;

    public KRSModel(int idKrs, int idMahasiswa, String kodeMk, String namaMk, int sks) {
        this.idKrs = idKrs;
        this.idMahasiswa = idMahasiswa;
        this.kodeMk = kodeMk;
        this.namaMk = namaMk;
        this.sks = sks;
    }

    public int getIdKrs() {
        return idKrs;
    }

    public void setIdKrs(int idKrs) {
        this.idKrs = idKrs;
    }

    public int getIdMahasiswa() {
        return idMahasiswa;
    }

    public void setIdMahasiswa(int idMahasiswa) {
        this.idMahasiswa = idMahasiswa;
    }

    public String getKodeMk() {
        return kodeMk;
    }

    public void setKodeMk(String kodeMk) {
        this.kodeMk = kodeMk;
    }

    public String getNamaMk() {
        return namaMk;
    }

    public void setNamaMk(String namaMk) {
        this.namaMk = namaMk;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }
}
