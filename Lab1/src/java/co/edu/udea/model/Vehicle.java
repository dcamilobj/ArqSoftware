/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Duban Camilo Bedoya - dcamilobj@gmail.com
 */
@Entity
@Table
@NamedQueries(
 @NamedQuery(name = "Vehicle.getAll", query = "SELECT v FROM Vehicle v"))
public class Vehicle implements Serializable {
    
    /**
     * POJO Attributes
     */
    @Id
    @Column
    private String licensePlate;
    @Column
    private String brand;
    @Column 
    private String color;
    @Column
    private int price;
    @Column
    private byte[] image;

    /**
     * Constructor
     * @param licensePlate
     * @param brand
     * @param color
     * @param price
     * @param image 
     */
    public Vehicle(String licensePlate, String brand, String color, int price, byte[] image) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.image = image;
    }
    
    /**
     * Constructor
     */
    public Vehicle(){}

    /**
     * @return the licensePlate
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * @param licensePlate the licensePlate to set
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the image
     */
    public byte[] getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(byte[] image) {
        this.image = image;
    }
    
    
}
