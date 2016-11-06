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
import model.MarcaModel;
import model.Model;
import model.entidades.Marca;
import model.exception.DaoException;
import model.exception.ObjetoInvalidoException;

/**
 *
 * @author JonasJr
 */
@ManagedBean
@SessionScoped
public class ControllerMarca {
    private final Model<Marca> marcaModel;

    public ControllerMarca() {
         marcaModel = new MarcaModel();
    }
    
    public void cadastrarMarca(Marca marca){
        try {
            marcaModel.cadastrar(marca);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastrado com sucesso."));
            limparDados();
        } catch (DaoException | ObjetoInvalidoException ex) {
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro: ",ex.getMessage()));
        }
    }
    
    public List<Marca> listarTudo(){
        List<Marca> saida = null;
        try {
           saida = marcaModel.listarTudo();
        } catch (DaoException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro: ",ex.getMessage()));
        }
        return saida;
    }
    
    public void limparDados(){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("marca");
    }
    
}
