/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.OSModel;
import model.entidades.OrdemServico;

/**
 *
 * @author JonasJr
 */
public class ControllerOS {
    
    private OSModel osModel = new OSModel();
    
    private void cadastrarOS(OrdemServico os){
        osModel.cadastrarOS(os);
    }
    private OrdemServico buscarOS(int numero){
        return osModel.buscarOS(numero);
        
    }
    private void alterarOS(OrdemServico os){
        osModel.alterar(os);
    }
    
    private void removerOS(OrdemServico os){
        osModel.remover(os);
    }
    
}
