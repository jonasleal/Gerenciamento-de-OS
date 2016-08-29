/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dados.dao;

import java.util.List;
import model.entidades.Cliente;

/**
 *
 * @author JonasJr
 */
public class DaoCliente extends DAO {
    
    private Cliente validar(Object object) throws DaoException{
        if ((object == null) || !(object instanceof Cliente)) {
            throw new DaoException("Objeto não é valido.");
        }
        Cliente cliente = null;
        cliente = (Cliente) object;
        if (!cliente.validar()) {
            throw new DaoException("Cliente não é valido");
        }
        return cliente;
    }

    @Override
    public Object cadastrar(Object object) throws DaoException {
        Cliente cliente = validar(object);
        
        try{
        manager.getTransaction().begin();
        manager.persist(cliente);
        manager.getTransaction().commit();
        }catch(Exception e){
            throw new DaoException(e.getMessage(),e.getCause());
        }
        return cliente;
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
