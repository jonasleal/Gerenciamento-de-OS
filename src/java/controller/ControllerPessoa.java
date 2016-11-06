/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Model;
import model.PessoaModel;
import model.Sistema;
import model.entidades.Pessoa;
import model.entidades.Telefone;
import model.exception.DaoException;
import model.exception.ObjetoInvalidoException;
import model.exception.SenhaInvalidaException;

/**
 *
 * @author JonasJr
 */
@ManagedBean
@SessionScoped
public class ControllerPessoa {
    
    private String confSenha;
    private final Model<Pessoa> pessoaModel;

    /**
     * Creates a new instance of CadastrarPesso
     */
    
    public ControllerPessoa() {
        pessoaModel = new PessoaModel();
    }
    
    public void setConfSenha(String confSenha) {
        this.confSenha = confSenha;
    }

    public String getConfSenha() {
        return confSenha;
    }

    public void cadastrarPessoa(Pessoa pessoa) {
        
        try {
            pessoaModel.cadastrar(pessoa);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastrado com sucesso."));
            limparDados();
        } catch (ObjetoInvalidoException | DaoException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro: ",ex.getMessage()));
        }
        
    }
    
    public void addTelefone(Telefone telefone) {
        
        try {
            String numero = telefone.getNumero();
            if (numero == null || numero.isEmpty()) {
                throw new ObjetoInvalidoException("Numero não pode ser vazio.");
            }
            if(numero.length() < 10 || numero.substring(2).length() < 8){
                throw new ObjetoInvalidoException("O numero deve esta no formato DDD + numero e ter no minimo 8 digitos.");
            }
            Pessoa pessoa = (Pessoa) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("pessoa");
            pessoa.addTelefone(telefone);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("pessoa", pessoa);
        } catch (Exception ex) {
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Telefone invalido: ",ex.getMessage()));
        }
    }
    
    public void removerTelefone(Telefone telefone){
        Pessoa pessoa = (Pessoa) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("pessoa");
            pessoa.removerTelefone(telefone);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("pessoa", pessoa);
    }
    public void limparDados(){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("pessoa");
    }
}
