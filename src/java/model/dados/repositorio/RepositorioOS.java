/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dados.repositorio;

import java.util.ArrayList;
import java.util.List;
import model.entidades.OrdemServico;

/**
 *
 * @author JonasJr
 */
public class RepositorioOS {
    private List<OrdemServico> ordens = null;
    
    public RepositorioOS(){
        this.ordens = new ArrayList<>();
        
    }
    public void cadastar(OrdemServico os){
        this.ordens.add(os);
    }
    public OrdemServico buscar(int numero){
        for (OrdemServico orden : ordens) {
            if(orden.getNumero() == numero){
                return orden;
            }
        }
        return null;
    }
    public void alterar(OrdemServico os){
        for (OrdemServico orden : ordens) {
            if(orden.getNumero() == os.getNumero()){
                orden.setEquipamento(os.getEquipamento());
                
            }
        }
    } 
    public void remover(OrdemServico os){
        ordens.remove(os);
    }
}
