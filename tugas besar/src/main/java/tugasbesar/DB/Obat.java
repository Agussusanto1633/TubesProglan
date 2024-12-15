package tugasbesar.DB;

public class Obat {

    private String antrian, nama, minum;
    private int jumlah;


    public Obat(String antrian, String nama, String minum, int jumlah) {
        this.antrian = antrian;
        this.nama = nama;
        this.minum = minum;
        this.jumlah = jumlah;
    }

    public String getAntrian() {
        return antrian;
    }

    public void setAntrian() {this.antrian = antrian;}
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getMinum() {
        return minum;
    }

    public void setMinum(String minum) {
        this.minum = minum;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {this.jumlah = jumlah;}

}
