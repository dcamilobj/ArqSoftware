/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.dao;

import co.edu.udea.model.Sale;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author camilo
 */
@Stateless
public class SaleDao implements SaleDaoLocal {

    /**
     * Entorno Entity Manager
     */
    @PersistenceContext
    private EntityManager em;
    /**
     * Método para agregar una venta al sistema
     * @param sale 
     */
    @Override
    public void add(Sale sale) {
        em.persist(sale);
        em.flush();
    }

    /**
     * Método para actualizar la información de una venta
     * @param sale 
     */
    @Override
    public void update(Sale sale) {
        em.merge(sale);
        em.flush();
    }

    /**
     * Método para eliminar una venta del sistema dado su id.
     * @param idSale 
     */
    @Override
    public void remove(int idSale) {
        em.remove(get(idSale));
        em.flush();
    }

    /**
     * Método que retorna la venta correspondiente al id dado.
     * @param idSale
     * @return una venta
     */
    @Override
    public Sale get(int idSale) {
        em.flush();
        return em.find(Sale.class, idSale);
    }

    /**
     * Método para obtener todas las ventas en el sistema
     * @return todas las ventas 
     */
    @Override
    public List<Sale> getAll() {
        em.flush();
        return em.createNamedQuery("Sale.getAll").getResultList();
        
    }
    
    
    
}
