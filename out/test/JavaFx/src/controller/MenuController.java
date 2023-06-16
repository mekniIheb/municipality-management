package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.SneakyThrows;


import java.io.IOException;

public class MenuController {
    @FXML
    private Button btnGV;

    @FXML
    private AnchorPane scene;

    @FXML
    private Button btn1;

    @FXML
    private Button btnSortir;
Stage sg ;
    Stage stage;
    private Parent fxml ;
    private Parent ssd ;

    @FXML
    void GestionPersonnel(ActionEvent event) {
        try {
            fxml= FXMLLoader.load(getClass().getResource("/templates/addpersonel.fxml"));
            scene.getChildren().removeAll();
            scene.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Sortir(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("sortir !!");
        alert.setHeaderText("");
        alert.setContentText("est ce que tu veux sortir?");
        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) scene.getScene().getWindow();
            System.out.println("exit");
            stage.close();
        }

    }

    @SneakyThrows
    @FXML
    void GestionVecicule(ActionEvent event) {
        Parent root = FXMLLoader.load(getClass().getResource("vehicule.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
}}
