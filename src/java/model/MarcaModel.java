/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import model.dados.dao.DaoMarca;
import model.entidades.Marca;
import model.exception.DaoException;
import model.exception.ObjetoInvalidoException;

/**
 *
 * @author JonasJr
 */
public class MarcaModel extends Model {

    public MarcaModel() {
        dao = new DaoMarca();
    }

    @Override
    public boolean validar(Object t) throws ObjetoInvalidoException {
        if (t == null) {
            throw new ObjetoInvalidoException("Marca não pode ser nula.");
        }
        Marca marca = (Marca) t;
        if (marca.getNome() == null || marca.getNome().isEmpty()) {
            throw new ObjetoInvalidoException("Nome é obrigatorio");
        }
        return true;

    }

    @Override
    public List listarTudo() throws DaoException {
        return dao.listarTudo("FROM Marca");
    }


}
