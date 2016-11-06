/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import model.dados.dao.DaoModelo;
import model.entidades.Marca;
import model.entidades.Modelo;
import model.exception.DaoException;
import model.exception.ObjetoInvalidoException;

/**
 *
 * @author JonasJr
 */
public class ModeloModel extends Model {

    public ModeloModel() {
        dao = new DaoModelo();
    }

    @Override
    public Object cadastrar(Object t) throws ObjetoInvalidoException, DaoException {
        
        Modelo modelo;
        try {
            modelo = (Modelo) t;
        } catch (Exception ex) {
            throw new ObjetoInvalidoException("Tipo invalido");
        }

        

        if (modelo.getMarca().getId() < 1) {
            Model<Marca> marcaModel = new MarcaModel();
            Marca marca = modelo.getMarca();
            marca = marcaModel.cadastrar(marca);
            modelo.setMarca(marca);

        }else{
            try {
                Model<Marca> marcaModel = new MarcaModel();
                modelo.setMarca(marcaModel.recuperar(modelo.getMarca().getId()));
            } catch (DaoException | ObjetoInvalidoException ex) {

            }
        }
        validar(modelo);
        dao.cadastrar(modelo);
        return modelo;
    }

    @Override
    public boolean validar(Object t) throws ObjetoInvalidoException {
        if (t == null) {
            throw new ObjetoInvalidoException("Modelo não pode ser nulo.");
        }
        Modelo modelo = (Modelo) t;
        if (modelo.getNome() == null || modelo.getNome().isEmpty()) {
            throw new ObjetoInvalidoException("O nome do modelo é obrigatorio.");
        }
        Model<Marca> marcaModel = new MarcaModel();
        return marcaModel.validar(modelo.getMarca());

    }

    @Override
    public List listarTudo() throws DaoException {
        return dao.listarTudo("FROM Modelo");
    }

}
