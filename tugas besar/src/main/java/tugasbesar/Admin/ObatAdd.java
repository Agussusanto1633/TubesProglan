package tugasbesar.Admin;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import tugasbesar.DB.Obat;
import tugasbesar.DB.User;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class ObatAdd extends Application {
    private static int idCounter = 0;

    @Override
    public void start(Stage primaryStage) {
        AnchorPane root = new AnchorPane();

        root.setPrefSize(700, 500);
        Image backgroundImage = new Image("file:C:\\Users\\MSI GSAMING\\OneDrive\\Gambar\\Rol Kamera\\20240227_094511.jpg");
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        root.setBackground(new Background(background));


        Label listBooksLabel = new Label("Pengambilan Obat");
        listBooksLabel.setFont(new Font("System Bold", 36));
        AnchorPane.setLeftAnchor(listBooksLabel, 200.0);
        AnchorPane.setTopAnchor(listBooksLabel, 34.0);


        Button backButton = new Button("Keluar");
        backButton.setFont(new Font("System Bold", 14));
        backButton.setPrefSize(119, 40);
        AnchorPane.setLeftAnchor(backButton, 14.0);
        AnchorPane.setTopAnchor(backButton, 446.0);

        backButton.setOnAction(actionEvent -> {
            MenuAdmin menuAdmin = new MenuAdmin();
            menuAdmin.start(primaryStage);
        });


        Label namaLabel = new Label("Nama Obat");
        namaLabel.setFont(new Font(18));
        AnchorPane.setLeftAnchor(namaLabel, 74.0);
        AnchorPane.setTopAnchor(namaLabel, 113.0);


        Label minumLabel = new Label("Aturan Minum");
        minumLabel.setFont(new Font(18));
        AnchorPane.setLeftAnchor(minumLabel, 74.0);
        AnchorPane.setTopAnchor(minumLabel, 192.0);


        Label jumlahLabel = new Label("Jumlah");
        jumlahLabel.setFont(new Font(18));
        AnchorPane.setLeftAnchor(jumlahLabel, 421.0);
        AnchorPane.setTopAnchor(jumlahLabel, 192.0);


        TextField namaTextField = new TextField();
        namaTextField.setPrefSize(257, 35);
        AnchorPane.setLeftAnchor(namaTextField, 82.0);
        AnchorPane.setTopAnchor(namaTextField, 140.0);


        TextField minumTextField = new TextField();
        minumTextField.setPrefSize(257, 35);
        AnchorPane.setLeftAnchor(minumTextField, 82.0);
        AnchorPane.setTopAnchor(minumTextField, 219.0);



        TextField jumlahTextField = new TextField();
        jumlahTextField.setPrefSize(201, 35);
        AnchorPane.setLeftAnchor(jumlahTextField, 430.0);
        AnchorPane.setTopAnchor(jumlahTextField, 219.0);

        Label errorLabel = new Label();
        errorLabel.setFont(new Font(14));
        errorLabel.setTextFill(Color.RED);
        errorLabel.setPrefSize(537, 20);
        AnchorPane.setLeftAnchor(errorLabel, 88.0);
        AnchorPane.setTopAnchor(errorLabel, 384.0);


        Button submitButton = new Button("Kirim");
        submitButton.setFont(new Font("System Bold", 18));
        submitButton.setPrefSize(165, 53);
        AnchorPane.setLeftAnchor(submitButton, 274.0);
        AnchorPane.setTopAnchor(submitButton, 302.0);

        submitButton.setOnAction(actionEvent -> {
            errorLabel.setText("");
            String title = namaTextField.getText();
            String minum = minumTextField.getText();

            if (title.isEmpty()) {
                errorLabel.setText("Nama  Obat wajib di isi!!");
                return;
            }
            if (minum.isEmpty()) {
                errorLabel.setText("Aturan Minum Wajib Di Isi !!!");
                return;
            }
            if (jumlahTextField.getText().isEmpty()) {
                errorLabel.setText(" Maaf Obat Habis ");
                return;
            }
            int jumlah = 0;
            try {
                jumlah = Integer.parseInt(jumlahTextField.getText());
            } catch (Exception e) {
                errorLabel.setText("Jumlah obat  harus Berupa Angka");
                return;
            }

            String antrian = MyClass.generateId();
            User.obats.add(new Obat(antrian, title, minum, jumlah));
            MenuAdmin menuAdmin = new MenuAdmin();
            menuAdmin.start(primaryStage);
        });


        root.getChildren().addAll(
                listBooksLabel, backButton, namaLabel, minumLabel, jumlahLabel, namaTextField, minumTextField, jumlahTextField, errorLabel, submitButton
        );

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Daftar Obat");
        primaryStage.show();
    }

    public class MyClass {
        public static int i = 13;
        private static int idCounter = 12;

        private static String generateId() {
            idCounter++;
            return String.valueOf(idCounter);
        }
    }
}




