package com.arthur_pereira.supermercado.repository;

import java.sql.Connection;
import java.util.ArrayList;

import com.arthur_pereira.supermercado.model.Produto;
import com.arthur_pereira.supermercado.service.BancoDeDados;
import com.arthur_pereira.supermercado.service.Popups;

public class ProdutoRepository {

	private Popups popups = new Popups();
	private Long maxId;
	private ArrayList<Produto> produtos = new ArrayList<>();
	private Connection bd;
	private static ProdutoRepository pr;
	
	public static ProdutoRepository getProdutoRepository() {
		if(pr == null) {
			pr = new ProdutoRepository();
		}
		return pr;
	}
	
	public ProdutoRepository() {
		bd = BancoDeDados.getConnection();
	}
	
	
	public Long getAndUpdateId() {
		maxId++;
		return maxId;
	}
	
	public void add(Produto p) {
		produtos.add(p);
		popups.showSucess("Produto adicionado com sucesso!");
	}
	
	public void removeById(Long id) {
		try {
			produtos.remove(findById(id));
			popups.showSucess("Produto removido com sucesso!");

		} catch(Exception e) {
			e.printStackTrace();
			popups.showError("Erro ao remover o produto");

		}
	}
	
	public Produto find(Long id) {
		Produto retorno = findById(id);
		if(retorno == null) {
			popups.showError("Produto não encontrado!");
		}
		return retorno;
	}
	
	public Produto findById(Long id) {
		int i = 0;
		for(Produto p: produtos) {
			if(p.getId() == id) {
				return produtos.get(i);
			}
			i++;
		}
		System.err.print("Produto não encontrado!");
		return null;
	}
	
	public ArrayList<Produto> findAll() {
		return produtos;
	}
	
	public void update(Produto p, Long id) {
		try {
			Integer pos = findPos(id);
			p.setId(id);
			produtos.set(pos, p);
			popups.showSucess("Produto atualizado com sucesso!");
		} catch(Exception e) {
			e.printStackTrace();
			popups.showError("Erro ao atualizar o produto");
		}
		
	}
	
	public Integer findPos(Long id) {
		int i = 0;
		for(Produto p: produtos) {
			if(p.getId() == id) {
				return i;
			}
			i++;
		}
		System.err.print("Produto não encontrado!");
		return null;
	}
	
	public Integer contar() {
		return produtos.size();
	}

}
