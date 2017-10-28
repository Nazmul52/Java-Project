/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.system;

import Model.Login;

import static com.mchange.v2.c3p0.impl.C3P0Defaults.user;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author John
 */


public class UniversitySystem extends Application {
    
    private static Stage mainStage;

    public static Stage getMainStage() {
        return mainStage;
        
   
    }

   
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Admission Login.fxml"));
        
        mainStage = stage;
        Scene scene = new Scene(root);
       
        stage.setScene(scene);
        stage.show();
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
