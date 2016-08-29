/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dados.dao;

import java.util.List;
import model.entidades.Equipamento;

/**
 *
 * @author JonasJr
 */
public class DaoEquipamento extends DAO{
    
    private Equipamento validar(Object object) throws DaoException{
        if(object == null || !(object instanceof Equipamento)){
            throw new DaoException("Objeto não é valido.");
        }
        Equipamento equipamento = null;
        equipamento = (Equipamento) object;
        
        if (!equipamento.validar()) {
            throw new DaoException("Equipamento não é valido.");
        }
        
        return equipamento;
    }
    
    @Override
    public Object cadastrar(Object object) throws DaoException {
        Equipamento equipamento = validar(object);
        
        manager.getTransaction().begin();
        manager.persist(equipamento);
        manager.getTransaction().commit();
        
        return equipamento;
    }

    @Override
    public Object alterar(Object object) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object recuperar(Integer id) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object deletar(Object object) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listarTudo(Object object) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
