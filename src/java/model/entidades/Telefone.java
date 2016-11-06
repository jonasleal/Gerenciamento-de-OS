/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidades;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import model.exception.ObjetoInvalidoException;

/**
 *
 * @author JonasJr
 */
@ManagedBean(name = "telefone")
@RequestScoped
@Entity
public class Telefone implements Serializable {

    public static final int RESIDENCIAL = 1, COMERCIAL = 2, CELULAR = 3;

    @Id
    private String numero;
    @Id
    @ManyToOne
    private Pessoa proprietaro;
    private int tipo = CELULAR;

    public Telefone() {
    }

    public Telefone(String numero, int tipo) {
        this.numero = numero;
        if (tipo >= RESIDENCIAL && tipo <= CELULAR) {
            this.tipo = tipo;
        }
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Pessoa getProprietaro() {
        return proprietaro;
    }

    public void setProprietaro(Pessoa proprietaro ){
        this.proprietaro = proprietaro;
    }

    @Override
    public String toString() {
        return "Telefone{ numero=" + numero + ", cliente=" + proprietaro + ", tipo=" + tipo + '}';
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    public Telefone criaTelefone() throws ObjetoInvalidoException {
        return  new Telefone(numero, tipo);
    }

    public int getRESIDENCIAL() {
        return RESIDENCIAL;
    }

    public int getCOMERCIAL() {
        return COMERCIAL;
    }

    public int getCELULAR() {
        return CELULAR;
    }

    
    

}
