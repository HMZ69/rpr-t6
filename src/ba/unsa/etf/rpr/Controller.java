package ba.unsa.etf.rpr;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TextField imeTextfield;

    @FXML
    private TextField prezimeTextfield;

    @FXML
    private TextField indeksTextfield;

    @FXML
    private TextField jmbgTextfield;

    @FXML
    private DatePicker datum;

    @FXML
    private ComboBox<String> mjestoRodenja;

    @FXML
    private ComboBox<String> odsjek;

    @FXML
    private TextField adresaTextfield;

    @FXML
    private TextField telTextfield;

    @FXML
    private TextField emailTextfield;

    private ObservableList<String> mjesta = FXCollections.observableArrayList("Sarajevo", "Zenica", "Tuzla", "Banja Luka", "Bihać", "Mostar");
    private ObservableList<String> odsjeci = FXCollections.observableArrayList("AE", "EE", "Kurs", "TK");

    public void imePogresno() {
        if (imeTextfield.getText().isEmpty() || imeTextfield.getText().length() > 20) {
            imeTextfield.setStyle("-fx-background-color: red");
        }
        else
            imeTextfield.setStyle("-fx-background-color: green");
    }

    public void prezimePogresno() {
        if (prezimeTextfield.getText().isEmpty() || prezimeTextfield.getText().length() > 20) {
            prezimeTextfield.setStyle("-fx-background-color: red");
        }
        else
            prezimeTextfield.setStyle("-fx-background-color: green");
    }

    public void prijavi() throws Exception {
        /*if (imeTextfield.getText().isEmpty() || imeTextfield.getText().length() > 20) {
            imeTextfield.setStyle("-fx-background-color: #ff4b46");
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Greska.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            return;
        }*/
        System.out.println("Ime: " + imeTextfield.getText());
        System.out.println("Prezime: " + prezimeTextfield.getText());
        System.out.println("Broj indeksa: " + indeksTextfield.getText());
        System.out.println("JMBG: " + jmbgTextfield.getText());
        System.out.println("Datum rođenja: " + datum.getEditor().getText());
        System.out.println("Mjesto rođenja: " + mjestoRodenja.getValue());
        System.out.println("Kontakt adresa: " + adresaTextfield.getText());
        System.out.println("Broj telefona: " + telTextfield.getText());
        System.out.println("Email adresa: " + emailTextfield.getText());
        System.out.println("Odsjek: " + odsjek.getValue());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mjestoRodenja.setItems(mjesta);
        odsjek.setItems(odsjeci);
    }
}
