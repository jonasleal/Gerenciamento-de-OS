/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dados.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.dados.hibernate.HibernateUtil;
import model.exception.DaoException;

/**
 *
 * @author JonasJr
 */
public abstract class DAO<T> implements DaoInterface<T>{

    protected EntityManager manager;
    
    public DAO(){
    }
    
    @Override
    public T cadastrar(T object) throws DaoException{
        manager = HibernateUtil.getManager();
        try{
        manager.getTransaction().begin();
        manager.persist(object);
        manager.getTransaction().commit();
        }catch(Exception e){
            throw new DaoException("Não foi cadastrado. " + e.getMessage());
        }finally{
         manager.close();
        }
        return object;
    }

    @Override
    public T alterar(T object) throws DaoException{
        manager = HibernateUtil.getManager();
        try{
            this.manager.getTransaction().begin();
            object = this.manager.merge(object);
            this.manager.getTransaction().commit();
        }catch(Exception e){
            throw  new DaoException("Não foi atualizado " + e.getMessage());
        }finally{
            manager.close();
        }
        return object;
    }

    @Override
    public abstract T recuperar(Long id) throws DaoException ;

    @Override
    public T deletar(T object) throws DaoException{
        manager = HibernateUtil.getManager();
        try{
            this.manager.getTransaction().begin();
            this.manager.remove(object);
            this.manager.getTransaction().commit();
        }catch(Exception e){
            throw new DaoException("Não foi removido " + e.getMessage());
        }finally{
            manager.close();
        }
        return  object;
    }
    /**
     * 
     *  @param  p1 Parametro usado no codigo HQL.
        @param  hql String com codigo HQL para consulta
        @return Se encontrado uma referencia, retorna uma instancia.
     *  @throws model.exception.DaoException
       
        
    */
    public T buscar(Object p1, String hql) throws DaoException{
        manager = HibernateUtil.getManager();
        try{
        Query query = manager.createQuery(hql);
        return (T) query.setParameter("p1", p1).getSingleResult();
        }catch(Exception ex){
            throw  new DaoException(ex.getMessage());
        }finally{
            manager.close();
        }
        }
    
    
    public List<T> listar(Object p1, String hql) throws  DaoException{
        manager = HibernateUtil.getManager();
        try{
        Query query = manager.createQuery(hql);
        return query.setParameter("p1", p1).getResultList();
        }catch(Exception ex){
            throw  new DaoException(ex.getMessage());
        } finally{
            manager.close();
        }
    }
    @Override
    public List<T> listarTudo(String hql) throws DaoException{
        manager = HibernateUtil.getManager();
        try{
        Query query = manager.createQuery(hql);
        return query.getResultList();
        }catch(Exception ex){
            throw  new DaoException(ex.getMessage());
        } finally{
            manager.close();
        }
    }

    
}
