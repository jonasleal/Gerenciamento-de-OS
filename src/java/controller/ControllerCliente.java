/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.ClienteModel;
import model.entidades.Cliente;

/**
 *
 * @author JonasJr
 */
public class ControllerCliente {
    private ClienteModel  model = null;

    public ControllerCliente() {
    model = new ClienteModel();
    }
    
    
    public void cadastrar(Cliente cliente){
        model.cadastrar(cliente);
    }
    
    public Cliente recuperar(String nome){
        return model.buscarNome(nome);
    }
    public void alterar(Cliente cliente ){
        model.alterar(cliente);
    }
    
    public void deletar(Cliente cliente){
        model.deletar(cliente);
    }
    
}
