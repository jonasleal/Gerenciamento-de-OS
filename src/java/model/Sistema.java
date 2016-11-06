/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.exception.SenhaInvalidaException;

/**
 *
 * @author JonasJr
 */
public class Sistema {
    public static boolean confirmarSenha(String senha, String conf) throws SenhaInvalidaException{
        if(senha == null || senha.isEmpty() || senha.equals(" ")){
            throw new SenhaInvalidaException("Senha é obrigatoria");
        }
        if(senha.equals(conf)){
            return true;
        }else{
            throw new SenhaInvalidaException("Senhas não combinam.");
        }
    }
}
