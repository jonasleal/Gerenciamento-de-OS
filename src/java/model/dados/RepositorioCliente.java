/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dados;

import java.util.ArrayList;
import java.util.List;
import model.entidades.Cliente;

/**
 *
 * @author JonasJr
 */
public class RepositorioCliente {
    private List<Cliente> clientes = null;
    private static RepositorioCliente rep = null;
    
    public static RepositorioCliente criarRepositorio(){
        if(rep == null){
            RepositorioCliente rep = new RepositorioCliente();
            return rep;
        }
        return rep;
    }
    
    private RepositorioCliente() {
        clientes = new ArrayList<>();
    }
    
    public void cadastrar(Cliente cliente){
        clientes.add(cliente);
    }
    public Cliente recuperar(String nome){
        for(Cliente c : clientes){
            if(c.getNome().equals(nome)){
                return c;
            }
        }
        return null;
    }
    public void alterar(Cliente cliente){
        for(Cliente c : clientes){
            c.setNome(cliente.getNome());
    }
    
    }
    
    public boolean deletar(Cliente cliente){
        return clientes.remove(cliente);
    }
}