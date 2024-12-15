package tugasbesar.DB;

public class Pasien {

    private String name, umur, alamat, keluhan;


    public Pasien(String name, String umur, String alamat, String keluhan) {
        this.name = name;
        this.umur = umur;
        this.alamat = alamat;
        this.keluhan = keluhan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat= alamat;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan= keluhan;
    }
}
