/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.dao;

import co.edu.udea.model.Student;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Duban Camilo Bedoya - dcamilobj@gmail.com
 */
@Stateless
public class StudentDao implements StudentDaoLocal {
    
    /**
     * Creamos un Entity Manager para poder acceder a todos sus métodos.
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Implementación de método para agregar un estudiante
     * @param student 
     */
    @Override
    public void addStudent(Student student) {
    /*Agrega la entidad student a la base de datos(No crea una copia de ella)
    por lo que si el objeto a ingresar a la bd ya está hay un conflicto*/
        em.persist(student);
    /*Se usa flush() para sincronizar con la base de datos y los cambios se 
      vean reflejados en ella de inmediato*/
        em.flush();
    }

    /**
     * Implementación de método para actualizar un estudiante
     * @param student 
     */
    @Override
    public void editStudent(Student student) {
       
        /*En caso que el estudiante no tenga foto*/
        if(student.getPhoto() == null)
        {
            Student old = getStudent(student.getId());
            student.setPhoto(old.getPhoto());
        /*Agrega la entidad student a la base de datos(crea una copia de ella)
          por lo tanto si el objeto a ingresar a la bd ya está se encarga de 
          actualizarlo*/
            em.merge(student);
            em.flush();
        }
        else
        {
           em.merge(student);
           em.flush();
        }
    }

    /**
     * Implementación de método para eliminar un estudiante dado su 
     * identificación
     * @param studentId 
     */
    @Override
    public void deleteStudent(String studentId) {
        //Elimina la entidad dada de la base de datos
        em.remove(getStudent(studentId));
        em.flush();
    }

    /**
     * Implementación de método para obtener un estudiante dado su 
     * identificación.
     * @param studentId 
     * @return el estudiante con la identificación dada.
     */
    @Override
    public Student getStudent(String studentId) {
        /*Se invoca a flush antes de que se ejecute una colsulta relacionada con
        los cambios*/
        em.flush();
        /*Se usa find(POJO, clave primaria) para obtener un objeto de la bd*/
        return em.find(Student.class, studentId);
    }

    /**
     * Implementación de método para obtener todos los estudiantes
     * @return lista de estudiantes en el sistema 
     */
    @Override
    public List<Student> getAllStudents() {
        em.flush();
        /*Se usa createNamedQuery para referenciar una consulta puesta en el 
        POJO*/
        return em.createNamedQuery("Student.getAll").getResultList();
    }
    
    
    
    
    
}
