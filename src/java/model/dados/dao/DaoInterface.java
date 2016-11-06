/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dados.dao;

import model.exception.DaoException;
import java.util.List;

/**
 *
 * @author JonasJr
 */
public interface DaoInterface<T> {
    public Object cadastrar(T object)throws DaoException;
    public Object alterar(T object) throws DaoException;
    public Object recuperar(Long id) throws DaoException;
    public Object deletar(T object) throws DaoException;
    public List listarTudo(String hql) throws DaoException;
    
    
}
