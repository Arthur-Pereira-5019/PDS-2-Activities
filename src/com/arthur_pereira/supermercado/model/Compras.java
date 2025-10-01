package com.arthur_pereira.supermercado.model;

public class Compras {
	Produto produto;
	Integer quantidade;
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Compras(Produto produto, Integer quantidade) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
	}
	public Compras() {
		super();
	}
	
	
	
	
	
}
