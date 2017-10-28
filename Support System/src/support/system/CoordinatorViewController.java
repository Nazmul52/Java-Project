/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support.system;

import Enum.Day;
import Enum.RoomNo;
import Enum.Section;
import Enum.Time;

import Model.Course;
import Model.Faculty;
import Model.Faculty_Address;
import Model.Offered;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import static support.system.FXMLDocumentController.loggedUsername;

/**
 * FXML Controller class
 *
 * @author User
 */
public class CoordinatorViewController implements Initializable {

    @FXML
    private Label NameTLabel;
    @FXML
    private Label InitTLabel;
    @FXML
    private Label sexTLabel;
    @FXML
    private Label qualiTLabel;
    @FXML
    private Label citizenshipTLabel;
    @FXML
    private Label NumberTField;
    @FXML
    private Label emailTField;
    @FXML
    private JFXComboBox<Course> codeCombo;
    @FXML
    private JFXComboBox<Faculty> teacherCombo;
    @FXML
    private JFXComboBox<RoomNo> roomCombo;

    @FXML
    private JFXTextField codeField;
    @FXML
    private JFXTextField titleField;
    @FXML
    private JFXTextField creditsField;
    @FXML
    private JFXTextField teachNameField;
    @FXML
    private JFXTextField teachInitField;
    @FXML
    private JFXTextField teachNumField;
    @FXML
    private JFXTextField teachEmailField;
    @FXML
    private JFXTextField teachQualiField;
    @FXML
    private JFXTextField teachSexField;
    @FXML
    private JFXTextField teachOccuptionField;

    private ObservableList<Faculty> facultys;
    private ObservableList<Course> Courses;
    private ObservableList<Offered> offers;
    @FXML
    private JFXTextField teachCitizenshipField;
    private static int currentIndex;
    @FXML
    private Label occuptionTLabel;
    @FXML
    private JFXComboBox<Section> sectionCombo;

    @FXML
    private JFXComboBox<Time> TimeCombo;
    @FXML
    private JFXComboBox<Day> DayCombo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currentIndex = 0;
        Faculty profileTeacher = null;

        DayCombo.getItems().setAll(Day.values());
        TimeCombo.getItems().setAll(Time.values());
        roomCombo.getItems().setAll(RoomNo.values());
        sectionCombo.getItems().setAll(Section.values());

        facultys = FXCollections.observableArrayList();
        Courses = FXCollections.observableArrayList();
        offers = FXCollections.observableArrayList();
        //facultys.addAll(facultys);
        //Courses.addAll(Courses);

        Session session = null;
        Transaction transaction = null;
        try {
            session = SingletonFactory.getSessionFactory().openSession();

            session.beginTransaction();
            Criteria criteria = session.createCriteria(Faculty.class);
            criteria.add(Restrictions.eq("facultyInit", loggedUsername));
            List<Faculty> facultyss = (List<Faculty>) criteria.list();

            for (Faculty faculty : facultyss) {

                profileTeacher = faculty;
            }

            String name = facultyss.get(currentIndex).getFacultyName();
            String init = facultyss.get(currentIndex).getFacultyInit();
            String number = facultyss.get(currentIndex).getFaculty_address().getPhoneNumber();
            String email = facultyss.get(currentIndex).getFaculty_address().getEmail();
            String occuption = facultyss.get(currentIndex).getFaculty_address().getOccuption();
            String sex = facultyss.get(currentIndex).getFaculty_address().getSex();
            String citizenship = facultyss.get(currentIndex).getFaculty_address().getCitizenship();
            String qualification = facultyss.get(currentIndex).getFaculty_address().getQualification();

            NameTLabel.setText(name);
            InitTLabel.setText(init);
            NumberTField.setText(number);
            emailTField.setText(email);
            citizenshipTLabel.setText(citizenship);
            sexTLabel.setText(sex);
            qualiTLabel.setText(qualification);
            occuptionTLabel.setText(occuption);

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
            List<Course> log = session.createCriteria(Course.class).list();
            Courses.addAll(log);
            codeCombo.setItems(Courses);
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
            List<Faculty> log1 = session.createCriteria(Faculty.class).list();
            facultys.addAll(log1);
            teacherCombo.setItems(facultys);
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
    private void handleTeacherOfferedAction(ActionEvent event) {

        Faculty faculty = teacherCombo.getSelectionModel().getSelectedItem();
        Course course = codeCombo.getSelectionModel().getSelectedItem();
        Time time = TimeCombo.getSelectionModel().getSelectedItem();

        Day day = DayCombo.getSelectionModel().getSelectedItem();

        RoomNo roomNo = roomCombo.getSelectionModel().getSelectedItem();
        Section section = sectionCombo.getSelectionModel().getSelectedItem();

        Set<Faculty> facultys = new HashSet<>();
        facultys.add(faculty);
        System.err.println("--- facultys " + facultys.size());

        Set<Course> courses = new HashSet<>();
        courses.add(course);

        Offered offer = new Offered(null, facultys, courses, time, day, section, roomNo);

        Session session = null;
        Transaction transaction = null;
        try {

            session = SingletonFactory.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(offer);
            transaction.commit();
            offers.add(offer);
            clearField();

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Yeah Information Added");
            alert.setContentText("Successfully Added New Course Information");

            Optional<ButtonType> result = alert.showAndWait();

        } catch (Exception e) {

            System.err.println(e);
            if (transaction != null) {
                try {
                    if (!transaction.wasCommitted()) {
                        transaction.rollback();
                    }
                } catch (Exception ex) {

                }

            }
        } finally {
            session.close();
        }
    }

    @FXML
    private void handleLogoutAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(root);

            SupportSystem.getMainStage().setScene(scene);
            SupportSystem.getMainStage().show();
        } catch (IOException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleCourseSaveAction(ActionEvent event) {
        String code = codeField.getText();
        String title = titleField.getText();
        int credits = Integer.parseInt(creditsField.getText());

        Course course = new Course(code, title, credits);

        Session session = null;
        Transaction transaction = null;
        try {
            session = SingletonFactory.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(course);
            System.out.println(course);
            transaction.commit();
            Courses.add(course);
            clearField();
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Yeah Information Added");
            alert.setContentText("Successfully Added New Course Information");

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

    public void clearField() {
        teachInitField.clear();
        teachNameField.clear();
        teachEmailField.clear();
        teachQualiField.clear();
        teachSexField.clear();
        teachOccuptionField.clear();
        teachNumField.clear();
        teachCitizenshipField.clear();

        codeField.clear();
        titleField.clear();
        creditsField.clear();

        teacherCombo.getSelectionModel().clearSelection();
        codeCombo.getSelectionModel().clearSelection();
        TimeCombo.getSelectionModel().clearSelection();

        DayCombo.getSelectionModel().clearSelection();

        roomCombo.getSelectionModel().clearSelection();
        sectionCombo.getSelectionModel().clearSelection();
    }

    @FXML
    private void handleTeacherSaveAction(ActionEvent event) {
        String techInit = teachInitField.getText();
        String techName = teachNameField.getText();
        String techEmail = teachEmailField.getText();
        String techQualifiaction = teachQualiField.getText();
        String techSex = teachSexField.getText();
        String techOccuption = teachOccuptionField.getText();
        String techNumber = teachNumField.getText();
        String techCitizenship = teachCitizenshipField.getText();

        Faculty faculty = new Faculty(techInit, techName,
                new Faculty_Address(techEmail, techNumber, techOccuption, techCitizenship, techSex, techQualifiaction));

        Session session = null;
        Transaction transaction = null;
        try {
            session = SingletonFactory.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(faculty);
            System.out.println(faculty);
            transaction.commit();
            facultys.add(faculty);
            clearField();
            Alert alert = new Alert(AlertType.CONFIRMATION);
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

    @FXML
    private void handleCourseListAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("CourseList.fxml"));
            Scene scene = new Scene(root);

            SupportSystem.getMainStage().setScene(scene);
            SupportSystem.getMainStage().show();
        } catch (IOException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleTeacherListAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Teacher_List.fxml"));
            Scene scene = new Scene(root);

            SupportSystem.getMainStage().setScene(scene);
            SupportSystem.getMainStage().show();
        } catch (IOException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleOfferedListAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("OfferedList.fxml"));
            Scene scene = new Scene(root);

            SupportSystem.getMainStage().setScene(scene);
            SupportSystem.getMainStage().show();
        } catch (IOException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
