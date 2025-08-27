package com.arthur_pereira.supermercado.service;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import com.arthur_pereira.supermercado.model.Produto;

public class BancoDeDados {

	private static Connection bd;
	private Popups popups = new Popups();
	private ArrayList<Produto> produtos = new ArrayList<>();
	private Long maxId;
	private static final String URL = "jdbc:mysql://localhost:3306/supermercado";
	private static final String USER = "root";
	private static final String PASSWORD = "aluno";
	
	
	//Singleton
	public static Connection getConnection() {
		if(bd == null) {
			try {
				bd =  DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bd;
	}
	
	private BancoDeDados() {
		
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
