package com.fsc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Entity
@Table(name = "pessoa")
public class Familia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private Integer idade;

	private String cpf;

	public Familia() {
		
	}

	public Familia(Long id, String nome, Integer idade, String cpf) {
		
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
	}

	public Familia(String nome, Integer idade, String cpf) {
		
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
public String toString() {
	return "Família [Meu nome é " + nome + " eu tenho " + " anos e meu CPF é: " + cpf + " ]";
}
	
}
