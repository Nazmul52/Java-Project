/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support.system;

import Model.Course;
import Model.Faculty;
import Model.Login;
import Model.Offered;
import Model.Registration;
import Model.Student;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import static support.system.FXMLDocumentController.loggedUsername;
import static support.system.SupportSystem.changeScene;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FacultyViewController implements Initializable {

    @FXML
    private Label nameLabel;
    @FXML
    private Label InitLabel;
    @FXML
    private Label numberLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label occuptionLabel;
    @FXML
    private Label sexLabel;
    @FXML
    private Label citizenshipLabel;
    private ObservableList<Faculty> facultys;
    private ObservableList<Offered> offered;
    private ObservableList<Registration> registration;
    private ObservableList<Student> students;
    private static int currentIndex;
    @FXML
    private JFXComboBox<Offered> courseLustCombobox;
    @FXML
    private TableView<Registration> studentTableView;
    @FXML
    private JFXListView<Registration> regiListView;
    @FXML
    private TableColumn<Registration, String> idView;
    @FXML
    private TableColumn<Registration, String> nameView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Faculty profileTeacher = null;
        currentIndex = 0;
        offered = FXCollections.observableArrayList();
        facultys = FXCollections.observableArrayList();
        registration = FXCollections.observableArrayList();
        students = FXCollections.observableArrayList();

        idView.setCellValueFactory(data-> new SimpleStringProperty(data.getValue().getOffers()+""));
        nameView.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStudent()+""));
        Session session = null;
        Transaction transaction = null;
        try {
            session = SingletonFactory.getSessionFactory().openSession();
            System.err.println(loggedUsername);
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Faculty.class);
            criteria.add(Restrictions.eq("facultyInit", loggedUsername));
            List<Faculty> facultyss = (List<Faculty>) criteria.list();
            //System.err.println("----- " + facultyss.size());
            Faculty loggedFaculty = null;
            for (Faculty faculty : facultyss) {
                loggedFaculty = faculty;
            }

            List<Offered> log = session.createCriteria(Offered.class).list();
            for (Offered offered1 : log) {
                Set<Faculty> facultySet = offered1.getFacultys();
                for (Faculty faculty : facultySet) {
                    if (faculty.getFacultyInit().equals(loggedFaculty.getFacultyInit())) {
                        offered.add(offered1);
                        courseLustCombobox.setItems(offered);
                    }
                }
            }

            String name = facultyss.get(currentIndex).getFacultyName();
            String init = facultyss.get(currentIndex).getFacultyInit();
            String number = facultyss.get(currentIndex).getFaculty_address().getPhoneNumber();
            String email = facultyss.get(currentIndex).getFaculty_address().getEmail();
            String occuption = facultyss.get(currentIndex).getFaculty_address().getOccuption();
            String sex = facultyss.get(currentIndex).getFaculty_address().getSex();
            String citizenship = facultyss.get(currentIndex).getFaculty_address().getCitizenship();

            nameLabel.setText(name);
            InitLabel.setText(init);
            numberLabel.setText(number);
            emailLabel.setText(email);
            occuptionLabel.setText(occuption);
            sexLabel.setText(sex);
            citizenshipLabel.setText(citizenship);

        } catch (Exception e) {
            System.err.println(e);
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
          
        try {

            session = SingletonFactory.getSessionFactory().openSession();
            List<Registration> log = session.createCriteria(Registration.class).list();
            registration.addAll(log);
            courseLustCombobox.setItems(offered);

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
    private void handleLogoutAction(ActionEvent event) {
        changeScene("FXMLDocument.fxml");
        loggedUsername=null;
      
    }

    @FXML
    private void handleMouseClickedAction(MouseEvent event) {
        
    }

    @FXML
    private void handleOnAction(ActionEvent event) {
   Session session = null;
        Transaction transaction = null;
        try {
            session = SingletonFactory.getSessionFactory().openSession();
            Offered offer = courseLustCombobox.getSelectionModel().getSelectedItem();
            Registration registrations = new Registration();
            transaction = session.beginTransaction();
            registrations.getStudent();
            transaction.commit();
            //registration.add(registrations);
            //regiListView.setItems(registration);
            studentTableView.setItems(registration);
            
        } catch (Exception ex) {

        }
    }

}
