package com.arthur_pereira.supermercado.service;

import com.arthur_pereira.supermercado.exceptions.*;
import com.arthur_pereira.supermercado.model.Usuario;
import com.arthur_pereira.supermercado.repository.UsuarioRepository;

public class UsuarioServices {
	UsuarioRepository ur = new UsuarioRepository();
	
	
	public boolean logar(Usuario u) {
		validarDados(u);
		Usuario u2 = null;
		try {
			u2 = ur.findByCpf(u.getCpf());
		} catch (Exception ex) {
			throw new BadLoginException("Credenciais inválidas!");
		}
		if(u2 != null && u2.getNome().equals(u.getNome())) {
			CommonData.setLogado(u);
			return true;
		}
		throw new BadLoginException("Credenciais inválidas!");
	}
	
	private String criarUsuario(Usuario u) {
		return ur.add(u);
	}
	
	public boolean cadastrar(Usuario u) {
		validarDados(u);
		criarUsuario(u);
		return logar(u);
	}
	
	public void validarDados(Usuario u) {
		if(u.getCpf() == null) {
			throw new InvalidCPFException("Preencha o CPF corretamente!");
		}
		if(u.getCpf().length() != 11) {
			throw new InvalidCPFException("O CPF deve ter 11 caracteres");
		}
		if(!u.getCpf().matches("[0-9]{11}")) {
			throw new InvalidCPFException("O CPF deve conter somente números");
		}
		if(u.getNome() == null || u.getNome().isBlank()) {
			throw new InvalidNameException("Preencha o nome corretamente!");
		}
		if(!u.getNome().matches("[aA-zZ]*")) {
			throw new InvalidNameException("O nome deve ser composto somente por letras");
		}
	}
	
	

}
