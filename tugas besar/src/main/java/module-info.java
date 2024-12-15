module com.main.kegiatan6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens tugasbesar to javafx.fxml;
    opens tugasbesar.DB to javafx.base;
    exports tugasbesar;
    exports tugasbesar.Admin;
    exports tugasbesar.Pasien;
}