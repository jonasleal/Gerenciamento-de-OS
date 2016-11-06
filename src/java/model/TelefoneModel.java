/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import model.dados.dao.DaoTelefone;
import model.entidades.Telefone;
import model.exception.DaoException;
import model.exception.ObjetoInvalidoException;

/**
 *
 * @author JonasJr
 */
public class TelefoneModel extends Model{

    public TelefoneModel() {
    dao = new DaoTelefone();
    }
    
    public Telefone buscarPorCpf(long cpf) throws DaoException{
        String hql = "FROM Telefone t WHERE cliente_cpf = :p1";
        return (Telefone) dao.buscar(cpf, hql);
    }
    

 
    @Override
    public boolean validar(Object t) throws ObjetoInvalidoException {
        if(t == null){
            throw new ObjetoInvalidoException("Telefone não pode ser nulo.");
        }
        Telefone telefone = (Telefone) t;
        if(telefone.getNumero() == null ||telefone.getNumero().isEmpty()){
            throw new ObjetoInvalidoException("Numero invalido.");
        }
        return true;
    }

    @Override
    public List listarTudo() throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
}
