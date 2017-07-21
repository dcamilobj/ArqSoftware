/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.dao;

import co.edu.udea.model.Client;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author camilo
 */
@Local
public interface ClientDaoLocal {

    void add(Client client);

    void update(Client client);

    void remove(String idClient);

    Client get(String idClient);

    List<Client> getAll();
    
}
