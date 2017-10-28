/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support.system;

import Model.Course;
import Model.Faculty;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author User
 */
public class CourseListController implements Initializable {

    @FXML
    private TableView<Course> codeTableView;
    @FXML
    private TableColumn<Course, String> codetable;
    @FXML
    private TableColumn<Course, String> titleTable;
    @FXML
    private TableColumn<Course, Number> creditsTable;
    
    private ObservableList<Course>courses;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       courses = FXCollections.observableArrayList();
      
       courses.addAll(courses);
       
       codetable.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCourseCode()));
       titleTable.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCourseTitle()));
       creditsTable.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getCourseCredits()));
       
        Session session = null;
        Transaction transaction = null;
        try {

            session = SingletonFactory.getSessionFactory().openSession();
            List<Course> log = session.createCriteria(Course.class).list();
            courses.addAll(log);
            codeTableView.setItems(courses);
        } catch (Exception e) {
            System.err.println(e);
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }    

    @FXML
    private void handleBackAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Coordinator View.fxml"));
            Scene scene = new Scene(root);

            SupportSystem.getMainStage().setScene(scene);
            SupportSystem.getMainStage().show();
        } catch (IOException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
