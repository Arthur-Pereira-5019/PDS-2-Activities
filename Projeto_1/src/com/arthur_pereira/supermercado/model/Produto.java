package com.arthur_pereira.supermercado.model;
import com.arthur_pereira.supermercado.service.BancoDeDados;

public class Produto {


	String nome;
	Float preço;
	Long id;
	
	public Produto(String nome, Float preço, Long id) {
		super();
		this.nome = nome;
		this.preço = preço;
		this.id = BancoDeDados.getBanco().getAndUpdateId();
	}
	
	public Produto() {
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getPreço() {
		return preço;
	}

	public void setPreço(Float preço) {
		this.preço = preço;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

}
