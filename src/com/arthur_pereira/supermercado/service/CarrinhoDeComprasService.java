package com.arthur_pereira.supermercado.service;

import java.util.ArrayList;
import java.util.List;

import com.arthur_pereira.supermercado.model.Compra;
import com.arthur_pereira.supermercado.model.Produto;
import com.arthur_pereira.supermercado.repository.CarrinhoComprasRepository;

public class CarrinhoDeComprasService {
	private CarrinhoComprasRepository cpr = new CarrinhoComprasRepository();
	private List<Compra> carrinhoSecundario;
	
	public Compra adicionarCompra(Compra c) {
		Compra e = procurarCompraPeloProduto(c.getProduto());
		if(e != null) {
			return atualizarCompra(new Compra(c.getProduto(), c.getQuantidade() + e.getQuantidade()));
		}
		return salvarCompra(c);
	}
	
	public Compra procurarCompraPeloProduto(Produto p) {
		return cpr.encontrarCompraPeloProduto(p);
	}
	
	public Compra atualizarCompra(Compra c) {
		Compra o = procurarCompraPeloProduto(c.getProduto());
		removerCompra(o);
		o.setQuantidade(c.getQuantidade());
		return salvarCompra(o);
	}
	
	public void removerCompra(Compra c) {
		cpr.removerCompras(c);
	}
	
	public void removerCompraPeloId(Produto p) {
		cpr.removerCompras(procurarCompraPeloProduto(p));
	}
	
	private Compra salvarCompra(Compra c) {
		return cpr.adicionarCompras(c);
	}
	
	public List<Compra> listarCompras() {
		return cpr.listarCompras();
	}
	
	public void limpar() {
		List<Compra> compras = listarCompras();
		compras.forEach(c -> {
			cpr.removerCompras(c);
		});
	}
	
	public List<Compra> adicionarTodos(List<Compra> compras) {
		compras.forEach(c -> {
			cpr.adicionarCompras(c);
		});
		return compras;
	}
	
	public void atualizarUltimoCarrinho() {
		carrinhoSecundario = listarCompras();
	}
	
	public List<Compra> listarCarrinhoSecundario() {
		return new ArrayList<>(carrinhoSecundario);
	}
}
