/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.dao;

import co.edu.udea.model.Student;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Duban Camilo Bedoya - dcamilobj@gmail.com
 */
@Local
public interface StudentDaoLocal {

    void addStudent(Student student);

    void editStudent(Student student);

    void deleteStudent(String studentId);

    Student getStudent(String studentId);

    List<Student> getAllStudents();
    
}
