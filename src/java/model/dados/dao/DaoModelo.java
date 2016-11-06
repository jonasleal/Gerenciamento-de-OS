/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dados.dao;

import model.dados.hibernate.HibernateUtil;
import model.entidades.Modelo;
import model.exception.DaoException;

/**
 *
 * @author JonasJr
 */
public class DaoModelo extends DAO {

    @Override
    public Object recuperar(Long id) throws DaoException {
        manager = HibernateUtil.getManager();
        try {
            return manager.find(Modelo.class, id);
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        } finally {
            manager.close();
        }
    }

}
