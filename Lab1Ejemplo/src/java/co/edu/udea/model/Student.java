/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.model;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URLConnection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Duban Camilo Bedoya  - dcamilob@gmail.com
 */
@Entity
@Table(name = "Student")
@NamedQueries(
@NamedQuery(name = "Student.getAll", query = "SELECT e FROM Student e"))
public class Student implements Serializable {
   
 /**
  * POJO Attributes
  */   
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 @Column
 private String id;
 @Column
 private String firstName;
 @Column
 private String lastName;
 @Column
 private String level;
 @Column
 private byte[] photo; 

 /**
  * Constructor Method
  * @param studentId
  * @param firstName
  * @param lastName
  * @param level
  * @param photo 
  */
 public Student(String studentId, String firstName, String lastName, String level,
        byte[] photo) {
        this.id = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.level = level;
        this.photo = photo;
    }
 
    /**
     * Another constructor method
     */
    public Student(){}

    /**
     * @return the studentId
     */
    public String getId() {
        return id;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setId(String studentId) {
        this.id = studentId;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the level
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * @return the photo
     */
    public byte[] getPhoto(){
        return photo;
    }

    /**
     * @param photo the photo to set
     */
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
 
    public String getPhotoBase64() throws IOException
    {
        if(photo == null)
            return ""; 
        String mimeType;
        try (InputStream is = new BufferedInputStream(new ByteArrayInputStream(photo))) {
                mimeType = URLConnection.guessContentTypeFromStream(is);
          }
        
        String base64 = DatatypeConverter.printBase64Binary(photo);
        System.out.println("data:" + mimeType + ";base64," + base64);
        return "data:" + mimeType + ";base64," + base64;
    }
 
}
