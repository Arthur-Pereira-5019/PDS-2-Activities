package com.arthur_pereira.supermercado.service;

import com.arthur_pereira.supermercado.model.Produto;
import com.arthur_pereira.supermercado.repository.ProdutoRepository;

import java.util.List;

import com.arthur_pereira.supermercado.exceptions.*;

public class ProdutoServices {
	ProdutoRepository pr = new ProdutoRepository();
	
	public Produto findProduct(Long id) {
		Produto p = pr.find(id);
		return p;
	}
	
	public Produto createProduct(Produto p) {
		validateProduct(p);
		return pr.add(p);
	}
	
	public Produto updateProduct(Produto p) {
		validateProduct(p);
		return pr.update(p);
	}
	
	public void validateProduct(Produto p) {
		validateId(p.getId());
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
	}
	
	public void validateId(Long id) {
		if(id != null) {
			if(id < 0L) {
				throw new InvalidDataException("Id de produto inválido!");
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
