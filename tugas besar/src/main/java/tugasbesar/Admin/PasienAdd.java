package tugasbesar.Admin;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import tugasbesar.DB.Pasien;
import tugasbesar.DB.User;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PasienAdd extends Application {

    @Override
    public void start(Stage primaryStage) {
        AnchorPane root = new AnchorPane();
        root.setPrefSize(700, 500);



        Label titleLabel = new Label("Tambahkan Pasien");
        titleLabel.setLayoutX(200.0);
        titleLabel.setLayoutY(34.0);
        titleLabel.setFont(new Font("Arial Black", 36.0));

        Button backButton = new Button("Back");
        backButton.setLayoutX(14.0);
        backButton.setLayoutY(446.0);
        backButton.setPrefSize(119.0, 40.0);
        backButton.setFont(new Font("Arial Black", 14.0));

        backButton.setOnAction(actionEvent -> {
            MenuAdmin menuAdmin = new MenuAdmin();
            menuAdmin.start(primaryStage);
        });

        Label nameLabel = new Label("Nama");
        nameLabel.setLayoutX(74.0);
        nameLabel.setLayoutY(113.0);
        nameLabel.setFont(new Font(18.0));
        nameLabel.setFont(new Font("Arial Black", 14.0));

        Label umurLabel = new Label("Umur");
        umurLabel.setLayoutX(74.0);
        umurLabel.setLayoutY(192.0);
        umurLabel.setFont(new Font(18.0));
        umurLabel.setFont(new Font("Arial Black", 14.0));

        Label alamatLabel = new Label("Alamat");
        alamatLabel.setLayoutX(376.0);
        alamatLabel.setLayoutY(113.0);
        alamatLabel.setFont(new Font(18.0));
        alamatLabel.setFont(new Font("Arial Black", 14.0));

        Label keluhanLabel = new Label("Keluhan");
        keluhanLabel.setLayoutX(378.0);
        keluhanLabel.setLayoutY(192.0);
        keluhanLabel.setFont(new Font(18.0));
        keluhanLabel.setFont(new Font("Arial Black", 14.0));

        TextField nameField = new TextField();
        nameField.setLayoutX(82.0);
        nameField.setLayoutY(140.0);
        nameField.setPrefSize(257.0, 35.0);

        TextField umurField = new TextField();
        umurField.setLayoutX(82.0);
        umurField.setLayoutY(219.0);
        umurField.setPrefSize(257.0, 35.0);

        TextField alamatField = new TextField();
        alamatField.setLayoutX(387.0);
        alamatField.setLayoutY(140.0);
        alamatField.setPrefSize(257.0, 35.0);

        TextField keluhanField = new TextField();
        keluhanField.setLayoutX(387.0);
        keluhanField.setLayoutY(219.0);
        keluhanField.setPrefSize(257.0, 35.0);

        Label errorLabel = new Label();
        errorLabel.setLayoutX(88.0);
        errorLabel.setLayoutY(384.0);
        errorLabel.setPrefSize(537.0, 20.0);
        errorLabel.setTextFill(Color.RED);
        errorLabel.setFont(new Font(14.0));

        Button submitButton = new Button("Kirim");
        submitButton.setLayoutX(274.0);
        submitButton.setLayoutY(302.0);
        submitButton.setPrefSize(165.0, 53.0);
        submitButton.setFont(new Font("Arial Black", 18.0));

        submitButton.setOnAction(actionEvent -> {
            String name = nameField.getText();
            String umur = umurField.getText();
            String alamat = alamatField.getText();
            String keluhan = keluhanField.getText();

            if(name.isEmpty()) {
                errorLabel.setText("Nama tidak boleh Kosong");
                return;
            }
            if(umur.isEmpty()) {
                errorLabel.setText("Umur tidak boleh kosong");
                return;
            }
            if(alamat.isEmpty()) {
                errorLabel.setText("Alamat tidak boleh kosng");
                return;
            }
            if(keluhan.isEmpty()) {
                errorLabel.setText("keluhan tdak boleh ksong");
            }

            if(umur.length() == 15) {
                errorLabel.setText("Masukan umur yang benar ");
                return;
            }

            if(!umur.matches("\\d+")) {
                errorLabel.setText("umur harus angka");
                return;
            }

            User.list.add(new Pasien(name, umur, alamat, keluhan));
            MenuAdmin menuAdmin = new MenuAdmin();
            menuAdmin.start(primaryStage);
        });

        root.getChildren().addAll(
                titleLabel, backButton, nameLabel, umurLabel, alamatLabel, keluhanLabel,
                nameField, umurField, alamatField, keluhanField, errorLabel, submitButton
        );

        Scene scene = new Scene(root);
        primaryStage.setTitle("Tambahkan Pasien");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
