/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.dados.dao.DAO;
import model.dados.dao.DaoCliente;
import model.dados.dao.DaoEquipamento;
import model.exception.DaoException;
import model.dados.dao.DaoOrdemServico;
import model.dados.dao.DaoPessoa;
import model.entidades.Cliente;
import model.entidades.Equipamento;
import model.entidades.OrdemServico;
import model.entidades.Pessoa;

/**
 *
 * @author JonasJr
 */
public class teste {

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setCpf(10654901430L);
        cliente.setNome("Jonas Ferreira Leal Junior");

        Equipamento equipamento = new Equipamento();
        equipamento.setCliente(cliente);
        equipamento.setNumeroSerie("abcd-1234");

        OrdemServico os = new OrdemServico(equipamento);

        DAO daoCliente = new DaoCliente();
        DAO daoEquipamento = new DaoEquipamento();
        DAO daoOrdemServico = new DaoOrdemServico();
        DaoPessoa daoPessoa = new DaoPessoa();
        Pessoa p = null;
        try {
            daoCliente.cadastrar(cliente);
            daoEquipamento.cadastrar(equipamento);
            daoOrdemServico.cadastrar(os);
            p = (Pessoa) daoPessoa.recuperar(10654901430L);
        } catch (DaoException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(p.getNome());
    }
}
