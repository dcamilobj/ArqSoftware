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
 @NamedQuery(name = "Sale.getAll", query = "SELECT s FROM Sale s"))
public class Sale implements Serializable{
    
    /**
     * POJO attributes
     */
    @Id
    @Column
    private int idSale;
    @Column
    private String client;
    @Column
    private String vehicle;

    /**
     * @return the idSale
     */
    public int getIdSale() {
        return idSale;
    }

    /**
     * @param idSale the idSale to set
     */
    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    /**
     * @return the client
     */
    public String getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(String client) {
        this.client = client;
    }

    /**
     * @return the vehicle
     */
    public String getVehicle() {
        return vehicle;
    }

    /**
     * @param vehicle the vehicle to set
     */
    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }
    
    
}
