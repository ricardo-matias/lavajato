/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.controller;

import br.edu.ifpe.recife.model.dao.Finders;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import br.edu.ifpe.recife.model.dao.ManagerDao;
import br.edu.ifpe.recife.model.entities.Cliente;
import br.edu.ifpe.recife.model.entities.Lavagem;
import br.edu.ifpe.recife.model.entities.TipoLavagem;
import br.edu.ifpe.recife.model.entities.Veiculo;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.ws.rs.client.Client;

/**
 *
 * @author marcosbrasil98
 */
@ManagedBean(name = "lavagemController")
@SessionScoped
public class LavagemController implements Serializable {

    private Lavagem lavagem;
    private Lavagem selLavagem;
    private Cliente cliente;
    private TipoLavagem tipoLavagem;
    private Veiculo veiculo;
    private Finders finder;

    public LavagemController() {
        this.lavagem = new Lavagem();
        this.finder = new Finders();
    }

    public void inserir() {

        //Date data = new Date();
        //this.lavagem.setData(data);
        ManagerDao.getCurrentInstance().insert(this.lavagem);
        this.lavagem = new Lavagem();

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Lavagem Cadastrada com sucesso!"));

    }

    public void alterar() {
        ManagerDao.getCurrentInstance().update(this.selLavagem);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("A lavagem foi alterada com sucesso!"));

    }

    public List<Lavagem> lerTudo() {
        return ManagerDao.getCurrentInstance().read("select l from Lavagem l", Lavagem.class);
    }

    public void deletar() {
        ManagerDao.getCurrentInstance().delete(this.selLavagem);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Lavagem deletada com sucesso!"));

    }

    public Lavagem getLavagem() {
        return lavagem;
    }

    public void setLavagem(Lavagem lavagem) {
        this.lavagem = lavagem;
    }

    public Lavagem getSelLavagem() {
        return selLavagem;
    }

    public void setSelLavagem(Lavagem selLavagem) {
        this.selLavagem = selLavagem;
    }

    public String getCliente() {
        return "";
    }

    public void setCliente(String id) {
        this.cliente = finder.getClienteById(Integer.parseInt(id));
        this.lavagem.setCliente(this.cliente);
        //this.cliente = new Cliente();
    }

    public String getTipoLavagem() {
        return "";
    }

    public void setTipoLavagem(String id) {
        this.tipoLavagem = finder.getTipoLavagemById(Integer.parseInt(id));
        this.lavagem.setTipoLavagem(this.tipoLavagem);
        //this.tipoLavagem = new TipoLavagem();
    }

    public String getVeiculo() {
        return "";
    }

    public void setVeiculo(String id) {
        this.veiculo = finder.getVeiculoById(Integer.parseInt(id));
        this.lavagem.setVeiculo(this.veiculo);
        //this.veiculo = new Veiculo();
    }
    
    

}
