/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.system;

import Model.Course;
import Model.Student;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import static javax.management.Query.value;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author John
 */
public class CordinatorViewController implements Initializable {

    private ObservableList<Course> courses;

    private ObservableList<Student> students;
    @FXML
    private Label label1;
    @FXML
    private JFXTextField codeField;
    @FXML
    private JFXTextField titleField;
    @FXML
    private JFXTextField creditField;
    @FXML
    private JFXTextField courseInfoField;
    @FXML
    private JFXTextField studentInfoField;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private ComboBox<Course> courseCombo;
    @FXML
    private ComboBox<Student> studentCombo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        courses = FXCollections.observableArrayList();
        students = FXCollections.observableArrayList();
        Session session = SingletonFactory.getSessionFactory().openSession();
        List<Course> c = session.createCriteria(Course.class).list();

        List<Student> s = session.createCriteria(Student.class).list();
        courses.addAll(c);
        students.addAll(s);
        
       
        courseCombo.setItems(courses);
        studentCombo.setItems(students);

    }

    @FXML
    private void handleRegistrationAction(ActionEvent event) {
        
        Session session = null;
        Transaction transaction = null;
       
        
        try {
            session = SingletonFactory.getSessionFactory().openSession();
           
              Student student = studentCombo.getSelectionModel().getSelectedItem();
              Course course   = courseCombo.getSelectionModel().getSelectedItem();
      
            student.getCourses().add(course);
            //course.getStudents().add(student);
            
             System.out.println(student);
           System.out.println(course);
          
     
            transaction = session.beginTransaction();
            
            session.save(course);
            session.save(student);
            
            
            transaction.commit();
            //student.addCourse(course);
            //course.addStudent(student);
            
            /*studentCombo.getSelectionModel().clearAndSelect(currentIndex);
            CourseCombo.getSelectionModel().clearAndSelect(currentIndex);
            teacherCombo.getSelectionModel().clearAndSelect(currentIndex);
            label1.setText("Added New Course Successfullly");*/
        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }

    }

    @FXML
    private void handleSubmitAction(ActionEvent event) {
        String code = codeField.getText();
        String titles = titleField.getText();
        Double credits = Double.parseDouble(creditField.getText());

        Course course = new Course(code, titles, credits);

        Session session = null;
        Transaction transaction = null;

        try {
            session = SingletonFactory.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(course);
            transaction.commit();
            courses.add(course);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        codeField.clear();
        titleField.clear();
        creditField.clear();
        label3.setText("Successfully Added New Course");
    }

    @FXML
    private void courseInfoAction(ActionEvent event) {

    }

    @FXML
    private void studentInfoAction(ActionEvent event) {
    }

}
