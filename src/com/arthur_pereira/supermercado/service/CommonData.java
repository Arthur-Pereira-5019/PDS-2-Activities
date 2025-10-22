package com.arthur_pereira.supermercado.service;

import java.util.ArrayList;

import com.arthur_pereira.supermercado.model.*;
import com.arthur_pereira.supermercado.repository.CarrinhoComprasRepository;

public class CommonData {
	private static Usuario logado;
	private static CarrinhoDeComprasService cps;
	
	public static Usuario getLogado() {
		if(logado == null) {
			logado = new Usuario();
		}
		return logado;
	}
	
	public static void setLogado(Usuario u) {
		logado = u;
	}
	
	public static CarrinhoDeComprasService getCarrinhoService() {
		if(cps == null) {
			cps = new CarrinhoDeComprasService();
		}
		return cps;
	}
	
	


}
