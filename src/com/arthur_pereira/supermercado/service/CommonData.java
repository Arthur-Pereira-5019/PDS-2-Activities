package com.arthur_pereira.supermercado.service;

import com.arthur_pereira.supermercado.model.Usuario;

public class CommonData {
	static Usuario logado;
	
	public static Usuario getLogado() {
		if(logado == null) {
			logado = new Usuario();
		}
		return logado;
	}
	
	public void setLogado(Usuario u) {
		logado = u;
	}

}
