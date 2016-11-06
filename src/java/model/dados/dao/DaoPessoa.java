/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dados.dao;

import model.exception.DaoException;
import model.dados.hibernate.HibernateUtil;
import model.entidades.Pessoa;

/**
 *
 * @author JonasJr
 */
public class DaoPessoa extends DAO {

    @Override
    public Object recuperar(Long id) throws DaoException {
        manager = HibernateUtil.getManager();
        try {
            return manager.find(Pessoa.class, id);
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        } finally {
            manager.close();
        }}

    

}
