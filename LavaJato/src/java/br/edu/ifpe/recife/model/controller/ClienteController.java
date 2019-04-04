/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.controller;

import br.edu.ifpe.recife.model.dao.ManagerDao;
import br.edu.ifpe.recife.model.entities.Cliente;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ALUNO
 */

@ManagedBean(name = "clienteController")
@SessionScoped
public class ClienteController {
    private Cliente cliente;
    private Cliente selCliente;
    
    public ClienteController(){
        this.cliente = new Cliente();
    }
    
    public void inserir(){      
        ManagerDao.getCurrentInstance().insert(this.cliente);       
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O cliente " + this.cliente.getNome()+ " deletado com sucesso!")); 
        this.cliente = new Cliente();
    }
    
    public void alterar(){
        ManagerDao.getCurrentInstance().update(this.selCliente);       
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente " + this.cliente.getId()+ " alterado com sucesso!"));       
    }
    
    public List<Cliente> lerTudo(){
        return ManagerDao.getCurrentInstance().read("select c from Cliente c", Cliente.class);
    }
    
    public void deletar(){
        ManagerDao.getCurrentInstance().delete(this.selCliente);       
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O cliente " + this.selCliente.getNome()+ " deletado com sucesso!"));        
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getSelCliente() {
        return selCliente;
    }

    public void setSelCliente(Cliente selCliente) {
        this.selCliente = selCliente;
    }
    
    
}
