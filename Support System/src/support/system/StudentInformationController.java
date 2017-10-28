/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support.system;

import Enum.Religion;
import Enum.Sex;
import Model.Education_Info;
import Model.Personal_Info;

import Model.Student;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author User
 */
public class StudentInformationController implements Initializable {

    private ObservableList<Student> students;

    @FXML
    private JFXTextField SidField;
    @FXML
    private JFXTextField SnameField;
    @FXML
    private JFXTextField programField;
    @FXML
    private JFXTextField sscSubjectField;
    @FXML
    private JFXTextField HscSubjectField;
    @FXML
    private JFXTextField sscGradeField;
    @FXML
    private JFXTextField hasGradeField;
    @FXML
    private JFXTextField SscYearField;
    @FXML
    private JFXTextField hscYearField;
    @FXML
    private JFXTextField emailField;
    @FXML
    private JFXTextField PNumberField;
    //private JFXTextField birthField;
    @FXML
    private JFXTextField occuptionField;
    @FXML
    private JFXTextField citizenshipField;
    @FXML
    private JFXTextField fatherField;
    @FXML
    private JFXTextField motherField;
    @FXML
    private JFXTextField districtField;
    @FXML
    private JFXTextField familyNumberField;

    
    @FXML
    private TableColumn<Student, String> idTable;
    @FXML
    private TableColumn<Student, String> SNameTable;
    @FXML
    private TableColumn<Student, String> programTable;
    
    @FXML
    private TableColumn<Student, String> occuptionTable;
    @FXML
    private TableColumn<Student, String> FNameTable;
    @FXML
    private TableColumn<Student, String> MNameTable;
    @FXML
    private TableColumn<Student, String> districtTable;
    @FXML
    private TableColumn<Student, String> birthTable;
    @FXML
    private Label successLabel;
    @FXML
    private TableView<Student> studentTable;
    @FXML
    private JFXComboBox<Sex> sexCombo;
    @FXML
    private JFXComboBox<Religion> relCombo;
    @FXML
    private TableColumn<Student, String> sexTable;
    @FXML
    private TableColumn<Student, String> religionTable;
    //private JFXTextField dateOfBirth;
    @FXML
    private DatePicker datePicker;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sexCombo.getItems().setAll(Sex.values());
        relCombo.getItems().setAll(Religion.values());
        students = FXCollections.observableArrayList();
        studentTable.setItems(students);

        students.addAll(students);
        idTable.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStudentId()));
        SNameTable.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStudentName()));
        programTable.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getProgram()));
        sexTable.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPersonal_info().getSex()+""));
        religionTable.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPersonal_info().getReligion()+""));
        
        occuptionTable.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPersonal_info().getOccuption()));
        FNameTable.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPersonal_info().getFatherName()));
        MNameTable.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPersonal_info().getMotherName()));
        districtTable.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPersonal_info().getHomedistrict()));
        birthTable.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPersonal_info().getDateOfBirth()));

        Session session = null;
        Transaction transaction = null;
        try {

            session = SingletonFactory.getSessionFactory().openSession();
            List<Student> log = session.createCriteria(Student.class).list();
            students.addAll(log);

        } catch (Exception e) {
            System.err.println(e);
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }

    }

    private void clearField() {
        SidField.clear();
        SnameField.clear();
        programField.clear();
        sscSubjectField.clear();
        HscSubjectField.clear();
        sscGradeField.clear();
        hasGradeField.clear();
        SscYearField.clear();
        hscYearField.clear();
        emailField.clear();
        PNumberField.clear();
        occuptionField.clear();
        citizenshipField.clear();
        fatherField.clear();
        motherField.clear();
        districtField.clear();
        familyNumberField.clear();
       
        sexCombo.getSelectionModel().clearSelection();
        relCombo.getSelectionModel().clearSelection();
        
        successLabel.setText("Successfully New Students Added");
    }

    @FXML
    private void handleSubmitAction(ActionEvent event) {
         String studentId ;
        try {
           studentId = SidField.getText();
        } catch (Exception nfe) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText("Incorrect Student Id");
            alert.setContentText("Student Id has to be an integer");
            alert.showAndWait();
            return;
}
         String studentName ;
        try {
           studentName = SnameField.getText();
        } catch (Exception nfe) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText("Incorrect Student Name");
            alert.setContentText("Student Name has to be an String");
            alert.showAndWait();
            return;
}
       
       
        String program;
        try {
           program = programField.getText();
        } catch (Exception nfe) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText("Incorrect Program Name");
            alert.setContentText("Program Name has to be an String");
            alert.showAndWait();
            return;
}
        String sscSubject = sscSubjectField.getText();
        String hscSubject = HscSubjectField.getText();
        double sscGrade = Double.parseDouble(sscGradeField.getText());
        double hscGrade = Double.parseDouble(hasGradeField.getText());
        int sscYear = Integer.parseInt(SscYearField.getText());
        int hscYear = Integer.parseInt(hscYearField.getText());
        String email = emailField.getText();
        String phoneNumber = PNumberField.getText();
        String occuption = occuptionField.getText();
        String citizenship = citizenshipField.getText();
        String fatherName = fatherField.getText();
        String motherName = motherField.getText();
        String homedistrict = districtField.getText();
        String familyNumber = familyNumberField.getText();
        String dob = datePicker.getEditor().getText();
        Sex sex = sexCombo.getSelectionModel().getSelectedItem();
        Religion religion = relCombo.getSelectionModel().getSelectedItem();

        Student student = new Student(studentId, studentName, program,
                new Education_Info(sscSubject, sscGrade, sscYear, hscSubject, hscGrade, hscYear),
                new Personal_Info(phoneNumber, email, dob, occuption, citizenship, fatherName, motherName, homedistrict, familyNumber,sex,religion)
        );

        Session session = null;
        Transaction transaction = null;
        try {
            session = SingletonFactory.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(student);
            System.out.println(student);
            transaction.commit();
            
            students.add(student);
            System.err.println("//////////////");
            clearField();
        } catch (Exception e) {
            System.err.println(e);
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
         datePicker.setValue(null);
    }

    @FXML
    private void handleLogoutAction(ActionEvent event) {
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
