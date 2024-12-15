package tugasbesar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import tugasbesar.DB.Obat;
import tugasbesar.DB.Pasien;
import tugasbesar.DB.User;
import tugasbesar.Pasien.MenuPasien;

public class LoginPasien extends Application {

    public static boolean sudahTambah = false; 

    public static void addTempPasien(){
        User.list.add(new Pasien("Agus", "21",  "Tulungrejo", "demam"));
        User.list.add(new Pasien("Boby", "22", "gondanglegi", "kepala pusing"));
        User.list.add(new Pasien("Riska", "20", "turen", "susah bab"));
        User.list.add(new Pasien("Ghefira", "22", "Banyuwangi", "panas"));
    }

    public static void addTempObat() {
        User.obats.add(new Obat("1", "antibiotik", "4x1 (hari)",  4));
        User.obats.add(new Obat("2", "Paracetamol", "3x1 (hari)", 10));
        User.obats.add(new Obat("3", "antangin", "Sebelum makan ", 11));
        User.obats.add(new Obat("4", "Amoksilin", "Sebelum makan ", 3));
        User.obats.add(new Obat("5", "Mefinal", "Sebelum makan ", 20));
        User.obats.add(new Obat("6", "ambeven", "Sebelum makan ", 13));
        User.obats.add(new Obat("7", "Rhinos", "Sebelum makan ", 16));
        User.obats.add(new Obat("8", "Rhinofed", "Sebelum makan ", 25));
        User.obats.add(new Obat("9", "Cetrizin", "Sebelum makan ", 22));
        User.obats.add(new Obat("10", "tremenza", "Sebelum makan ", 29));
        User.obats.add(new Obat("11", "Cevixim", "Sebelum makan ", 5));
        User.obats.add(new Obat("12", "omeprazole", "Setelah makan ", 8));

    }

    @Override
    public void start(Stage primaryStage) {
        if(!sudahTambah) {
            addTempPasien();
            addTempObat();
            sudahTambah = true;
        }

        AnchorPane root = new AnchorPane();
        root.setPrefSize(700, 500);


        Label titleLabel = new Label("RUMAH SAKIT");
        titleLabel.setFont(new Font("Arial Black", 36));
        titleLabel.setLayoutX(231);
        titleLabel.setLayoutY(55);



        ImageView logoImageView = new ImageView(new Image("file:C:\\Users\\MSI GSAMING\\OneDrive\\Gambar\\Saved Pictures\\WhatsApp Image 2024-06-13 at 23.23.48_b954c74c.jpg"));
        logoImageView.setFitWidth(100);
        logoImageView.setFitHeight(100);
        logoImageView.setLayoutX(300);
        logoImageView.setLayoutY(120);


        Image backgroundImage = new Image("file:C:\\Users\\MSI GSAMING\\OneDrive\\Gambar\\pngtree-facility-registration-counter-in-waiting-area-lobby-registration-diagnosis-report-photo-image_48392936 (2).jpg");
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        root.setBackground(new Background(background));

        Label emailLabel = new Label("Email");
        emailLabel.setFont(new Font(18));
        emailLabel.setTextFill(Color.WHITE);
        emailLabel.setLayoutX(136);
        emailLabel.setLayoutY(240);

        Label passwordLabel = new Label("Password");
        passwordLabel.setFont(new Font(18));
        passwordLabel.setTextFill(Color.WHITE);
        passwordLabel.setLayoutX(139);
        passwordLabel.setLayoutY(326);

        Label errorLabel = new Label();
        errorLabel.setFont(new Font(18));
        errorLabel.setLayoutX(157);
        errorLabel.setLayoutY(495); // Adjust the Y position
        errorLabel.setPrefSize(381, 17);
        errorLabel.setTextFill(Color.RED);

        TextField usernameTextField = new TextField();
        usernameTextField.setLayoutX(163);
        usernameTextField.setLayoutY(268);
        usernameTextField.setPrefSize(381, 40);
        usernameTextField.setPromptText("Enter your username");

        PasswordField passwordField = new PasswordField();
        passwordField.setLayoutX(163);
        passwordField.setLayoutY(359);
        passwordField.setPrefSize(381, 40);
        passwordField.setPromptText("Enter your password");

        Button loginButton = new Button("Login");
        loginButton.setFont(new Font("Arial Black", 18));
        loginButton.setLayoutX(279);
        loginButton.setLayoutY(432);
        loginButton.setPrefSize(149, 61);

        loginButton.setOnAction(actionEvent -> {
            errorLabel.setText("");
            String username = usernameTextField.getText();
            String password = passwordField.getText();
            if (username.isEmpty()) {
                errorLabel.setText("username tidak boleh kosong");
                return;
            }
            if (password.isEmpty()) {
                errorLabel.setText("Password tidak boleh kosong");
                return;
            }
            if (username.equals("rumahsakit@gmail.com") && password.equals("12345")) {
                MenuPasien menuPasien = new MenuPasien();
                menuPasien.start(primaryStage);
            } else {
                errorLabel.setText("Username atau password salah");
            }
        });

        Button adminLoginButton = new Button("Login Admin");
        adminLoginButton.setFont(new Font("Arial Black", 14));
        adminLoginButton.setLayoutX(14);
        adminLoginButton.setLayoutY(460);
        adminLoginButton.setPrefSize(119, 40);

        adminLoginButton.setOnAction(actionEvent -> {
            LoginAdmin loginAdmin = new LoginAdmin();
            loginAdmin.start(primaryStage);
        });


        root.getChildren().addAll(titleLabel, logoImageView, emailLabel, passwordLabel, usernameTextField, passwordField, loginButton, adminLoginButton, errorLabel);

        Scene scene = new Scene(root);
        primaryStage.setTitle("Login Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
