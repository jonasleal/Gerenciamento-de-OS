/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dados.dao;

import model.exception.DaoException;
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
    public Object cadastrar(Object object) throws DaoException{
        try{
        manager.getTransaction().begin();
        manager.persist(object);
        manager.getTransaction().commit();
        }catch(Exception e){
            throw new DaoException(e.getMessage(),e.getCause());
        }
        return object;
    }

    @Override
    public Object alterar(Object object) throws DaoException{
        try{
            this.manager.getTransaction().begin();
            object = this.manager.merge(object);
            this.manager.getTransaction().commit();
        }catch(Exception e){
            throw  new DaoException("Não foi atualizado " + e.getMessage());
        }
        return object;
    }

    @Override
    public abstract Object recuperar(long id) throws DaoException ;

    @Override
    public Object deletar(Object object) throws DaoException{
        try{
            this.manager.getTransaction().begin();
            this.manager.remove(object);
            this.manager.getTransaction().commit();
        }catch(Exception e){
            throw new DaoException("Não foi removido " + e.getMessage());
        }
        return  object;
    }

    @Override
    public abstract List listarTudo() throws DaoException;
    
}
