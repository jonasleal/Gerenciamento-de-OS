/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import model.dados.dao.DaoPessoa;
import model.entidades.Pessoa;
import model.entidades.Telefone;
import model.exception.CpfInvalidoException;
import model.exception.DaoException;
import model.exception.ObjetoInvalidoException;
import model.validacao.CPF;

/**
 *
 * @author JonasJr
 */
public class PessoaModel extends Model {

    public PessoaModel() {
        dao = new DaoPessoa();
    }

    @Override
    public Object cadastrar(Object t) throws DaoException, ObjetoInvalidoException {
        validar(t);
        Pessoa pessoa;

        try {
            pessoa = (Pessoa) t;
        } catch (Exception ex) {
            throw new ObjetoInvalidoException("Tipo invalido.");
        }
        pessoa = (Pessoa) dao.cadastrar(pessoa);
        if (pessoa.getTelefone().size() > 0) {
            Model<Telefone> modelTelefone = new TelefoneModel();
            List<Telefone> listaTel = pessoa.getTelefone();
            for (Telefone tel : listaTel) {
                tel.setProprietaro(pessoa);
                modelTelefone.cadastrar(tel);
            }
            pessoa.setTelefone(listaTel);
        }
        return pessoa;

    }

    @Override
    public Object recuperar(Long cpfl) throws DaoException, ObjetoInvalidoException {

        try {
            CPF.validarCPF(cpfl);
        } catch (CpfInvalidoException ex) {
            throw new ObjetoInvalidoException(ex.getMessage());
        }

        Pessoa pessoa = (Pessoa) dao.recuperar(cpfl);

        return pessoa;
    }

    @Override
    public boolean validar(Object t) throws ObjetoInvalidoException {
        if (t == null) {
            throw new ObjetoInvalidoException("Pessoa não pode ser nula.");

        }
        try {
            Pessoa pessoa = (Pessoa) t;
            CPF.validarCPF(pessoa.getCpf());
            if (pessoa.getNome() == null || pessoa.getNome().isEmpty()) {
                throw new ObjetoInvalidoException("Nome é obrigatorio");
            }
            return true;
        } catch (ObjetoInvalidoException | CpfInvalidoException ex) {
            throw new ObjetoInvalidoException(ex.getMessage());
        }
    }

    public Pessoa buscarPorCpf(long cpf) throws DaoException {
        String hql = "FROM Pessoa p WHERE cpf = :p1";
        return (Pessoa) dao.buscar(cpf, hql);
    }

    @Override
    public List<Pessoa> listarTudo() throws DaoException {
        return dao.listarTudo("FROM Pessoa");
    }

}
