/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import model.exception.CpfInvalidoException;
import model.exception.ObjetoInvalidoException;
import model.validacao.CPF;

/**
 *
 * @author JonasJr
 */
@Entity
@ManagedBean(name = "pessoa")
@SessionScoped
public class Pessoa implements Serializable {

    @Id
    private Long cpf;
    @Column(nullable = false)
    private String nome;
    @OneToMany(mappedBy = "telefone", targetEntity = Pessoa.class, fetch = FetchType.EAGER)
    private List<Telefone> telefone;

    public Pessoa() {
        telefone = new ArrayList<>();
    }

    public Pessoa(long cpf, String nome, List<Telefone> telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "cpf=" + CPF.cpfToString(cpf) + ", nome=" + nome + ", telefone=" + telefone + '}';
    }

    public Long getCpf() {
        return this.cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Telefone> getTelefone() {
        return telefone;
    }

    public void setTelefone(List<Telefone> telefone) {
        this.telefone = telefone;
    }

    public void addTelefone(Telefone telefone) {
        for (Telefone tel : this.telefone) {
            if (tel.getNumero().equals(telefone.getNumero())) {
                return;
            }
        }
        telefone.setProprietaro(this);
        this.telefone.add(telefone);
    }

    public void removerTelefone(Telefone telefone) {
        this.telefone.remove(telefone);
    }

    public Pessoa criarPessoa() throws ObjetoInvalidoException, CpfInvalidoException {

        return new Pessoa(getCpf(), getNome(), getTelefone());
    }

}
