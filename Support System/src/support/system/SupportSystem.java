/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support.system;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class SupportSystem extends Application {

    private static Stage mainStage;

    public static Stage getMainStage() {
        return mainStage;

    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));

        mainStage = stage;
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        
        stage.setTitle(" Southeast University ");
    }

    public static void changeScene(String FXML) {
        try {
            Parent root = FXMLLoader.load(SupportSystem.class.getResource(FXML));
            Scene scene = new Scene(root);
            
            SupportSystem.getMainStage().setScene(scene);
            SupportSystem.getMainStage().show();
        } catch (IOException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void stop() throws Exception {
        SingletonFactory.getSessionFactory().close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
