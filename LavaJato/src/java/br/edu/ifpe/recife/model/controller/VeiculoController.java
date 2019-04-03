/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.controller;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import br.edu.ifpe.recife.model.dao.ManagerDao;
import br.edu.ifpe.recife.model.entities.Veiculo;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author ALUNO
 */
@ManagedBean(name = "veiculoController")
@SessionScoped
public class VeiculoController implements Serializable {
   private Veiculo veiculo;
   private Veiculo selVeiculo;
   
   public VeiculoController(){
       this.veiculo = new Veiculo();
   }
   public void inserir(){
        
        
       
        ManagerDao.getCurrentInstance().insert(this.veiculo);
        this.veiculo = new Veiculo();
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veiculo Cadastrado com sucesso!"));
        
        
    }
    
    public void alterar(){
        ManagerDao.getCurrentInstance().update(this.selVeiculo);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O veículo foi alterado com sucesso!"));
        
        
    }
    
    public List<Veiculo> lerTudo(){
        return ManagerDao.getCurrentInstance().read("select l from Veiculo l", Veiculo.class);
    }
    
    public void deletar(){
        ManagerDao.getCurrentInstance().delete(this.selVeiculo);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veiculo deletado com sucesso!"));
        
    }

   
    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Veiculo getSelVeiculo() {
        return selVeiculo;
    }

    public void setSelVeiculo(Veiculo selVeiculo) {
        this.selVeiculo = selVeiculo;
    }
   
}
