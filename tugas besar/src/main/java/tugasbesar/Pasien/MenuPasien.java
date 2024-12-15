package tugasbesar.Pasien;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import tugasbesar.LoginPasien;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MenuPasien extends Application {

    @Override
    public void start(Stage primaryStage) {
        AnchorPane root = new AnchorPane();
        root.setPrefSize(700, 500);

        Label titleLabel = new Label(" Pengambilan Obat");
        titleLabel.setLayoutX(200.0);
        titleLabel.setLayoutY(60.0);
        titleLabel.setFont(new Font("Arial Black", 36.0));


        Image backgroundImage = new Image("file:C:\\Users\\MSI GSAMING\\OneDrive\\Gambar\\pngtree-facility-registration-counter-in-waiting-area-lobby-registration-diagnosis-report-photo-image_48392936 (2).jpg");
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        root.setBackground(new Background(background));



        Button logoutButton = new Button("Keluar");
        logoutButton.setLayoutX(14.0);
        logoutButton.setLayoutY(446.0);
        logoutButton.setPrefSize(119.0, 40.0);
        logoutButton.setFont(new Font("System Bold", 14.0));

        logoutButton.setOnAction(actionEvent -> {
            LoginPasien loginPasien = new LoginPasien();
            loginPasien.start(primaryStage);
        });

        Button tambahkanobatButton = new Button("Ambil Obat");
        tambahkanobatButton.setLayoutX(275.0);
        tambahkanobatButton.setLayoutY(172.0);
        tambahkanobatButton.setPrefSize(177.0, 68.0);
        tambahkanobatButton.setFont(new Font("System Bold", 18.0));

        tambahkanobatButton.setOnAction(actionEvent -> {
            PengambilanObat borrowBook = new PengambilanObat();
            borrowBook.start(primaryStage);
        });




        root.getChildren().addAll(titleLabel, logoutButton, tambahkanobatButton);

        Scene scene = new Scene(root);
        primaryStage.setTitle("Menu Pengambilan Obat");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
