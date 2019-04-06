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
    private Date date;
    
    private String clienteID;
    private String veiculoID;
    private String tipoID;

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
    
    public Cliente getClienteEasy(){
        String sql = "select u from Cliente u where u.id=" + this.clienteID;
        try {
            return (Cliente) ManagerDao.getCurrentInstance().read(sql, Cliente.class).get(0);
        } catch (IndexOutOfBoundsException in) {
            return null;
        }
    }
    
    public Veiculo getVeiculoEasy(){
        String sql = "select u from Veiculo u where u.id=" + this.veiculoID;
        try {
            return (Veiculo) ManagerDao.getCurrentInstance().read(sql, Veiculo.class).get(0);
        } catch (IndexOutOfBoundsException in) {
            return null;
        }
    }
    
    public TipoLavagem getTipoEasy(){
        String sql = "select u from TipoLavagem u where u.id=" + this.tipoID;
        try {
            return (TipoLavagem) ManagerDao.getCurrentInstance().read(sql, TipoLavagem.class).get(0);
        } catch (IndexOutOfBoundsException in) {
            return null;
        }
    }

    public void alterar() {
        Cliente c = getClienteEasy();
        Veiculo v = getVeiculoEasy();
        TipoLavagem t = getTipoEasy();
        this.selLavagem.setCliente(c);
        this.selLavagem.setVeiculo(v);
        this.selLavagem.setTipoLavagem(t);
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

    public String getClienteID() {
        return clienteID;
    }

    public void setClienteID(String clienteID) {
        this.clienteID = clienteID;
    }

    public String getVeiculoID() {
        return veiculoID;
    }

    public void setVeiculoID(String veiculoID) {
        this.veiculoID = veiculoID;
    }

    public String getTipoID() {
        return tipoID;
    }

    public void setTipoID(String tipoID) {
        this.tipoID = tipoID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
        this.lavagem.setHoraEntrada(this.date.getMinutes());
    }
    
    

}
