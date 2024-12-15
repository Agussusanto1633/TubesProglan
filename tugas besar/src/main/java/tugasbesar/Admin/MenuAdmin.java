package tugasbesar.Admin;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import tugasbesar.LoginAdmin;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MenuAdmin extends Application {

    @Override
    public void start(Stage primaryStage) {

        AnchorPane root = new AnchorPane();
        root.setPrefSize(700, 500);


        Image backgroundImage = new Image("file:C:\\Users\\MSI GSAMING\\OneDrive\\Gambar\\Saved Pictures\\5101.jpg_wh860.jpg");
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        root.setBackground(new Background(background));


        Label titleLabel = new Label("Admin Menu");
        titleLabel.setFont(new Font("System Bold", 36));
        titleLabel.setLayoutX(239);
        titleLabel.setLayoutY(54);


        Button logoutButton = new Button("Keluar");
        logoutButton.setFont(new Font("System Bold", 14));
        logoutButton.setLayoutX(14);
        logoutButton.setLayoutY(446);
        logoutButton.setPrefSize(119, 40);

        logoutButton.setOnAction(actionEvent -> {
            LoginAdmin loginAdmin = new LoginAdmin();
            loginAdmin.start(primaryStage);
        });

        Button daftarPasien = new Button("Daftar pasien");
        daftarPasien.setFont(new Font("System Bold", 18));
        daftarPasien.setLayoutX(103);
        daftarPasien.setLayoutY(159);
        daftarPasien.setPrefSize(212, 76);

        daftarPasien.setOnAction(actionEvent -> {
            ListPasien listPasien = new ListPasien();
            listPasien.start(primaryStage);
        });

        Button daftarObat = new Button("Daftar Obat");
        daftarObat.setFont(new Font("System Bold", 18));
        daftarObat.setLayoutX(103);
        daftarObat.setLayoutY(294);
        daftarObat.setPrefSize(212, 76);

        daftarObat.setOnAction(actionEvent -> {
            ListObat listObat = new ListObat();
            try {
                listObat.start(primaryStage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        Button tambahkanpasienButton = new Button("Tambahkan pasien");
        tambahkanpasienButton.setFont(new Font("System Bold", 18));
        tambahkanpasienButton.setLayoutX(393);
        tambahkanpasienButton.setLayoutY(159);
        tambahkanpasienButton.setPrefSize(212, 76);

        tambahkanpasienButton.setOnAction(actionEvent -> {
            PasienAdd pasienAdd = new PasienAdd();
            pasienAdd.start(primaryStage);
        });

        Button tambahkanObat = new Button("Tambahkan Obat");
        tambahkanObat.setFont(new Font("System Bold", 18));
        tambahkanObat.setLayoutX(400);
        tambahkanObat.setLayoutY(294);
        tambahkanObat.setPrefSize(250, 76);

        tambahkanObat.setOnAction(actionEvent -> {
            ObatAdd obatAdd = new ObatAdd();
            obatAdd.start(primaryStage);
        });


        root.getChildren().addAll(titleLabel, logoutButton, daftarPasien, daftarObat, tambahkanpasienButton, tambahkanObat);


        Scene scene = new Scene(root);
        primaryStage.setTitle("Menu Admin");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
