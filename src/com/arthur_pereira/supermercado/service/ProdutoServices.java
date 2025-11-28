package com.arthur_pereira.supermercado.service;

import com.arthur_pereira.supermercado.model.Produto;
import com.arthur_pereira.supermercado.repository.ProdutoRepository;
import com.arthur_pereira.supermercado.exceptions.*;

public class ProdutoServices {
	ProdutoRepository pr = new ProdutoRepository();
	
	public Produto encontrarProduto(Long id) {
		try {
			Produto p = pr.find(Long.valueOf(id));
			return p;
		} catch(Exception e) {
			throw new NotFoundException("");
		}
		
	}
	
	public Produto criarProduto(Produto p) {
		if(p.getNome().isBlank()) {
			throw new InvalidDataException("Dê um nome ao seu produto!");
		}
		if(p.getNome().length() > 120) {
			throw new InvalidDataException("Reduza o nome do seu produto!");
		}

		if(p.getPreco().toString().length() > 8) {
			throw new InvalidDataException("Preço demasiadamente longo!");
		}
		if(p.getPreco().toString().split(".")[1].length() > 2) {
			throw new InvalidDataException("Preço mal-formatado!");
		}
		try {
			return pr.add(p);
		} catch (Exception e) {
			throw new UnknownDatabaseError();
		}
	}
	
	public void atualizarProduto() {
		try {
			Produto p = new Produto();
			p.setNome(campoNome.getText());
			p.setPreco(Float.valueOf(campoPreco.getText()));
			p.setQuantidade(Integer.valueOf(campoQuantidade.getText()));
			p.setId(Long.valueOf(campoId.getText()));
			pr.update(p, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deletarProduto() {
		pr.removeById(Long.valueOf(campoId.getText()));
	}
}
