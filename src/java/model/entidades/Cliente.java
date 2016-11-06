/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidades;

import constantes.Nivel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import model.exception.CpfInvalidoException;
import model.exception.ObjetoInvalidoException;

/**
 *
 * @author JonasJr
 */
@ManagedBean
@SessionScoped
@Entity
@Table(name = "cliente")
public class Cliente extends Usuario implements Serializable {

    @OneToMany(mappedBy = "cliente", targetEntity = Equipamento.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Equipamento> listaEquipamentos = new ArrayList<>();

    @Override
    public String toString() {
        return super.toString();
    }

    public Cliente() {
        super();

    }

    public Cliente(Long cpf, String senha,String nome, List<Telefone> telefone, Integer nivel) {
        super.setCpf(cpf);
        super.setNome(nome);
        super.setTelefone(telefone);
        super.setSenha(senha);
        if(nivel == null){
            super.setNivel(Nivel.Cliente.getNivel());
        }else{
            super.setNivel(nivel);
        }
    }

    public List<Equipamento> getListaEquipamentos() {
        return listaEquipamentos;
    }

    public void setListaEquipamentos(List<Equipamento> listaEquipamentos) {
        this.listaEquipamentos = listaEquipamentos;
    }

    public Cliente criarCliente() throws ObjetoInvalidoException, CpfInvalidoException {
        return new Cliente(getCpf(), getSenha(), getNome(), getTelefone(), getNivel());
    }
}
