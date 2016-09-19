/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.PessoaModel;
import model.entidades.Pessoa;
import model.exception.DaoException;
import model.exception.PessoaInvalidaException;

/**
 *
 * @author JonasJr
 */
@ManagedBean
@RequestScoped
public class CadastrarPesso {
    private String nome,msg;
    private Long cpf;
    private PessoaModel pessoaModel;
    /**
     * Creates a new instance of CadastrarPesso
     */
    public CadastrarPesso() {
        pessoaModel = new PessoaModel();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }
    
    private void limparDados(){
        nome = null;
        cpf = null;
    }
    
    public void cadastrarPessoa(){
    
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setCpf(cpf);
        try {
            pessoaModel.cadastrar(pessoa);
            msg = " Cadastrado com sucesso";
            limparDados();;
        } catch (PessoaInvalidaException ex) {
            msg = "Erro: " + ex.getMessage();
        } catch (DaoException ex) {
            msg = "Erro: " + ex.getMessage();
        }
        
    }
    
}
