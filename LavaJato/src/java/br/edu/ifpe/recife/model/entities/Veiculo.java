/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.entities;

import java.util.Date;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 *
 * @author ALUNO
 */

@Entity
public class Veiculo implements Serializable {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
 
 @Column(nullable=false,length=20)
 private String tipo;
 
 
}
