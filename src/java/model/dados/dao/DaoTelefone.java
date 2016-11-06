/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dados.dao;

import model.dados.hibernate.HibernateUtil;
import model.entidades.Telefone;
import model.exception.DaoException;

/**
 *
 * @author JonasJr
 */
public class DaoTelefone extends DAO {

    @Override
    public Object recuperar(Long id) throws DaoException {
        manager = HibernateUtil.getManager();
        try {
            return manager.find(Telefone.class, id);
        } catch (Exception ex) {
            throw new DaoException(ex.getMessage());
        } finally {
            manager.close();
        }
    }

}
