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
    private static boolean ispravnost = true;
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

    @FXML
    private ComboBox<String> godStudija;

    @FXML
    private ComboBox<String> ciklStudija;

    @FXML
    private ComboBox<String> finansiranje;

    @FXML
    private ComboBox<String> boracke;

    public void imePogresno() {
        if (imeTextfield.getText().isEmpty() || imeTextfield.getText().length() > 20) {
            imeTextfield.setStyle("-fx-background-color: red");
        }
        else {
            imeTextfield.setStyle("-fx-background-color: green");
        }
    }

    public void prezimePogresno() {
        if (prezimeTextfield.getText().isEmpty() || prezimeTextfield.getText().length() > 20) {
            prezimeTextfield.setStyle("-fx-background-color: red");
        }
        else {
            prezimeTextfield.setStyle("-fx-background-color: green");
        }
    }

    public void indeksIspravnost() {
        if (indeksTextfield.getText().length() != 5)
            indeksTextfield.setStyle("-fx-background-color: red");
        else {
            indeksTextfield.setStyle("-fx-background-color: green");
        }
    }

    public void jmbgIspravnost() {
        if (jmbgTextfield.getText().length() != 13) {
            jmbgTextfield.setStyle("-fx-background-color: red");
        }
        else {
            jmbgTextfield.setStyle("-fx-background-color: green");
        }
    }

    public void datumIspravnost() {
        String jmbgDatum = jmbgTextfield.getText().substring(0,2) + "." + jmbgTextfield.getText().substring(2,4) + ".";

        if (jmbgTextfield.getText().charAt(4) == '9')
            jmbgDatum += "1" + jmbgTextfield.getText().substring(4,7) + ".";
        else
            jmbgDatum += "2" + jmbgTextfield.getText().substring(4,7) + ".";
        System.out.println("Datum unešen: " + datum.getEditor().getText());
        System.out.println("Datum varijabla: " + jmbgDatum);
        if (!datum.getEditor().getText().equals(jmbgDatum)) {
            datum.setStyle("-fx-background-color: red");
        }
        else {
            datum.setStyle("-fx-background-color: green");
        }
    }

    public void prijavaGreska() throws Exception {
        if (!ispravnost) {
            try {
                Stage primaryStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("Greska.fxml"));
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.show();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void prijavi() throws Exception {
        /*if (imeTextfield.getText().isEmpty() || imeTextfield.getText().length() > 20) {
            imeTextfield.setStyle("-fx-background-color: #ff4b46");

            return;
        }*/
        prijavaGreska();
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
        System.out.println("Godina stuija: " + godStudija.getValue());
        System.out.println("Ciklus: " + ciklStudija.getValue());
        System.out.println("Redovan/redovan samofinansirajući: " + finansiranje.getValue());
        System.out.println("Boračke kategorije: " + boracke.getValue());
    }

    private ObservableList<String> mjesta = FXCollections.observableArrayList("Sarajevo", "Zenica", "Tuzla", "Banja Luka", "Bihać", "Mostar");
    private ObservableList<String> odsjeci = FXCollections.observableArrayList("AE", "EE", "Kurs", "TK");
    private ObservableList<String> godineStudija = FXCollections.observableArrayList("Prva", "Druga", "Treća");
    private ObservableList<String> ciklus = FXCollections.observableArrayList("Bachelor", "Master", "Doktorski", "Stručni");
    private ObservableList<String> finansije = FXCollections.observableArrayList("Redovan", "Redovan samofinansirajući");
    private ObservableList<String> nesto = FXCollections.observableArrayList("DA", "NE");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mjestoRodenja.setItems(mjesta);
        odsjek.setItems(odsjeci);
        godStudija.setItems(godineStudija);
        ciklStudija.setItems(ciklus);
        finansiranje.setItems(finansije);
        boracke.setItems(nesto);
    }
}
