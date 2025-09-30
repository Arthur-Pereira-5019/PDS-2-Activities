package com.arthur_pereira.supermercado.service;

import com.arthur_pereira.supermercado.model.Usuario;
import com.arthur_pereira.supermercado.repository.UsuarioRepository;

public class UsuarioServices {
	UsuarioRepository ur = new UsuarioRepository();
	
	
	public boolean logar(String cpf, String nome) {
		Usuario u = ur.findByCpf(cpf);
		if(u != null && u.getNome().equals(nome)) {
			CommonData.setLogado(u);
			return true;
		}
		Popups.showError("Usuário não encontrado, favor cadastrar-se");
		return false;
	}
	
	public String criarUsuario(Usuario u) {
		return ur.add(u);
	}

}
