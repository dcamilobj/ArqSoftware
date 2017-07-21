/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.dao;

import co.edu.udea.model.Vehicle;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Duban Camilo Bedoya - dcamilobj@gmail.com
 */
@Stateless
public class VehicleDao implements VehicleDaoLocal {

    /**
     * Traer contexto del Entity Manager
     */
    @PersistenceContext
    private EntityManager em;
    
    /**
     * Método para agregar un vehículo al sistema
     * @param vehicle 
     */
    @Override
    public void add(Vehicle vehicle) {
        em.persist(vehicle);
        em.flush();
    }

    /**
     * Método para actualizar la información de un vehículo
     * @param vehicle 
     */
    @Override
    public void update(Vehicle vehicle) {
        em.merge(vehicle);
        em.flush();
    }

    /**
     * Método para eliminar un vehículo del sistema
     * @param licensePlate 
     */
    @Override
    public void remove(String licensePlate) {
        em.remove(get(licensePlate));
        em.flush();
    }

    /**
     * Método para obtener un vehículo dada su matricula
     * @param licensePlate
     * @return un vehículo
     */
    @Override
    public Vehicle get(String licensePlate) {
        em.flush();
        return em.find(Vehicle.class, licensePlate);
    }

    /**
     * Método para obtener todos los vehículos
     * @return todos los vehículos en el sistema 
     */
    @Override
    public List<Vehicle> getAll() {
        em.flush();
        return em.createNamedQuery("Vehicle.getAll").getResultList();
    }
    
    
    
    
}
