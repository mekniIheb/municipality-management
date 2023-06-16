package controller;

import domain.model.Personel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import respository.PersonelRepository;
import service.PersonelService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class AddPersonelController implements Initializable {
    @FXML
    private Button btnAjout;

    @FXML
    private TableView<Personel> table;

    @FXML
    private TableColumn<Personel, String> cinCol;

    @FXML
    private TableColumn<Personel, String> nomCol;

    @FXML
    private TableColumn<Personel, String> prenomCol;

    @FXML
    private TableColumn<Personel, String> numCol;

    @FXML
    private TableColumn<Personel, String> addCol;

    @FXML
    private TextField txtCin;

    @FXML
    private TextField txtPrenom;

    @FXML
    private TextField txtNum;

    @FXML
    private TextField txtAddresse;

    @FXML
    private TextField txtNom;


    PersonelRepository service = new PersonelService();


    public void addPersonel(ActionEvent actionEvent) {
        fillTable(service.getAllPersonels());

        Personel p = new Personel(
                Integer.parseInt(txtCin.getText()),
                txtNom.getText(),
                txtPrenom.getText(),
                Integer.parseInt(txtNum.getText()),
                txtAddresse.getText());

        service.addPersonel(p);
        ControlUtils.showConfirmationDialog("Information Dialog","Look, an Information Dialog","I have a great message for you!");
        txtNom.setText("");
        txtPrenom.setText("");
        txtCin.setText("");
        txtNum.setText("");
        txtAddresse.setText("");



    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fillTable(service.getAllPersonels());
    }

  void fillTable(List<Personel> ps) {
        numCol.setCellValueFactory(new PropertyValueFactory<>("numero"));
        cinCol.setCellValueFactory(new PropertyValueFactory<>("cin"));
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
        addCol.setCellValueFactory(new PropertyValueFactory<>("adresse"));
      ps.forEach(pp -> {
        table.getItems().add(pp);
           }

           );



    }


}


