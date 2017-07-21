/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.dao;

import co.edu.udea.model.Vehicle;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author camilo
 */
@Local
public interface VehicleDaoLocal {

    void add(Vehicle vehicle);

    void update(Vehicle vehicle);

    void remove(String licensePlate);

    Vehicle get(String licensePlate);

    List<Vehicle> getAll();
    
}
