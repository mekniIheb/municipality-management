package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Class.forName;


public class Controller implements Initializable {
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

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Stage stage;

    @FXML
    void Login(ActionEvent event) {
        String user = txtLog.getText();
        String pass = txtPass.getText();
        if (user.equals("") && pass.equals("")) {
            ControlUtils.WarningDialog("", "", "login ou mot de passe est vide!");
            txtLog.setText("");
            txtPass.setText("");


        } else {
            try {
                forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqldb", "root", "");
                pst = con.prepareStatement("select * from utilisateurs where Nom d'utilisateur = ? and Mot de passe =? ;");
                pst.setString(1, user);
                pst.setString(2, pass);
                rs = pst.executeQuery();

                if (rs.next()) {
                    ControlUtils.showConfirmationDialog("", "", "connexion réussie <3 ");
                } else {
                    ControlUtils.ErrorDialog("", "", "échec de la connexion");
                    txtLog.setText("");
                    txtPass.setText("");
                    txtLog.requestFocus();
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AddPersonelController.class.getName()).log(Level.SEVERE, null, ex);

            } catch (SQLException ex) {
                Logger.getLogger(AddPersonelController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        System.out.println("cnx succes");
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


