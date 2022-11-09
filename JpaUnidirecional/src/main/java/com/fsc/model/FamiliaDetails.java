package com.fsc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pertences")
public class FamiliaDetails {

	@Id
	private Long id;

	@Column(name = "carro")
	private String carro;

	@Column(name = "profissao")
	private String profissao;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "familia_Id")
	private Familia familia;

	public FamiliaDetails() {

	}

	public FamiliaDetails(String carro, String profissao) {
		super();
		this.carro = carro;
		this.profissao = profissao;
	}

	public String getCarro() {
		return carro;
	}

	public void setCarro(String carro) {
		this.carro = carro;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

}
