/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.dao;

import co.edu.udea.model.Sale;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author camilo
 */
@Local
public interface SaleDaoLocal {

    void add(Sale sale);

    void update(Sale sale);

    void remove(int idSale);

    Sale get(int idSale);

    List<Sale> getAll();
    
}
