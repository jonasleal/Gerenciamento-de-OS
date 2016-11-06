/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidades;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author JonasJr
 */
@Entity
@ManagedBean
@SessionScoped
public class Equipamento implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String numeroSerie;
    @ManyToOne
    private Modelo modelo;
    @ManyToOne
    private Cliente cliente; 

    public Equipamento() {
        this.modelo = new Modelo();
        this.cliente = new Cliente();
    }

    public Equipamento(Long id, String numeroSerie, Modelo modelo, Cliente cliente) {
        this.id = id;
        this.numeroSerie = numeroSerie;
        this.modelo = modelo;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
    

    @Override
    public String toString() {
        return "Equipamento{" + "numeroSerie=" + numeroSerie + ", modelo=" + modelo + ", cliente=" + cliente + '}';
    }
    
    public Equipamento criarEquipamento(){
            return new Equipamento(id, numeroSerie, modelo, cliente);
    }
    
    
    
    
    
}
