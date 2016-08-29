/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dados.dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.dados.hibernate.HibernateUtil;

/**
 *
 * @author JonasJr
 */
public abstract class DAO implements DaoInterface{

    EntityManager manager;
    
    public DAO(){
        manager = HibernateUtil.getManager();
    }
    
    @Override
    public abstract Object cadastrar(Object object) throws DaoException;

    @Override
    public abstract Object alterar(Object object) throws DaoException;

    @Override
    public abstract Object recuperar(Integer id) throws DaoException ;

    @Override
    public abstract Object deletar(Object object) throws DaoException;

    @Override
    public abstract List listarTudo(Object object) throws DaoException;
    
}
