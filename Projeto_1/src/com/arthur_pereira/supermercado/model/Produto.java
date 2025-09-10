package com.arthur_pereira.supermercado.model;
import com.arthur_pereira.supermercado.service.BancoDeDados;

public class Produto {


	String nome;
	Float preço;
	Long id;
	int quantidade;
	
	public Produto(String nome, Float preço, Long id) {
		super();
		this.nome = nome;
		this.preço = preço;
		this.id = id;
	}
	
	public Produto(String nome, Float preço, Long id, int quantidade) {
		super();
		this.nome = nome;
		this.preço = preço;
		this.id = id;
		this.quantidade = quantidade;
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
