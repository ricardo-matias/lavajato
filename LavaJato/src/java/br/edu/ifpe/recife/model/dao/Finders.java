/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.dao;

import br.edu.ifpe.recife.model.entities.Cliente;
import br.edu.ifpe.recife.model.entities.TipoLavagem;
import br.edu.ifpe.recife.model.entities.Veiculo;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author ricardo
 */
public class Finders {

    private Cliente cliente;
    private Veiculo veiculo;
    private TipoLavagem tipoLavagem;

    public Finders() {
        /*this.cliente = new Cliente();
        this.veiculo = new Veiculo();
        this.tipoLavagem = new TipoLavagem();*/
    }

    public Cliente getClienteById(int id) {
        String sql = "select u from Cliente u where u.id=" + id;

        this.cliente = this.findCliente(sql);

        if (this.cliente == null) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Cliente não encontrado"));

            return null;
        }

        return cliente;

    }

    private Cliente findCliente(String sql) {
        try {
            return (Cliente) ManagerDao.getCurrentInstance().read(sql, Cliente.class).get(0);
        } catch (IndexOutOfBoundsException in) {
            return null;
        }
    }
    
    public Veiculo getVeiculoById(int id) {
        String sql = "select u from Veiculo u where u.id=" + id;

        this.veiculo = this.findVeiculo(sql);

        if (this.veiculo == null) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Veiculo não encontrado"));

            return null;
        }

        return veiculo;

    }

    private Veiculo findVeiculo(String sql) {
        try {
            return (Veiculo) ManagerDao.getCurrentInstance().read(sql, Veiculo.class).get(0);
        } catch (IndexOutOfBoundsException in) {
            return null;
        }
    }
    
    public TipoLavagem getTipoLavagemById(int id) {
        String sql = "select u from TipoLavagem u where u.id=" + id;

        this.tipoLavagem = this.findTipoLavagem(sql);

        if (this.tipoLavagem == null) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Usuário não encontrado"));

            return null;
        }

        return tipoLavagem;

    }

    private TipoLavagem findTipoLavagem(String sql) {
        try {
            return (TipoLavagem) ManagerDao.getCurrentInstance().read(sql, TipoLavagem.class).get(0);
        } catch (IndexOutOfBoundsException in) {
            return null;
        }
    }
}
