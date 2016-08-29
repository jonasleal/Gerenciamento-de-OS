/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author JonasJr
 */
@Entity
public  class Pessoa implements Serializable{
    @Id
    private long cpf;
    private String nome;

    public Pessoa() {
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public boolean validar(){
        if(this.nome.isEmpty() || this.nome == null){
            return false;
        }
        
        if(!validarCPF()){
            return false;
        }
        
        return true;
    }

    public boolean validarCPF() {
        String cpf = String.valueOf(this.cpf);
        if (cpf.equals("00000000000") || cpf.equals("11111111111")
                || cpf.equals("22222222222") || cpf.equals("33333333333")
                || cpf.equals("44444444444") || cpf.equals("55555555555")
                || cpf.equals("66666666666") || cpf.equals("77777777777")
                || cpf.equals("88888888888") || cpf.equals("99999999999")) {
            return false;
        }

        char dig10, dig11;
        int soma, num, resul, peso;

        try {
            soma = 0;
            peso = 10;
            
            for(int i = 0; i<9; i++){
                num = (int) (cpf.charAt(i) - 48);
                soma += (num * peso);
                peso--;
            }
            
            resul = 11 - (soma % 11);
            if((resul == 10) || (resul == 11)){
                dig10 = '0';
            }else{
                dig10 = (char) (resul+48);
            }
            
            soma = 0;
            peso = 11;
            
            for(int i = 0; i< 10; i++){
                num = (int) (cpf.charAt(i) - 48);
                soma += (num *peso);
                peso--;
            }
            
            resul = 11 - ( soma % 11);
            if((resul == 10) || (resul == 11)){
                dig11 = '0';
            }else{
                dig11 = (char) (resul + 48);
            }
            
            if((cpf.charAt(9) == dig10) &&
                   (cpf.charAt(10) == dig11)){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            return (false);
        }
                
    }

}
