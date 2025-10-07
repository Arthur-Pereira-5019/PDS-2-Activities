package com.arthur_pereira.supermercado.service;

import java.util.ArrayList;

import com.arthur_pereira.supermercado.model.*;

public class CommonData {
	private static Usuario logado;
	private static ArrayList<Compras> carrinho;
	private static ArrayList<Compras> lastCarrinho;
	
	public static Usuario getLogado() {
		if(logado == null) {
			logado = new Usuario();
		}
		return logado;
	}
	
	public static void setLogado(Usuario u) {
		logado = u;
	}
	
	public static ArrayList<Compras> getCarrinho() {
		if(carrinho == null) {
			carrinho = new ArrayList<Compras>();
		}
		return carrinho;
	}
	
	
	public static ArrayList<Compras> getLastCarrinho() {
		if(lastCarrinho == null) {
			lastCarrinho = new ArrayList<Compras>();
		}
		return lastCarrinho;
	}


}
