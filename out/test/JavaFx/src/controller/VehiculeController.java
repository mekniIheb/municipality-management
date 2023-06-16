package controller;

import domain.model.Vehicule;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lombok.SneakyThrows;
import respository.VehiculeRepository;
import service.VehiculeService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class VehiculeController implements Initializable {
    @FXML
    private AnchorPane scene;

    @FXML
    private Button btnAjouter;

    @FXML
    private Button btnSortir;

    @FXML
    private TextField txtMatricule;

    @FXML
    private TextField txtRecherche;

    @FXML
    private TextField txtnb;

    @FXML
    private TextField txtMarque;

    @FXML
    private TextField txtPuissance;
    @FXML
    private TableView<?> idTable;

    @FXML
    private TableColumn<?, ?> tabMatricule;

    @FXML
    private TableColumn<?, ?> tabMarque;

    @FXML
    private TableColumn<?, ?> tabNb;

    @FXML
    private TableColumn<?, ?> taPuiss;

    @FXML
    private TableColumn<?, ?> tabDate;
    VehiculeRepository service = new VehiculeService();
    private Object Vehicule;

    @FXML
    void Sortir(ActionEvent event) {

    }

    @SneakyThrows
    @FXML
    void ajouterVehicule(ActionEvent event) {
        fillTable(service.getAllVehicule());

        Vehicule v = new Vehicule(
                txtMatricule.getText(),
                txtMarque.getText(),
                Integer.parseInt(txtnb.getText()),
                Integer.parseInt(txtPuissance.getText()));

        service.addVehicule(v);
        ControlUtils.showConfirmationDialog("Information Dialog", "Look, an Information Dialog", "I have a great message for you!");
        txtMatricule.setText("");
        txtMarque.setText("");
        txtnb.setText("");
        txtPuissance.setText("");


    }

    private void fillTable(List<domain.model.Vehicule> allVehicule) {
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
      /*  private void fillTable(List<Vehicule> v) {
            tabMatricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));
            tabMarque.setCellValueFactory(new PropertyValueFactory<>("marque"));
            tabNb.setCellValueFactory(new PropertyValueFactory<>("nb_portes"));
            taPuiss.setCellValueFactory(new PropertyValueFactory<>("puissance"));
            tabDate.setCellValueFactory(new PropertyValueFactory<>("date"));
            vs.forEach(pp -> {
                idTable.getItems().add();
            }
        }
*/

    }
}
