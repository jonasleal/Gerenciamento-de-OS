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
import model.EquipamentoModel;
import model.Model;
import model.entidades.Equipamento;
import model.exception.DaoException;
import model.exception.ObjetoInvalidoException;

/**
 *
 * @author JonasJr
 */
@ManagedBean
@SessionScoped
public class ControllerEquipamento {
    private final String nomeSession ="equipamento";
    private final Model<Equipamento> model;

    public ControllerEquipamento() {
        model = new EquipamentoModel();
    }

    public void cadastrar(Equipamento equipamento) {
        try {

            model.cadastrar(equipamento);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastrado com sucesso."));
            limparDados();
        } catch (DaoException | ObjetoInvalidoException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro: ", ex.getMessage()));
        }
    }

    public List<Equipamento> listarTudo() throws DaoException {

        return model.listarTudo();
    }

    public void limparDados() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(nomeSession);
    }

}
