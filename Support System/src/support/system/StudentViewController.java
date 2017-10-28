/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support.system;

import Enum.Religion;
import Enum.Sex;
import Model.Faculty;
import Model.Login;
import Model.Offered;
import Model.Registration;
import Model.Student;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import static support.system.FXMLDocumentController.loggedUsername;
import static support.system.StudentLoginViewController.loggedStudent;
import static support.system.SupportSystem.changeScene;

/**
 * FXML Controller class
 *
 * @author User
 */
public class StudentViewController implements Initializable {

    @FXML
    private Label SIdLabel;
    @FXML
    private Label SNameLabel;
    @FXML
    private Label programLabel;
    @FXML
    private Label HscSubjectLabel;
    @FXML
    private Label SscSubjectLabel;
    @FXML
    private Label SscYearLabel;
    @FXML
    private Label SscGradeLabel;
    @FXML
    private Label HscGradeYear;
    @FXML
    private Label HscYearLabel;
    @FXML
    private Label fatherLabel;
    @FXML
    private Label motherLabel;
    @FXML
    private Label districtLabel;
    @FXML
    private Label familyNumberLabel;
    @FXML
    private Label sexLabel;
    @FXML
    private Label religionLabel;
    @FXML
    private Label occuptionLabel;
    @FXML
    private Label citizenLabel;
    @FXML
    private Label personalNumLabel;
    @FXML
    private Label emailSLabel;
    @FXML
    private Label birthSField;
    private ObservableList<Student> students;
    private ObservableList<Registration> registrations;
    private ObservableList<Offered> offers;
    private int currentIndex;
    //private JFXComboBox<Offered> courseCombo;
    //private JFXListView<Offered> courseListView;
    @FXML
    private TableView<Offered> courseTableView;
    @FXML
    private TableColumn<Offered, Number> idTable;
    @FXML
    private TableColumn<Offered, String> facultyTable;
    @FXML
    private TableColumn<Offered, String> courseTable;
    @FXML
    private TableColumn<Offered, String> sectionTable;
    @FXML
    private TableColumn<Offered, String> roomTable;
    @FXML
    private TableColumn<Offered, String> startTimeTable;
    @FXML
    private TableColumn<Offered, String> endTimeTable;
    @FXML
    private TableColumn<Offered, String> startDayTable;
    @FXML
    private TableColumn<Offered, String> enddayTable;
    @FXML
    private ListView<Registration> courseListAllVew;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Student profileStudent = null;
        currentIndex = 0;
        students = FXCollections.observableArrayList();
        offers = FXCollections.observableArrayList();
        registrations = FXCollections.observableArrayList();
        courseTableView.setItems(offers);
        courseListAllVew.setItems(registrations);

        idTable.setCellValueFactory(data -> new SimpleLongProperty(data.getValue().getId()));
        facultyTable.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getFacultys() + ""));
        courseTable.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCourses() + ""));
        startTimeTable.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTime().getStartTime() + ""));
        endTimeTable.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTime().getEndTime() + ""));
        startDayTable.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDay().getStartDay() + ""));
        enddayTable.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDay().getEndDay() + ""));
        sectionTable.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getSections() + ""));
        roomTable.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getRoomNo() + ""));

        Session session = null;
        Transaction transaction = null;
        try {
            session = SingletonFactory.getSessionFactory().openSession();

            session.beginTransaction();
            Criteria criteria = session.createCriteria(Student.class);
            criteria.add(Restrictions.eq("studentId", loggedUsername));
            List<Student> students = (List<Student>) criteria.list();

            for (Student student : students) {

                profileStudent = student;
            }
            String id = students.get(currentIndex).getStudentId();
            String name = students.get(currentIndex).getStudentName();
            String program = students.get(currentIndex).getProgram();
            String sscSubject = students.get(currentIndex).getEducation_info().getSscSubject();
            String hscSubject = students.get(currentIndex).getEducation_info().getHscSubject();
            double sscGrade = students.get(currentIndex).getEducation_info().getSscGrade();
            double hscGrade = students.get(currentIndex).getEducation_info().getHscGrade();
            int sscYear = students.get(currentIndex).getEducation_info().getSscYear();
            int hscYear = students.get(currentIndex).getEducation_info().getHscYear();
            String email = students.get(currentIndex).getPersonal_info().getEmail();
            String phoneNumber = students.get(currentIndex).getPersonal_info().getPhoneNumber();
            String dateofBirth = students.get(currentIndex).getPersonal_info().getDateOfBirth();
            Sex sex = students.get(currentIndex).getPersonal_info().getSex();
            Religion religion = students.get(currentIndex).getPersonal_info().getReligion();
            String occuption = students.get(currentIndex).getPersonal_info().getOccuption();
            String citizenship = students.get(currentIndex).getPersonal_info().getCitizenship();
            String fatherName = students.get(currentIndex).getPersonal_info().getFatherName();
            String motherName = students.get(currentIndex).getPersonal_info().getMotherName();
            String familyNumber = students.get(currentIndex).getPersonal_info().getFamilyNumber();
            String district = students.get(currentIndex).getPersonal_info().getHomedistrict();

            SIdLabel.setText(id);
            SNameLabel.setText(name);
            programLabel.setText(program);
            HscSubjectLabel.setText(hscSubject);
            SscSubjectLabel.setText(sscSubject);
            SscYearLabel.setText(sscYear + "");
            HscYearLabel.setText(hscYear + "");
            SscGradeLabel.setText(sscGrade + "");
            HscGradeYear.setText(hscGrade + "");
            fatherLabel.setText(fatherName);
            motherLabel.setText(motherName);
            districtLabel.setText(district);
            familyNumberLabel.setText(familyNumber);
            sexLabel.setText(sex + "");
            religionLabel.setText(religion + "");
            occuptionLabel.setText(occuption);
            citizenLabel.setText(citizenship);
            personalNumLabel.setText(phoneNumber);
            emailSLabel.setText(email);
            birthSField.setText(dateofBirth);

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
            List<Offered> log = session.createCriteria(Offered.class).list();

            offers.addAll(log);
            courseTableView.setItems(offers);

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

            session.beginTransaction();
            Criteria criteria = session.createCriteria(Registration.class);
            //criteria.add(Restrictions.eq("student_studentId", loggedStudent));
            List<Registration> log = (List<Registration>) criteria.list();

            List<Registration> loggedStudentRegistration = new ArrayList<>();
            for (Registration registration : log) {
                Set<Student> studentSet = registration.getStudent();
                for (Student student : studentSet) {
                    if (student.getStudentId().equals(loggedStudent.getStudentId())) {
                        loggedStudentRegistration.add(registration);
                    }
                }
            }

            registrations.addAll(loggedStudentRegistration);
            courseListAllVew.setItems(registrations);

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
        changeScene("Student LoginView.fxml");
        loggedStudent = null;
        loggedUsername = null;
    }

    @FXML
    private void handleSaveAction(ActionEvent event) {

        Offered offerss = courseTableView.getSelectionModel().getSelectedItem();

        Set<Offered> offerr = new HashSet<>();
        offerr.add(offerss);

        Set<Student> student = new HashSet<>();
        student.add(loggedStudent);

        System.err.println("student set size " + student.size());
        Registration regi = new Registration(null, student, offerr);
        Session session = null;
        Transaction transaction = null;

        try {

            session = SingletonFactory.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.save(regi);
            System.out.println(regi);

            transaction.commit();

            registrations.add(regi);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Yeah Information Added");
            alert.setContentText("Successfully Added New Teacher Information");

            Optional<ButtonType> result = alert.showAndWait();
        } catch (Exception e) {
            System.err.println(e);
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();

        }
    }

}
