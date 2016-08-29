/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author JonasJr
 */
@Entity
public class Equipamento implements Serializable{
    @Id
    private int id;
    private String numeroSerie;
    
    @ManyToOne
    private Cliente cliente; 

    public Equipamento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int ordemServico) {
        this.id = ordemServico;
    }
    
    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public boolean validar(){
        if(numeroSerie == null || numeroSerie.isEmpty() || cliente == null){
            return false;
        }
        return true;
    }
    
    
    
}
