/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support.system;

import Model.Faculty;
import Model.Student;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Teacher_ListController implements Initializable {

    @FXML
    private TableView<Faculty> teacherTable;
    @FXML
    private TableColumn<Faculty, String> nameTableView;
    @FXML
    private TableColumn<Faculty, String> initTableView;
    @FXML
    private TableColumn<Faculty, String> numberTableView;
    @FXML
    private TableColumn<Faculty, String> emailTableView;
    @FXML
    private TableColumn<Faculty, String> sexTableView;
    @FXML
    private TableColumn<Faculty, String> citizenView;
    @FXML
    private TableColumn<Faculty, String> qualificationView;
    
    private ObservableList<Faculty>facultys;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       facultys = FXCollections.observableArrayList();
       facultys.addAll(facultys);
       
       
         nameTableView.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getFacultyName()));
         initTableView.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getFacultyInit()));
         numberTableView.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getFaculty_address().getPhoneNumber()));
         emailTableView.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getFaculty_address().getEmail()));
         sexTableView.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getFaculty_address().getSex()));
         citizenView.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getFaculty_address().getCitizenship()));
         qualificationView.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getFaculty_address().getQualification()));
         
         
         
        Session session = null;
        Transaction transaction = null;
        try {

            session = SingletonFactory.getSessionFactory().openSession();
            List<Faculty> log = session.createCriteria(Faculty.class).list();
            facultys.addAll(log);
            teacherTable.setItems(facultys);
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
