/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import model.dados.dao.DaoEquipamento;
import model.entidades.Cliente;
import model.entidades.Equipamento;
import model.entidades.Modelo;
import model.exception.DaoException;
import model.exception.ObjetoInvalidoException;

/**
 *
 * @author JonasJr
 */
public class EquipamentoModel extends Model {

    public EquipamentoModel() {
        dao = new DaoEquipamento();
    }

    @Override
    public Object cadastrar(Object t) throws DaoException, ObjetoInvalidoException {
        
        Equipamento equipamento;
        try {
            equipamento = (Equipamento) t;

        } catch (Exception ex) {
            throw new ObjetoInvalidoException("Tipo invalido");
        }
         
        
        if (equipamento.getModelo().getId() < 1) {
            Model<Modelo> modeloModel = new ModeloModel();
            Modelo modelo = equipamento.getModelo();
            modelo = modeloModel.cadastrar(modelo);
            equipamento.setModelo(modelo);
        }else{
            Model<Modelo> modeloModel = new ModeloModel();
            equipamento.setModelo(modeloModel.recuperar(equipamento.getModelo().getId()));
        }
        
        Model<Cliente> modelCliente = new ClienteModel();
        Cliente cliente = equipamento.getCliente();
        if (modelCliente.recuperar(cliente.getCpf()) == null) {
            modelCliente.cadastrar(cliente);
            equipamento.setCliente(cliente);
        }else{
            equipamento.setCliente(modelCliente.recuperar(equipamento.getCliente().getCpf()));
        }
        validar(t);
        return dao.cadastrar(equipamento);
    }

    @Override
    public boolean validar(Object t) throws ObjetoInvalidoException {
        if (t == null) {
            throw new ObjetoInvalidoException("Equipamento não pode ser nulo.");
        }
        Equipamento equipamento = (Equipamento) t;
        if (equipamento.getCliente() == null) {
            throw new ObjetoInvalidoException("Cliente não pode ser nulo.");
        }
        if (equipamento.getModelo() == null) {
            throw new ObjetoInvalidoException("Modelo não pode ser nulo.");
        }
        Model<Cliente> model = new ClienteModel();

        model.validar(equipamento.getCliente());

        return true;
    }

    @Override
    public List listarTudo() throws DaoException {
        return  dao.listarTudo("FROM Equipamentos");
    }

}
