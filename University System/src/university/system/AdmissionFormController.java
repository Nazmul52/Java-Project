/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.system;

import Model.Address;
import Model.Student;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author John
 */
public class AdmissionFormController implements Initializable {

    @FXML
    private JFXTextField stuNameField;
    @FXML
    private JFXTextField stuIdField;
    @FXML
    private JFXTextField districtField;
    @FXML
    private JFXTextField villageField;
    @FXML
    private JFXTextField yearEnField;
    @FXML
    private JFXTextField upzilaField;
    
    private ObservableList<Student> students;
    @FXML
    private Label label;
    @FXML
    private TableView<Student> studentTableView;
    @FXML
    private TableColumn<Student, String> idTableList;
    @FXML
    private TableColumn<Student, String> nameTableList;
    @FXML
    private TableColumn<Student, Number> yearEnrolled;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       students = FXCollections.observableArrayList();
       studentTableView.setItems(students);
        
        students.addAll(students);
        idTableList.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getId()));
        nameTableList.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStudentName()));
        yearEnrolled.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getYearEnrolled()));
        Session session = null;
        Transaction transaction = null;
        try{
                
                session = SingletonFactory.getSessionFactory().openSession();
                List<Student> log = session.createCriteria(Student.class).list();
                students.addAll(log);
        
        }catch(Exception e){
                if (transaction != null)
                transaction.rollback();
        }finally{
            session.close();
        }
    }    

    @FXML
    private void handleSubmitAction(ActionEvent event) {
        String studentId = stuIdField.getText();
        String studentName = stuNameField.getText();
        String district = districtField.getText();
        String upzila = upzilaField.getText();
        String village = villageField.getText();
        int yearEnrolled = Integer.parseInt(yearEnField.getText());
  
        Student student = new Student(studentId, studentName,  yearEnrolled, new Address(district, upzila, village));
        Session session = null;
        Transaction transaction = null;
        try{
            session = SingletonFactory.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
            students.add(student);
            
        }catch(Exception e){
             if (transaction != null)
                transaction.rollback();
        }finally{
            session.close();
        }
        stuIdField.clear();
        stuNameField.clear();
        districtField.clear();
        upzilaField.clear();
        villageField.clear();
        yearEnField.clear();
        
        label.setText("Successfully Added New Student");
    }

    private void handleClearAction(ActionEvent event) {
        stuIdField.clear();
        stuNameField.clear();
        districtField.clear();
        upzilaField.clear();
        villageField.clear();
        yearEnField.clear();
    }

    private void handleStudentListAction(ActionEvent event) throws IOException {
        
       Parent root = FXMLLoader.load(getClass().getResource("StudentList.fxml"));

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    
}

}