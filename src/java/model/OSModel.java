/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.dados.repositorio.RepositorioOS;
import model.entidades.OrdemServico;

/**
 *
 * @author JonasJr
 */
public class OSModel {
    private RepositorioOS rep = null;

    public OSModel() {
    rep =new RepositorioOS();
    }
    
    
    
    public void cadastrarOS(OrdemServico os){
        this.rep.cadastar(os);
    }
    
    public OrdemServico buscarOS(int numero){
        return rep.buscar(numero);
    }
    public void alterar(OrdemServico os){
        rep.alterar(os);
    }
    public void remover(OrdemServico os){
        rep.remover(os);
    }
    
}
