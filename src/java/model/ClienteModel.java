/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.dados.repositorio.RepositorioCliente;
import model.entidades.Cliente;

/**
 *
 * @author JonasJr
 */
public class ClienteModel {
    
    RepositorioCliente rep = null;

    public ClienteModel() {
    rep = RepositorioCliente.criarRepositorio();
    }
    
    
    
    public void cadastrar(Cliente cliente){
        if(cliente.getNome() != null){
            rep.cadastrar(cliente);
        }
    }
    public void alterar(Cliente cliente){
        rep.alterar(cliente);
    }
    public Cliente buscarNome(String nome){
        return rep.recuperar(nome);
    }
    public void deletar(Cliente cliente){
        rep.deletar(cliente);
    }
}
