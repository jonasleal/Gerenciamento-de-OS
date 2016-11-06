/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import model.dados.dao.DAO;
import model.exception.DaoException;
import model.exception.ObjetoInvalidoException;


public abstract class Model<T> implements ModelInterface<T> {

    protected DAO<T> dao;

    public Model() {

    }

    @Override
    public T cadastrar(T t) throws DaoException, ObjetoInvalidoException {
        validar(t);
        return (T) dao.cadastrar(t);
    }

    @Override
    public T recuperar(Long id) throws DaoException, ObjetoInvalidoException {
        return (T) dao.recuperar(id);
    }

    @Override
    public T atualizar(T t) throws DaoException, ObjetoInvalidoException {
        validar(t);
        return (T) dao.alterar(t);
    }

    @Override
    public T deletar(T t) throws DaoException {
        return (T) dao.deletar(t);

    }

    @Override
    public abstract boolean validar(T t) throws ObjetoInvalidoException;

    public abstract List<T> listarTudo() throws DaoException;
}
