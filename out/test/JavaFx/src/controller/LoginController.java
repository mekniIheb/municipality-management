package controller;

import domain.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.SneakyThrows;
import service.LoginService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private Button btnLogin;

    @FXML
    private Button btnExit;

    @FXML
    private PasswordField txtPass;

    @FXML
    private TextField txtLog;
    @FXML
    private ImageView img;
    @FXML
    private AnchorPane scene;

    Parent root;
    Stage stage;
    private Parent fxml;

    LoginService service = new LoginService();

    @SneakyThrows
    @FXML
    void Login(ActionEvent event) {
        String cin = txtLog.getText();
        String pass = txtPass.getText();
        User u = new User(Integer.parseInt(cin), pass);
        boolean result = service.checkIfLoginValid(u);
        if (result) {
            scene.getScene().getWindow().hide();
            Stage home = new Stage();
            try {
                fxml = FXMLLoader.load(getClass().getResource("/templates/menu.fxml"));
                Scene scene = new Scene(fxml);
                home.setScene(scene);
                home.show();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            ControlUtils.ErrorDialog("error", "error", "error");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void Exit(ActionEvent actionEvent) {
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
}

