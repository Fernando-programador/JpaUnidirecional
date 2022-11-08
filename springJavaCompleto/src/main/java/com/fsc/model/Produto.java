package com.fsc.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;



@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nome;
	
	@Min(value = 0)
	private double preco;
	
	@Min(value = 0)
	@Max(value = 2)
	private double desconto;
	
	public Produto() {
		
	}



	public Produto(Long id, @NotBlank String nome, @Min(0) @NotBlank double preco, @Min(0) @Max(2) double desconto) {
		
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.desconto = desconto;
	}



	public Produto(@NotBlank String nome, @Min(0) @NotBlank double preco, @Min(0) @Max(2) double desconto) {
	
		this.nome = nome;
		this.preco = preco;
		this.desconto = desconto;
	}



	public double getPreco() {
		return preco;
	}



	public void setPreco(double preco) {
		this.preco = preco;
	}



	public double getDesconto() {
		return desconto;
	}



	public void setDesconto(double desconto) {
		this.desconto = desconto;
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
	
	

}
