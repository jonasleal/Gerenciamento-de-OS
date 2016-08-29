/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dados.dao;

import java.util.List;
import model.entidades.OrdemServico;

/**
 *
 * @author JonasJr
 */
public class DaoOrdemServico extends DAO{
    private OrdemServico validar(Object object) throws DaoException{
        if(object == null || !(object instanceof OrdemServico)){
            throw new DaoException("Objeto não é valido.");
        }
        
        OrdemServico os = null;
        os = (OrdemServico) object;
        if(!os.validar()){
            throw new DaoException("Cliente não é valido.");
        }
        return os;
    }
    
    @Override
    public Object cadastrar(Object object) throws DaoException {
        OrdemServico os = validar(object);
        
        manager.getTransaction().begin();
        manager.persist(os);
        manager.getTransaction().commit();
        return os;
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
