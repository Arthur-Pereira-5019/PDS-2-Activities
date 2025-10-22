package com.arthur_pereira.supermercado.repository;

import java.util.ArrayList;
import java.util.List;

import com.arthur_pereira.supermercado.model.Compra;
import com.arthur_pereira.supermercado.model.Produto;

public class CarrinhoComprasRepository {
	ArrayList<Compra> compras = new ArrayList<Compra>();
	ArrayList<Compra> carrinhoAntigo = new ArrayList<Compra>();
	
	public Compra adicionarCompras(Compra c) {
		/*Compra e = encontrarCompraPeloProduto(c.getProduto());
		if(e != null) {
			e.setQuantidade(e.getQuantidade()+c.getQuantidade());
			compras.set(compras.indexOf(e), e);
		}*/
		
		compras.add(c);
		return c;
	}
	
	public void removerCompras(Compra c) {
		compras.remove(c);
	}
	
	public void removerComprasPeloProduto(Produto p) {
		Compra r = encontrarCompraPeloProduto(p);
		removerCompras(r);
	}
	
	public List<Compra> listarCompras() {
		return new ArrayList<>(compras);
	}
	
	public Compra encontrarCompraPeloProduto(Produto p) {
		Compra retorno = new Compra();
		compras.forEach(c -> {
			if(c.getProduto() == p ) {
			retorno.setProduto(c.getProduto());
			retorno.setQuantidade(c.getQuantidade());
			}
		});
		return retorno;
	}

}
