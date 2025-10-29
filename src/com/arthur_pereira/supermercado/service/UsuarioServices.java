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
	
	private String criarUsuario(Usuario u) {
		return ur.add(u);
	}
	
	public boolean cadastrar(Usuario u) {
		if(u.getNome() == null || u.getCpf() == null) {
			Popups.showError("Por favor preencha todos os campos corretamente!");
			return false;
		}
		if(u.getCpf().length() > 13) {
			Popups.showError("Por favor informe um CPF correto e sem pontuação!");
			return false;
		}
		
		criarUsuario(u);
		return logar(u.getCpf(), u.getNome());
		
	}

}
