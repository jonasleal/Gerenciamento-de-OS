/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.dados.dao.DaoPessoa;
import model.entidades.Pessoa;
import model.exception.DaoException;
import model.exception.PessoaInvalidaException;

/**
 *
 * @author JonasJr
 */
public class PessoaModel {

    private DaoPessoa dao;

    public PessoaModel() {
        dao = new DaoPessoa();
    }

    public Pessoa cadastrar(Pessoa pessoa) throws PessoaInvalidaException, DaoException {
        validar(pessoa);
        try {
            pessoa = (Pessoa) dao.cadastrar(pessoa);

        } catch (DaoException e) {
            throw new DaoException("Não cadastrado.");
        }
        return pessoa;
    }

    public Pessoa recuperar(long cpfl) throws PessoaInvalidaException, DaoException {
        if (!validarCPF(cpfl)) {
            throw new PessoaInvalidaException("CPF é invalido.");
        }
        Pessoa pessoa = (Pessoa) dao.recuperar(cpfl);

        return pessoa;
    }

    public Pessoa atualizar(Pessoa pessoa) throws PessoaInvalidaException, DaoException {
        validar(pessoa);
        try {
            pessoa = (Pessoa) dao.alterar(pessoa);
        } catch (DaoException e) {
            throw new DaoException("Não foi atualizado " + e.getMessage());
        }
        return pessoa;
    }

    public Pessoa deletar(Pessoa pessoa) throws DaoException {
        try {
            pessoa = (Pessoa) dao.deletar(pessoa);
        } catch (DaoException e) {
            throw new DaoException("Não deletado " + e.getMessage());
        }
        return pessoa;
    }

    public boolean validar(Pessoa pessoa) throws PessoaInvalidaException {
        if (pessoa == null) {
            throw new PessoaInvalidaException("Pessoa não pode ser nula.");
        }
        if (!validarCPF(pessoa.getCpf())) {
            throw new PessoaInvalidaException("CPF não é valido.");
        }
        if (pessoa.getNome().isEmpty() || pessoa.getNome() == null) {
            throw new PessoaInvalidaException("Nome é obrigatorio.");
        }

        return true;
    }

    public String cpfToString(Long cpfl) {
        String cpf = String.valueOf(cpfl);
        String cpfFormatado;
        cpfFormatado = cpf.substring(0, 3) + "." + cpf.substring(3, 6)
                + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
        return cpfFormatado;
    }

    public boolean validarCPF(Long cpfl) {
        String cpf = String.valueOf(cpfl);
        if (cpf.equals("00000000000") || cpf.equals("11111111111")
                || cpf.equals("22222222222") || cpf.equals("33333333333")
                || cpf.equals("44444444444") || cpf.equals("55555555555")
                || cpf.equals("66666666666") || cpf.equals("77777777777")
                || cpf.equals("88888888888") || cpf.equals("99999999999")) {
            return false;
        }

        char dig10, dig11;
        int soma, num, resul, peso;

        try {
            soma = 0;
            peso = 10;

            for (int i = 0; i < 9; i++) {
                num = (int) (cpf.charAt(i) - 48);
                soma += (num * peso);
                peso--;
            }

            resul = 11 - (soma % 11);
            if ((resul == 10) || (resul == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (resul + 48);
            }

            soma = 0;
            peso = 11;

            for (int i = 0; i < 10; i++) {
                num = (int) (cpf.charAt(i) - 48);
                soma += (num * peso);
                peso--;
            }

            resul = 11 - (soma % 11);
            if ((resul == 10) || (resul == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (resul + 48);
            }

            if ((cpf.charAt(9) == dig10)
                    && (cpf.charAt(10) == dig11)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return (false);
        }

    }

}
