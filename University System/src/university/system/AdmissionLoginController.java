/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.system;

import Model.Login;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
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
import javafx.stage.Stage;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

/**
 * FXML Controller class
 *
 * @author John
 */
public class AdmissionLoginController implements Initializable {

    @FXML
    private JFXPasswordField AdmitPassField;
    @FXML
    private JFXTextField admissionUserField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void handleLoginAction(ActionEvent event) throws IOException {
        String username = admissionUserField.getText();
        String password = AdmitPassField.getText();

        Session session = SingletonFactory.getSessionFactory().openSession();

        session.beginTransaction();
        Criteria criteria = session.createCriteria(Login.class);
        criteria.add(Restrictions.eq("userName", username)).add(Restrictions.eq("password", password));
        List<Login> log = (List<Login>) criteria.list();
        session.close();
        if (log.size() == 1) {
            String role = "";
            for (Login login : log) {
                role = login.getUsertype();
            }
            

            switch (role) {
                case "cc":
                    changeScene("CordinatorView.fxml");
                    break;
                case "chair":
                    changeScene("Admission Form.fxml");
                    break;
                case "faculty":
                    changeScene("faculty.fxml");
                    break;

            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error Dialog");
            alert.setHeaderText("Please Give an Right Password And User Name");
            alert.setContentText("Ooops, there was an error!");

            alert.showAndWait();

        }
    }

    private void changeScene(String fxml) {
        //fxml = "Admission Form.fxml";
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Scene scene = new Scene(root);

            UniversitySystem.getMainStage().setScene(scene);
            UniversitySystem.getMainStage().show();
        } catch (IOException ex) {
            Logger.getLogger(AdmissionLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handlebackAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("UniversitySystem.fxml"));

        Scene scene = new Scene(root);
        UniversitySystem.getMainStage().setScene(scene);
        UniversitySystem.getMainStage().show();
    }

}
