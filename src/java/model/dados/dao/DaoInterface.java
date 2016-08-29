/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dados.dao;

import java.util.List;

/**
 *
 * @author JonasJr
 */
public interface DaoInterface {
    public Object cadastrar(Object object)throws DaoException;
    public Object alterar(Object object) throws DaoException;
    public Object recuperar(Integer id) throws DaoException;
    public Object deletar(Object object) throws DaoException;
    public List listarTudo(Object object) throws DaoException;
    
    
}
