package controller;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Model;
import model.ModeloModel;
import model.entidades.Modelo;
import model.exception.DaoException;
import model.exception.ObjetoInvalidoException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JonasJr
 */
@ManagedBean
@SessionScoped
public class ControllerModelo {

    private final String nomeSession ="modelo";
    private final Model<Modelo> model;

    public ControllerModelo() {
        this.model = new ModeloModel();
    }
    
    public void cadastrarModelo(Modelo modelo) {
        try {
            
            model.cadastrar(modelo);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastrado com sucesso."));
            limparDados();
        } catch (DaoException | ObjetoInvalidoException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro: ", ex.getMessage()));
        }
    }
    
    public List<Modelo> listarTudo() throws DaoException {
        
        return model.listarTudo();
    }
    public void limparDados(){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(nomeSession);
    }
}
