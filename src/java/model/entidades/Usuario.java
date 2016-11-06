/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidades;

import constantes.Nivel;
import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author JonasJr
 */
@Entity
public abstract class Usuario extends Pessoa implements Serializable{
    private String senha;
    private Integer nivel;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
    
    public String nivelToString(){
        String saida = null;
        switch(nivel){
            case 0:
                saida = Nivel.Cliente.getNome();
                break;
            case 1:
                saida = Nivel.Funcionario.getNome();
                break;
            case 2:
                saida = Nivel.Gerente.getNome();
                break;
            case 5:
                saida = Nivel.Admin.getNome();
                break;
        }
        return saida;
    }
    
}
