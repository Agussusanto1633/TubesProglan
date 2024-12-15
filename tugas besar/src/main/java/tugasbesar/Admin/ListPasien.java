package tugasbesar.Admin;

import tugasbesar.DB.Pasien;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ListPasien extends Application {

    @Override
    public void start(Stage primaryStage) {

        AnchorPane root = new AnchorPane();
        root.setPrefSize(700, 500);


        Label titleLabel = new Label("Daftar Pasien");
        titleLabel.setFont(new Font("System Bold", 36));
        titleLabel.setLayoutX(249);
        titleLabel.setLayoutY(33);


        Button backButton = new Button("Keluar");
        backButton.setFont(new Font("System Bold", 14));
        backButton.setLayoutX(14);
        backButton.setLayoutY(446);
        backButton.setPrefSize(119, 40);

        backButton.setOnAction(actionEvent -> {
            MenuAdmin menuAdmin = new MenuAdmin();
            menuAdmin.start(primaryStage);
        });


        TableView<Pasien> tableView = new TableView<>();
        tableView.setPrefSize(638, 322);

        TableColumn<Pasien, String> column1 = new TableColumn<>("Name");
        column1.setPrefWidth(140);
        column1.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Pasien, String> column2 = new TableColumn<>("umur");
        column2.setPrefWidth(80);
        column2.setCellValueFactory(new PropertyValueFactory<>("umur"));
        TableColumn<Pasien, String> column3 = new TableColumn<>("Alamat");
        column3.setPrefWidth(80);
        column3.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        TableColumn<Pasien, String> column4 = new TableColumn<>("Keluhan");
        column4.setPrefWidth(80);
        column4.setCellValueFactory(new PropertyValueFactory<>("keluhan"));

        tableView.getColumns().addAll(column1, column2, column3, column4);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        ObservableList<Pasien> pasiens = FXCollections.observableArrayList(User.list);
        tableView.setItems(pasiens);


        ScrollPane scrollPane = new ScrollPane(tableView);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setLayoutX(31);
        scrollPane.setLayoutY(111);
        scrollPane.setPrefSize(638, 322);


        root.getChildren().addAll(titleLabel, backButton, scrollPane);


        Scene scene = new Scene(root);
        primaryStage.setTitle("Daftar Pasien");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
