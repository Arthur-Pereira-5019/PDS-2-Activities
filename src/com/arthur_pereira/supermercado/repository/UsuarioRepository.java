package com.arthur_pereira.supermercado.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.arthur_pereira.supermercado.model.Produto;
import com.arthur_pereira.supermercado.model.Usuario;
import com.arthur_pereira.supermercado.service.BancoDeDados;
import com.arthur_pereira.supermercado.service.Popups;

public class UsuarioRepository {
	
private Connection bd;	
	
	public UsuarioRepository() {
		bd = BancoDeDados.getConnection();
	}
	
	public int castBoolean(boolean b) {
		return b ? 1 : 0;
	}
	
	public boolean reverseCastBoolean(int i) {
		return i == 1 ? true : false;
	}
	
	public Usuario findByCpf(String cpf) {
		Usuario retorno = null;
		String sql = "select * from usuarios where cpf=?";
		try {
			PreparedStatement ps = bd.prepareStatement(sql);
			ps.setString(1, cpf);
			ResultSet rs = ps.executeQuery();
			rs.next();
			String nome = rs.getString(1);
			Long id = rs.getLong(3);
			boolean administrador = reverseCastBoolean(rs.getInt(4));
			retorno = new Usuario(id, nome, cpf, administrador);
			Popups.showSucess("Usuário encontrado com sucesso!");
		} catch (SQLException e) {
			Popups.showError("Usuário não encontrado!");
		}
		return retorno;
	}
	
	public String add(Usuario u) {
		String sql = "insert into usuarios values (?,?,0,?)";
		try {
			PreparedStatement ps = bd.prepareStatement(sql);
			ps.setString(1, u.getNome());
			ps.setString(2, u.getCpf());
			ps.setFloat(3, castBoolean(u.isAdministrador()));
			ps.execute();
		} catch (SQLException e) {
			Popups.showError("Erro ao salvar usuário!");
			e.printStackTrace();
		}
		Popups.showSucess("Usuário salvo com sucesso!");
		return "";
	}
	
	public void removeById(Long id) {
		String sql = "delete from usuarios where id=?";
		try {
			PreparedStatement ps = bd.prepareStatement(sql);
			ps.setString(0, id.toString());
			ps.execute();
			Popups.showSucess("Usuário removido com sucesso!");

		} catch(Exception e) {
			e.printStackTrace();
			Popups.showError("Usuário ao remover o produto");
		}
	}
	
	public Usuario find(Long id) {
		Usuario retorno = null;
		String sql = "select * from usuarios where id=?";
		try {
			PreparedStatement ps = bd.prepareStatement(sql);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			String nome = rs.getString(1);
			String cpf = rs.getString(2);
			boolean administrador = reverseCastBoolean(rs.getInt(4));
			retorno = new Usuario(id, nome, cpf, administrador);
			Popups.showSucess("Usuário encontrado com sucesso!");
		} catch (SQLException e) {
			Popups.showError("Usuário não encontrado!");
		}
		return retorno;
	}
	
	
	public ArrayList<Usuario> findAll() {
		ArrayList<Usuario> retorno = new ArrayList<>();
		try {
			PreparedStatement ps = bd.prepareStatement("select * from usuários");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Long foundId = rs.getLong(3);
				String nome = rs.getString(1);
				String cpf = rs.getString(2);
				boolean administrador = reverseCastBoolean(rs.getInt(4));
				retorno.add(new Usuario(foundId, nome, cpf, administrador));
			}
		} catch (SQLException e) {
			Popups.showError("Erro ao procurar usuários!");
		}
		return retorno;
	}
	
	public void update(Usuario u) {
		String sql = "update usuários set nome = ?, cpf = ?, administrador = ? where id = ?";
		try {
			PreparedStatement ps = bd.prepareStatement(sql);
			ps.setString(1, u.getNome());
			ps.setString(2, u.getCpf());
			ps.setInt(3, castBoolean(u.isAdministrador()));
			ps.setFloat(4, u.getId());
			ps.execute();
		} catch (SQLException e) {
			Popups.showError("Erro ao atualizar usuário!");
		}
		Popups.showSucess("Usuário atualizado com sucesso!");
	}
	
	public Integer contar() {
		int i = 0;
		try {
			PreparedStatement ps = bd.prepareStatement("select * from usuarios");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				i++;
			}
		} catch (SQLException e) {
			Popups.showError("Erro ao contar usuários!");
		}
		return i;
	}

}
