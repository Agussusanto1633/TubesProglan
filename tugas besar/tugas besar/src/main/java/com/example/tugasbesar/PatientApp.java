package com.example.tugasbesar;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PatientApp extends Application {
    private TableView<Patient> table = new TableView<>();
    private ObservableList<Patient> data = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("PENDATAAN PASIEN RUMAH SAKIT");

        TableColumn<Patient, String> nameCol = new TableColumn<>("NAMA");
        nameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        nameCol.setPrefWidth(200);

        TableColumn<Patient, Integer> ageCol = new TableColumn<>("UMUR");
        ageCol.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getAge()).asObject());

        TableColumn<Patient, String> addressCol = new TableColumn<>("ALAMAT");
        addressCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress()));
        addressCol.setPrefWidth(200);

        TableColumn<Patient, String> birthDateCol = new TableColumn<>("TANGGAL/BULAN/TAHUN LAHIR");
        birthDateCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBirthDate()));
        birthDateCol.setPrefWidth(200);

        table.getColumns().addAll(nameCol, ageCol, addressCol, birthDateCol);
        table.setItems(data);

        TextField nameField = new TextField();
        nameField.setPromptText("NAMA");
        TextField ageField = new TextField();
        ageField.setPromptText("UMUR");
        TextField addressField = new TextField();
        addressField.setPromptText("ALAMAT");
        TextField birthDateField = new TextField();
        birthDateField.setPromptText("TANGGAL/BULAN/TAHUN LAHIR");

        Button addButton = new Button("TAMBAH PASIEN");
        addButton.setOnAction(e -> {
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String address = addressField.getText();
            String birthDate = birthDateField.getText();
            data.add(new Patient(name, age, address, birthDate));
            nameField.clear();
            ageField.clear();
            addressField.clear();
            birthDateField.clear();
        });

        Button deleteButton = new Button("HAPUS");
        deleteButton.setOnAction(e -> {
            Patient selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                data.remove(selected);
            }
        });

        VBox vbox = new VBox();
        vbox.getChildren().addAll(nameField, ageField, addressField, birthDateField, addButton, deleteButton, table);

        Scene scene = new Scene(vbox, 700, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
