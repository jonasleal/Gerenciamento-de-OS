/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constantes;

/**
 *
 * @author JonasJr
 */
public enum Nivel {
    Cliente("Cliente",0),
    Funcionario("Funcionario", 1),
    Gerente("Gerente", 2),
    Admin("Admin", 5);
    
    
    private final String nome;
    private final Integer nivel;
    
    Nivel(String nome, Integer nivel){
        this.nome = nome;
        this.nivel = nivel;
    }

    public String getNome() {
        return nome;
    }


    public Integer getNivel() {
        return nivel;
    }
//
//    public String get(Integer nivel){
//        String saida = null;
//        switch(nivel){
//            case 0:
//                saida = Cliente.nome;
//                break;
//            case 1:
//                saida = Funcionario.getNome();
//                break;
//            case 2:
//                saida = Gerente.getNome();
//                break;
//            case 5:
//                saida = Admin.getNome();
//                break;
//        }
//        return saida;
//        
//    }
//    public Integer get(String nome){
//        Integer saida = null;
//        switch(nome){
//            case "Cliente":
//                saida = Cliente.getNivel();
//                break;
//            case "Funcionario":
//                saida = Funcionario.getNivel();
//                break;
//            case "Gerente":
//                saida = Gerente.getNivel();
//                break;
//            case "Admin":
//                saida = Admin.getNivel();
//                break;
//        }
//        return saida;
//        
//    }
    
    
}
