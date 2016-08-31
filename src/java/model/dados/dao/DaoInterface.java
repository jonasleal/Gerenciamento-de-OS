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
public interface DaoInterface {
    public Object cadastrar(Object object)throws DaoException;
    public Object alterar(Object object) throws DaoException;
    public Object recuperar(long id) throws DaoException;
    public Object deletar(Object object) throws DaoException;
    public List listarTudo() throws DaoException;
    
    
}
