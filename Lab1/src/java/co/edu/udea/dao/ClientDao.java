/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.dao;

import co.edu.udea.model.Client;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Duban Camilo Bedoya - dcamilobj@gmail.com
 */
@Stateless
public class ClientDao implements ClientDaoLocal {

    
    @PersistenceContext
    private EntityManager em;
    /**
     * Método para agregar un cliente al sistema
     * @param client 
     */
    @Override
    public void add(Client client) {
        em.persist(client);
        em.flush();
    }
    /**
     * Método para actualizar la información de un cliente en el sistema
     * @param client 
     */
    @Override
    public void update(Client client) {
        em.merge(client);
        em.flush();
    }

    /**
     * Método para eliminar un cliente del sistema
     * @param idClient 
     */
    @Override
    public void remove(String idClient) {
        em.remove(get(idClient));
        em.flush();
    }

    /**
     * Método para consultar un cliente por su identificación
     * @param idClient
     * @return un cliente
     */
    @Override
    public Client get(String idClient) {
        em.flush();
        return em.find(Client.class, idClient);
    }

    /**
     * Método para consultar los clientes en el sistema
     * @return todos los clientes en el sistema
     */
    @Override
    public List<Client> getAll() {  
        em.flush();
        return  em.createNamedQuery("Client.getAll").getResultList();
    }
    
    
}
