package com.fsc.model;

public class Cliente {
	
	private Integer id;
	private String nome;
	private String cpf;
	
	
	
	
	public Cliente() {
		
	}

	

	public Cliente(String nome, String cpf) {
		
		this.nome = nome;
		this.cpf = cpf;
	}

	

	public Cliente(Integer id, String nome, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
	}




	public void setId(Integer id) {
		this.id = id;
	}



	public Cliente(Integer id, String nome, String cpf, Double preco, Double desconto) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
	
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	

}
