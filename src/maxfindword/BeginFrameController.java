/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxfindword;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;

/**
 *
 * @author Maxime
 */
public class BeginFrameController implements Initializable {

    @FXML
    private ProgressIndicator progress;

    @Override
    public void initialize(URL url, ResourceBundle rb) {


        MaxFindWord.service = new Service<Void>() {
            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {

                        // Traitement
                        Dictionary.initialize();
                        return null;
                    }
                };
            }
        };
        MaxFindWord.service.setOnSucceeded((WorkerStateEvent event1) -> {
            progress.setProgress(1F);
            Stage stage = new Stage();
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("MainFrame.fxml"))));
                MaxFindWord.beginStage.close();
                stage.setTitle("MaxFindWord, by Maxime BLAISE");
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(BeginFrameController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

}
