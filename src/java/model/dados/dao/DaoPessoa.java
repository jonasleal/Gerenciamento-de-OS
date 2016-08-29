/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dados.dao;

import java.util.List;
import model.entidades.Pessoa;

/**
 *
 * @author JonasJr
 */
public class DaoPessoa extends DAO{
    private Pessoa validar(Object object) throws DaoException{
        if(object == null || !(object instanceof Pessoa)){
            throw new DaoException("Objeto não é valido.");
        }
        
        Pessoa pessoa = null;
        pessoa = (Pessoa) object;
        if(!pessoa.validar()){
            throw new DaoException("Pesso não é valida");
        }
        return pessoa;
    }
    @Override
    public Object cadastrar(Object object) throws DaoException {
        Pessoa pessoa = validar(object);
        
        manager.getTransaction().begin();
        manager.persist(pessoa);
        manager.getTransaction().commit();
        return pessoa;
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
