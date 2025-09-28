package com.arthur_pereira.supermercado.model;

public class Usuario {
	private Long id;
	private String nome;
	private String cpf;
	private boolean administrador;
	
	
	public Usuario(Long id, String nome, String cpf, boolean administrador) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.administrador = administrador;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public boolean isAdministrador() {
		return administrador;
	}
	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}
	
	public Usuario() {
		
	}
	
	

}
