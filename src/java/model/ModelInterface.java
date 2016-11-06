/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.exception.DaoException;
import model.exception.ObjetoInvalidoException;

/**
 *
 * @author JonasJr
 */
public interface ModelInterface<T> {
    
    public T cadastrar(T t)throws DaoException, ObjetoInvalidoException;
    public T recuperar(Long id)throws DaoException, ObjetoInvalidoException;
    public T atualizar(T t) throws DaoException, ObjetoInvalidoException;
    public T deletar(T t)throws DaoException, ObjetoInvalidoException;
    public boolean validar(T t)throws ObjetoInvalidoException;
    
}
