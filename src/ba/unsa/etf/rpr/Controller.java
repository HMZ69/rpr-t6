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
    private static boolean ispravnost = false;

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

    public boolean imePogresno() {
        if (imeTextfield.getText().isEmpty() || imeTextfield.getText().length() > 20) {
            imeTextfield.setStyle("-fx-background-color: red");
            return false;
        }
        else {
            imeTextfield.setStyle("-fx-background-color: green");
            return true;
        }
    }

    public boolean prezimePogresno() {
        if (prezimeTextfield.getText().isEmpty() || prezimeTextfield.getText().length() > 20) {
            prezimeTextfield.setStyle("-fx-background-color: red");
            return false;
        }
        else {
            prezimeTextfield.setStyle("-fx-background-color: green");
            return true;
        }
    }

    public boolean indeksIspravnost() {
        if (indeksTextfield.getText().length() != 5) {
            indeksTextfield.setStyle("-fx-background-color: red");
            return false;
        }
        else {
            indeksTextfield.setStyle("-fx-background-color: green");
            return true;
        }
    }

    public boolean jmbgIspravnost() {
        if (jmbgTextfield.getText().length() == 13) {
            String s = jmbgTextfield.getText();
            int A = Integer.parseInt(String.valueOf(s.charAt(0)));
            int B = Integer.parseInt(String.valueOf(s.charAt(1)));
            int V = Integer.parseInt(String.valueOf(s.charAt(2)));
            int G = Integer.parseInt(String.valueOf(s.charAt(3)));
            int D = Integer.parseInt(String.valueOf(s.charAt(4)));
            int Đ = Integer.parseInt(String.valueOf(s.charAt(5)));
            int E = Integer.parseInt(String.valueOf(s.charAt(6)));
            int Ž = Integer.parseInt(String.valueOf(s.charAt(7)));
            int Z = Integer.parseInt(String.valueOf(s.charAt(8)));
            int I = Integer.parseInt(String.valueOf(s.charAt(9)));
            int J = Integer.parseInt(String.valueOf(s.charAt(10)));
            int K = Integer.parseInt(String.valueOf(s.charAt(11)));
            int L = Integer.parseInt(String.valueOf(s.charAt(12)));
            int kontrolnaCifra = Integer.parseInt(String.valueOf(s.charAt(12)));
            if (11 - ((7*(A+E) + 6*(B+Ž) + 5*(V+Z) + 4*(G+I) + 3*(D+J) + 2*(Đ+K)) % 11) == kontrolnaCifra) {
                jmbgTextfield.setStyle("-fx-background-color: green");
                return true;
            }
        }
        if (jmbgTextfield.getText().length() != 13) {
            jmbgTextfield.setStyle("-fx-background-color: red");
            return false;
        }
        return false;
    }

    public boolean datumIspravnost() {
        String jmbgDatum = jmbgTextfield.getText().substring(0,2) + "." + jmbgTextfield.getText().substring(2,4) + ".";

        if (jmbgTextfield.getText().charAt(4) == '9')
            jmbgDatum += "1" + jmbgTextfield.getText().substring(4,7) + ".";
        else
            jmbgDatum += "2" + jmbgTextfield.getText().substring(4,7) + ".";
        if (!datum.getEditor().getText().equals(jmbgDatum)) {
            datum.setStyle("-fx-background-color: red");
            return false;
        }
        else {
            datum.setStyle("-fx-background-color: green");
            return true;
        }
    }

    public void prijavaGreska() throws Exception {
        if (!imePogresno() || !prezimePogresno() || !indeksIspravnost() || !jmbgIspravnost() || !datumIspravnost()) {
            try {
                AlertBox.prikaziGresku("Greška", "Greška");
            }
            catch(Exception e) {
                e.printStackTrace();
            }
            /*try {
                Stage primaryStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("Greska.fxml"));
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.show();
            }
            catch(Exception e) {
                e.printStackTrace();
            }*/
        }
        else
            ispravnost = true;
    }

    public void prijavi() throws Exception {
        prijavaGreska();
        if (ispravnost) {
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
