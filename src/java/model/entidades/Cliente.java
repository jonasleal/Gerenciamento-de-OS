/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author JonasJr
 */
@Entity
public class Cliente extends Pessoa implements Serializable{
    
    @OneToMany
    private List<Equipamento> listaEquipamentos;
    
    public Cliente() {
        super();
        listaEquipamentos = new ArrayList<>();
        
    }

    
    
    
    
}
