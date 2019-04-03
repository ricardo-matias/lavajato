/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.controller;


import br.edu.ifpe.recife.model.dao.ManagerDao;
import br.edu.ifpe.recife.model.entities.TipoLavagem;
import java.io.Serializable;
import java.util.List;
//import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ALUNO
 */
@ManagedBean(name = "tipoLavagemController")
@SessionScoped
public class TipoLavagemController implements Serializable {
    
    private TipoLavagem tipoLavagemCadastro;
    private TipoLavagem tipoLavagemSelecionado;
    
    public TipoLavagemController(){
        this.tipoLavagemCadastro = new TipoLavagem();
        //this.tipoLavagemSelecionado = new TipoLavagem();
    }
    
    public void inserir(){
        
        ManagerDao.getCurrentInstance().insert(this.tipoLavagemCadastro);
        //this.tipoLavagemCadastro = new TipoLavagem();
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tipo de lavagem " + this.tipoLavagemCadastro.getNome() + " cadastrado com sucesso!"));
        
    }
    
    public void alterar(){
        ManagerDao.getCurrentInstance().update(this.tipoLavagemSelecionado);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O tipo de lavagem de id " + this.tipoLavagemSelecionado.getId() + " foi alterado com sucesso!"));
    }
    
    public List<TipoLavagem> lerTudo(){
        return ManagerDao.getCurrentInstance().read("select l from TipoLavagem l", TipoLavagem.class);
    }
    
    public void deletar(){
        ManagerDao.getCurrentInstance().delete(this.tipoLavagemSelecionado);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O tipo de lavagem " + this.tipoLavagemSelecionado.getNome()+ " deletado com sucesso!"));
        
    }

    public TipoLavagem getTipoLavagemCadastro() {
        return tipoLavagemCadastro;
    }

    public void setTipoLavagemCadastro(TipoLavagem tipoLavagemCadastro) {
        this.tipoLavagemCadastro = tipoLavagemCadastro;
    }

    public TipoLavagem getTipoLavagemSelecionado() {
        return tipoLavagemSelecionado;
    }

    public void setTipoLavagemSelecionado(TipoLavagem tipoLavagemSelecionado) {
        this.tipoLavagemSelecionado = tipoLavagemSelecionado;
    }
    
    
    
}
