package tugasbesar;

import tugasbesar.Admin.MenuAdmin;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginAdmin extends Application {

    @Override
    public void start(Stage primaryStage) {

        AnchorPane root = new AnchorPane();
        root.setPrefSize(700, 500);

        Image backgroundImage = new Image("file:C:\\Users\\MSI GSAMING\\OneDrive\\Gambar\\Saved Pictures\\pngtree-hospital-building-for-healthcare-cartoon-background-vector-illustration-with-picture-image_1806892.jpg");
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        root.setBackground(new Background(background));

        Label titleLabel = new Label("Login Admin");
        titleLabel.setFont(new Font("System Bold", 36));
        titleLabel.setLayoutX(239);
        titleLabel.setLayoutY(54);

        Label usernameLabel = new Label("Username");
        usernameLabel.setFont(new Font(18));
        usernameLabel.setLayoutX(136);
        usernameLabel.setLayoutY(126);

        Label passwordLabel = new Label("Password");
        passwordLabel.setFont(new Font(18));
        passwordLabel.setLayoutX(139);
        passwordLabel.setLayoutY(212);

        Label errorLabel = new Label();
        errorLabel.setFont(new Font(18));
        errorLabel.setLayoutX(157);
        errorLabel.setLayoutY(395);
        errorLabel.setPrefSize(381, 17);
        errorLabel.setTextFill(Color.RED);


        TextField usernameTextField = new TextField();
        usernameTextField.setLayoutX(163);
        usernameTextField.setLayoutY(154);
        usernameTextField.setPrefSize(381, 40);
        usernameTextField.setPromptText("Enter your username");

        PasswordField passwordField = new PasswordField();
        passwordField.setLayoutX(163);
        passwordField.setLayoutY(245);
        passwordField.setPrefSize(381, 40);
        passwordField.setPromptText("Enter your password");

        Button loginButton = new Button("Login");
        loginButton.setFont(new Font("System Bold", 18));
        loginButton.setLayoutX(279);
        loginButton.setLayoutY(318);
        loginButton.setPrefSize(149, 61);

        loginButton.setOnAction(actionEvent -> {
            errorLabel.setText("passwors atau username salah");
            String username = usernameTextField.getText();
            String password = passwordField.getText();
            if (username.isEmpty()) {
                errorLabel.setText("Username tidak boleh kosong");
                return;
            }
            if (password.isEmpty()) {
                errorLabel.setText("Password tidak boleh kosong");
                return;
            }
            if (username.equals("rumahsakit@gmail.com") && password.equals("12345")) {
                MenuAdmin menuAdmin = new MenuAdmin();
                menuAdmin.start(primaryStage);
            } else {
                errorLabel.setText("Username atau password salah");
            }
        });

        Button pasienLoginButton = new Button("Login Pasien");
        pasienLoginButton.setFont(new Font("Arial Black", 14));
        pasienLoginButton.setLayoutX(14);
        pasienLoginButton.setLayoutY(446);
        pasienLoginButton.setPrefSize(119, 40);

        pasienLoginButton.setOnAction(actionEvent -> {
            LoginPasien pasien = new LoginPasien();
            pasien.start(primaryStage);
        });

        root.getChildren().addAll(titleLabel, usernameLabel, passwordLabel, usernameTextField, passwordField, loginButton, pasienLoginButton, errorLabel);

        Scene scene = new Scene(root);
        primaryStage.setTitle("Form Pendaftaran");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
