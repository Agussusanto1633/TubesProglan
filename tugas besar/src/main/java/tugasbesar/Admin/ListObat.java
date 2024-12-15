package tugasbesar.Admin;

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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ListObat extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        AnchorPane root = new AnchorPane();
        root.setPrefSize(700, 500);

        Label label = new Label("Daftar Obat");
        label.setLayoutX(264.0);
        label.setLayoutY(34.0);
        label.setFont(new Font("System Bold", 36.0));

        Button button = new Button("Keluar");
        button.setLayoutX(14.0);
        button.setLayoutY(446.0);
        button.setFont(new Font("Arial Black", 14.0));

        button.setOnAction(actionEvent -> {
            MenuAdmin menuAdmin = new MenuAdmin();
            menuAdmin.start(primaryStage);
        });

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setLayoutX(31.0);
        scrollPane.setLayoutY(111.0);
        scrollPane.setPrefHeight(322.0);
        scrollPane.setPrefWidth(638.0);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        TableView<Obat> tableView = new TableView<>();
        tableView.setPrefSize(638, 322);

        TableColumn<Obat, String > column1 = new TableColumn<>("Antrian");
        column1.setPrefWidth(140);
        column1.setCellValueFactory(new PropertyValueFactory<>("antrian"));
        TableColumn<Obat, String> column2 = new TableColumn<>("Nama");
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

        ObservableList<Obat> obats = FXCollections.observableArrayList(User.obats);
        tableView.setItems(obats);

        scrollPane.setContent(tableView);

        root.getChildren().addAll(label, button, scrollPane);

        Scene scene = new Scene(root);
        primaryStage.setTitle("Penebusan Obat");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
