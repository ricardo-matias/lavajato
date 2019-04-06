/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.controller;

import br.edu.ifpe.recife.model.dao.Finders;
import br.edu.ifpe.recife.model.dao.ManagerDao;
import br.edu.ifpe.recife.model.entities.Cliente;
import br.edu.ifpe.recife.model.entities.Lavagem;
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
    private Finders finder;
    
    public ClienteController(){
        this.cliente = new Cliente();
        this.finder = new Finders();
    }
    
    public void inserir(){      
        ManagerDao.getCurrentInstance().insert(this.cliente);       
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O cliente " + this.cliente.getNome()+ " foi cadastrado com sucesso!")); 
        this.cliente = new Cliente();
    }
    
    public void alterar(){
        ManagerDao.getCurrentInstance().update(this.selCliente);       
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente " + this.cliente.getNome()+ " alterado com sucesso!"));       
    }
    
    public List<Cliente> lerTudo(){
        return ManagerDao.getCurrentInstance().read("select c from Cliente c", Cliente.class);
    }
    
    public void deletar(){
        Lavagem l = this.finder.findLavagemByCliente(this.selCliente.getId());
        
        if (l != null) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Usuário não pode ser deletado, há uma lavagem em aberto"));
        }else{
            ManagerDao.getCurrentInstance().delete(this.selCliente);       
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O cliente " + this.selCliente.getNome()+ " deletado com sucesso!"));
        }
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
