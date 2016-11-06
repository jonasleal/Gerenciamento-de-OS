/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dados.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author JonasJr
 */
public class HibernateUtil {

    private EntityManagerFactory factory;
    private static HibernateUtil hibernateUtil;

    private HibernateUtil() {
        factory = Persistence.createEntityManagerFactory("gerenciadorOS");

    }

    public EntityManagerFactory getFactory() {
        return factory;
    }
    
    public static EntityManager getManager() {
        if(hibernateUtil == null){
            hibernateUtil = new HibernateUtil();
        }
        
        return hibernateUtil.getFactory().createEntityManager();
    }

}
