/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.exception;

/**
 *
 * @author JonasJr
 */
public class PessoaInvalidaException extends Exception{

    public PessoaInvalidaException(String msg) {
        super(msg);
    }
    public PessoaInvalidaException(String msg , Throwable causa){
        super(msg,causa);
    }
}
