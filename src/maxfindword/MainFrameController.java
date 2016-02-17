/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxfindword;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Maxime
 */
public class MainFrameController implements Initializable {

    @FXML
    private Slider sizeWords;
    @FXML
    private Label labelCount;
    @FXML
    private TextField listLettres;
    @FXML
    private TextField expressionReguliere;
    @FXML
    private ListView listWords;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // Listen for Slider value changes
        sizeWords.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            labelCount.setText(newValue.intValue() + " lettres.");
        });
    }

    @FXML
    public void valider(ActionEvent event) {
        ArrayList<String> lettres = new ArrayList<>();
        String slettres = listLettres.getText();
        for (int i = 0; i < slettres.length(); i++) {
            lettres.add("" + slettres.charAt(i));
        }
        ArrayList<String> res = Dictionary.getInstance().getListe((int) sizeWords.getValue(), lettres);
        listWords.setItems(FXCollections.observableArrayList(res));
    }
}
