package tugasbesar.Pasien;

import tugasbesar.DB.Obat;
import tugasbesar.DB.User;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Pengembalian extends Application {

    @Override
    public void start(Stage primaryStage) {
        AnchorPane root = new AnchorPane();
        root.setPrefSize(700, 500);

        Label titleLabel = new Label("Pengembalian Obat");
        titleLabel.setLayoutX(14.0);
        titleLabel.setLayoutY(16.0);
        titleLabel.setFont(new Font("System Bold", 30.0));

        Button backButton = new Button("Keluar");
        backButton.setLayoutX(14.0);
        backButton.setLayoutY(446.0);
        backButton.setPrefSize(119.0, 40.0);
        backButton.setFont(new Font("System Bold", 14.0));

        backButton.setOnAction(actionEvent -> {
            MenuPasien menuStudent = new MenuPasien();
            menuStudent.start(primaryStage);
        });

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setLayoutX(33.0);
        scrollPane.setLayoutY(102.0);
        scrollPane.setPrefSize(639.0, 329.0);

        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        TableView<Obat> tableView = new TableView<>();
        tableView.setPrefSize(639.0, 329.0);

        TableColumn<Obat, String> column1 = new TableColumn<>("Antrian");
        column1.setPrefWidth(140);
        column1.setCellValueFactory(new PropertyValueFactory<>("antrian"));
        TableColumn<Obat, String> column2 = new TableColumn<>("Nama Obat");
        column2.setPrefWidth(80);
        column2.setCellValueFactory(new PropertyValueFactory<>("nama"));
        TableColumn<Obat, String> column3 = new TableColumn<>("Minum");
        column3.setPrefWidth(80);
        column3.setCellValueFactory(new PropertyValueFactory<>("minum"));
        TableColumn<Obat, String> column4 = new TableColumn<>("Jumlah");
        column4.setPrefWidth(80);
        column4.setCellValueFactory(new PropertyValueFactory<>("jumlah"));

        tableView.getColumns().addAll(column1, column2, column3, column4);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        ObservableList<Obat> obatdata = FXCollections.observableArrayList();
        for (int i = 0; i < User.obat.size(); i++) {
            if(User.obat.get(i).get(0).equals(User.loginPasien)) {
                for (int j = 1; j < User.obat.get(i).size(); j++) {
                    for (int k = 0; k < User.obats.size(); k++) {
                        if(User.obat.get(i).get(j).equals(User.obats.get(k).getAntrian())) {
                            obatdata.add(User.obats.get(k));
                        }
                    }
                }
            }
        }
        tableView.setItems(obatdata);

        scrollPane.setContent(tableView);

        Label antrianLabel = new Label("No Antrian:");
        antrianLabel.setLayoutX(305.0);
        antrianLabel.setLayoutY(43.0);
        antrianLabel.setFont(new Font(15.0));
        antrianLabel.setFont(new Font("System Bold", 15.0));

        TextField antrianField = new TextField();
        antrianField.setLayoutX(395.0);
        antrianField.setLayoutY(39.0);
        antrianField.setPrefSize(193.0, 35.0);

        Label errorLabel = new Label();
        errorLabel.setLayoutX(395.0);
        errorLabel.setLayoutY(77.0);
        errorLabel.setPrefSize(292.0, 17.0);
        errorLabel.setTextFill(Color.RED);

        Button okButton = new Button("OK");
        okButton.setLayoutX(603.0);
        okButton.setLayoutY(37.0);
        okButton.setPrefSize(40.0, 40.0);

        root.getChildren().addAll(titleLabel, backButton, scrollPane, antrianLabel, antrianField, okButton, errorLabel);

        okButton.setOnAction(actionEvent -> {
            errorLabel.setText("");
            String inputNO = antrianField.getText();
            if(inputNO.isEmpty()) {
                errorLabel.setText("Nomer antrian tidak boleh kosong");
                return;
            }

            boolean find = false;
            for(int i = 0; i < User.obat.size(); i++) {
                if(User.obat.get(i).get(0).equals(User.loginPasien)) {
                    for (int j = 1; j < User.obat.get(i).size(); j++) {
                        if(User.obat.get(i).get(j).equals(inputNO)) {
                            find = true;
                            User.obat.get(i).remove(j);
                            for (int k = 0; k < User.obats.size(); k++) {
                                if(User.obats.get(k).getAntrian().equals(inputNO)) {
                                    User.obats.get(k).setJumlah(User.obats.get(k).getJumlah() + 1);
                                    start(primaryStage);
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
            }
            if(!find) {
                errorLabel.setText("Nomer Antrian Tidak Terdaftar");
            }
        });

        Scene scene = new Scene(root);
        primaryStage.setTitle("Pengembalian ");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
