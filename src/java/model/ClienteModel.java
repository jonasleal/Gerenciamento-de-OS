/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import model.dados.dao.DaoCliente;
import model.entidades.Cliente;
import model.entidades.Pessoa;
import model.entidades.Telefone;
import model.exception.DaoException;
import model.exception.ObjetoInvalidoException;

/**
 *
 * @author JonasJr
 */
public class ClienteModel extends Model {

    public ClienteModel() {
        dao = new DaoCliente();
    }

    @Override
    public Object cadastrar(Object t) throws DaoException, ObjetoInvalidoException {
        validar(t);
        Cliente cliente;

        try {
            cliente = (Cliente) t;
        } catch (Exception ex) {
            throw new DaoException(ex.getMessage());
        }
        cliente = (Cliente) dao.cadastrar(cliente);
        if (cliente.getTelefone().size() > 0) {
            Model<Telefone> modelTelefone = new TelefoneModel();
            List<Telefone> listaTel = cliente.getTelefone();
            for (Telefone tel : listaTel) {
                modelTelefone.cadastrar(tel);
            }
            cliente.setTelefone(listaTel);
        }
        return cliente;
    }

    @Override
    public boolean validar(Object t) throws ObjetoInvalidoException {
        Model<Pessoa> model = new PessoaModel();
        model.validar((Pessoa) t);
        return true;
    }

    public Cliente buscarCPF(long cpf) throws DaoException {
        String hql = "FROM Cliente c WHERE c.cpf = :p1 ";
        return (Cliente) dao.buscar(cpf, hql);
    }

    @Override
    public List listarTudo() throws DaoException {
        return dao.listarTudo("FROM Cliente");
    }

}
