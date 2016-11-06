/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.ClienteModel;
import model.Model;
import model.Sistema;
import model.entidades.Cliente;
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
public class ControllerCliente {
        private final Model<Cliente> modelCliente;
        

    public ControllerCliente() {
    modelCliente = new ClienteModel();
    }
        
        
        public void cadastrarCliente(Cliente cliente) {
        
        try {
            String confSenha = FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("confSenha").toString();
            Sistema.confirmarSenha(cliente.getSenha(), confSenha);
            modelCliente.cadastrar(cliente);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastrado com sucesso."));
            limparDados();
        } catch (ObjetoInvalidoException | DaoException | SenhaInvalidaException ex) {
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
            Cliente cliente = (Cliente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cliente");
            cliente.addTelefone(telefone);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cliente", cliente);
        } catch (Exception ex) {
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Telefone invalido: ",ex.getMessage()));
        }
    }
    
    public void removerTelefone(Telefone telefone){
        Cliente cliente = (Cliente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cliente");
            cliente.removerTelefone(telefone);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cliente", cliente);
    }
    public void limparDados(){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("cliente");
    }

    public List<Cliente> listarTudo() throws DaoException {
        Model<Cliente> modeloModel = new ClienteModel();
        return modeloModel.listarTudo();
    }

    
    
}
