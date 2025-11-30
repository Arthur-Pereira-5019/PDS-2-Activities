package com.arthur_pereira.supermercado.service;

import com.arthur_pereira.supermercado.model.Produto;
import com.arthur_pereira.supermercado.repository.ProdutoRepository;

import java.util.List;

import com.arthur_pereira.supermercado.exceptions.*;

public class ProdutoServices {
	ProdutoRepository pr = new ProdutoRepository();
	
	public Produto findProduct(Long id) {
		validateId(id);
		Produto p = pr.find(id);
		return p;
	}
	
	public Produto createProduct(Produto p) {
		validateProduct(p);
		return pr.add(p);
	}
	
	public Produto updateProduct(Produto p) {
		validateProduct(p);
		findProduct(p.getId());
		return pr.update(p);
	}
	
	public void validateProduct(Produto p) {
		validateId(p.getId());
		if(p.getNome().isBlank()) {
			throw new InvalidNameException("Dê um nome ao seu produto!");
		}
		if(p.getNome().length() > 120) {
			throw new InvalidNameException("Reduza o nome do seu produto!");
		}
		System.out.println(p.getPreco().toString());

		if(String.valueOf(p.getPreco()).length() > 8) {
			throw new InvalidPriceException("Preço demasiadamente longo!");
		}
		if(String.valueOf(p.getPreco()).split("\\.")[1].length() > 2) {
			throw new InvalidPriceException("Preço mal-formatado!");
		}
		if(p.getQuantidade() < 0) {
			throw new InvalidStockException("Quantidade negativa informada, informe um estoque positivo!");
		}
		if(p.getQuantidade() >= 2147483647) {
			throw new InvalidStockException("Valor infinito cadastrado!");
		}
	}
	
	public void validateId(Long id) {
		if(id != null) {
			if(id < 0L) {
				throw new InvalidIDException("Id de produto inválido!");
			}
		}
	}
	
	public void deleteProducts(Long id) {
		validateId(id);
		pr.removeById(id);
	}
	
	public List<Produto> listAllProducts() {
		return pr.findAll();
	}
}
