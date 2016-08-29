/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author JonasJr
 */
@Entity
public class OrdemServico implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int numero;
    private Equipamento equipamento;

    public  OrdemServico(){
        
    }
    public OrdemServico(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }
    
    public boolean validar(){
        if(!equipamento.validar()){
            return false;
        }
        return true;
    }
    
}
