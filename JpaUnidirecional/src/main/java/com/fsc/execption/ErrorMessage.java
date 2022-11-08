package com.fsc.execption;

import java.util.Date;

public class ErrorMessage {

	private int codigo;
	private Date data;
	private String menssagem;
	private String descricao;

	public ErrorMessage(int codigo, Date data, String menssagem, String descricao) {
		this.codigo = codigo;
		this.data = data;
		this.menssagem = menssagem;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public Date getData() {
		return data;
	}

	public String getMenssagem() {
		return menssagem;
	}

	public String getDescricao() {
		return descricao;
	}
}
