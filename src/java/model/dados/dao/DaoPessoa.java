/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dados.dao;

import model.exception.DaoException;
import java.util.List;
import model.entidades.Pessoa;

/**
 *
 * @author JonasJr
 */
public class DaoPessoa extends DAO{
   
     @Override
    public Object recuperar(long id) throws DaoException {
        try{
            return manager.find(Pessoa.class, id);
        }catch(Exception e){
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    public List listarTudo() throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
