/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support.system;

import Model.Login;
import Model.Student;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import static support.system.FXMLDocumentController.loggedUsername;

/**
 * FXML Controller class
 *
 * @author User
 */
public class StudentLoginViewController implements Initializable {

    @FXML
    private JFXTextField idField;
    @FXML
    private JFXPasswordField passwordSField;

    public static Student loggedStudent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void handleLoginAction(ActionEvent event) {
        String username = idField.getText();
        String password = passwordSField.getText();
        Session session = null;
        Transaction transaction = null;
        try {
            session = SingletonFactory.getSessionFactory().openSession();

            session.beginTransaction();
            Criteria criteria = session.createCriteria(Login.class);
            criteria.add(Restrictions.eq("userName", username)).add(Restrictions.eq("password", password));
            List<Login> log = (List<Login>) criteria.list();
            //session.close();
            if (log.size() == 1) {
                String role = "";
                for (Login login : log) {
                    role = login.getUserType();
                }

                loggedUsername = username;

                switch (role) {

                    case "student":
                        Criteria criteria2 = session.createCriteria(Student.class);
                        criteria2.add(Restrictions.eq("studentId", loggedUsername));

                       
                        Object result = criteria2.uniqueResult();
                   
                        if (result != null) {
                            loggedStudent = (Student) result;
                           
                        }
                        
                        changeScene("StudentView.fxml");
                        break;
                        
                        
                }

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);

                alert.setTitle("Error Dialog");
                alert.setHeaderText("Please Give an Right Password And User Name");
                alert.setContentText("Ooops, there was an error!");

                alert.showAndWait();

            }
        } catch (Exception e) {
            System.err.println(e);
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    private void changeScene(String fxml) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Scene scene = new Scene(root);
           
            
            SupportSystem.getMainStage().setScene(scene);
            SupportSystem.getMainStage().show();
           
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleBackAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
            Scene scene = new Scene(root);

            SupportSystem.getMainStage().setScene(scene);
            SupportSystem.getMainStage().show();
        } catch (IOException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
