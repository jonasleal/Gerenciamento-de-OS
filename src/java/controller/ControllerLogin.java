/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.entidades.Usuario;
import model.exception.AcessoNegadoException;

/**
 *
 * @author JonasJr
 */
@ManagedBean
@SessionScoped
public class ControllerLogin {
    
    public void logIn(Usuario usuario){
        
    }
    
    public void logOut(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
    
    public String permissaoAcesso(Integer nivel){
        try{
            Usuario usuarioLogado;
            usuarioLogado = (Usuario) FacesContext.getCurrentInstance()
                    .getExternalContext().getSessionMap().get("usuarioLogado");
            if(usuarioLogado == null){
                throw new AcessoNegadoException("login.xhtml");
            }
            if(usuarioLogado.getNivel() < nivel){
                throw new AcessoNegadoException("acessoNegado.xhtml");
            }
        }catch(AcessoNegadoException ex){
            return ex.getMessage();
        }
        return null;
    }
}
