/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support.system;

import Model.Course;
import Model.Faculty;
import Model.Offered;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
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
public class OfferedListController implements Initializable {

    @FXML
    private TableView<Offered> offeredTableView;
    @FXML
    private TableColumn<Offered, String> codeOFTable;
    @FXML
    private TableColumn<Offered, String> initOFTable;
    @FXML
    private TableColumn<Offered, String> sectionOFTable;
    @FXML
    private TableColumn<Offered, String> roomOFTable;
    private ObservableList<Offered> offers;
    @FXML
    private JFXButton handleBackAction;
    @FXML
    private TableColumn<Offered, String> startDayTable;
    @FXML
    private TableColumn<Offered, String> endDayTable;
    @FXML
    private TableColumn<Offered, String> startTimeTable;
    @FXML
    private TableColumn<Offered, String> endTimeTable;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        offers = FXCollections.observableArrayList();
        offers.addAll(offers);
        
        codeOFTable.setCellValueFactory(data -> new SimpleStringProperty( data.getValue().getCourses()+""));
        initOFTable.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getFacultys()+""));
        startTimeTable.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTime().getStartTime()+""));
        endTimeTable.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTime().getEndTime()+""));
        startDayTable.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDay().getStartDay()+""));
        endDayTable.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDay().getEndDay()+""));
        sectionOFTable.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getSections()+""));
        roomOFTable.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getRoomNo()+""));
        
        
        Session session = null;
        Transaction transaction = null;
        try {

            session = SingletonFactory.getSessionFactory().openSession();
            List<Offered> log = session.createCriteria(Offered.class).list();
            offers.addAll(log);
            offeredTableView.setItems(offers);
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
