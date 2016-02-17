/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxfindword;

import javafx.application.Application;
import javafx.concurrent.Service;
import javafx.concurrent.WorkerStateEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Maxime
 */
public class MaxFindWord extends Application {
    
    public static Service<Void> service;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("BeginFrame.fxml"));
        
        Scene scene = new Scene(root);
        
        // Affichage fenêtre du début
        stage.setTitle("MaxFindWord, by Maxime BLAISE");
        stage.setScene(scene);
        stage.show();
        // Service
        service.start();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
