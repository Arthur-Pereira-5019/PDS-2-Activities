package com.arthur_pereira.supermercado.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.arthur_pereira.supermercado.exceptions.UnknownDatabaseError;
import com.arthur_pereira.supermercado.model.Produto;
import com.arthur_pereira.supermercado.service.BancoDeDados;
import com.arthur_pereira.supermercado.service.Popups;

public class ProdutoRepository {

	private Long maxId;
	private Connection bd;	
	
	public ProdutoRepository() {
		bd = BancoDeDados.getConnection();
	}
	
	public Produto add(Produto p) {
		String sql = "insert into produtos values (?, ?, 0, ?)";
		try {
			PreparedStatement ps = bd.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, p.getNome());
			ps.setFloat(2, p.getPreco());
			ps.setFloat(3, p.getQuantidade());
			ps.execute();
		    try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
		        if (generatedKeys.next()) {
		        	Produto np = p;
		        	np.setId(generatedKeys.getLong(1));
		            return np;
		        } else {
					throw new UnknownDatabaseError("Erro desconhecido ao salvar produto!");
		        }
		    }
		    
		} catch (SQLException e) {
			throw new UnknownDatabaseError("Erro desconhecido ao salvar produto!");
		}
	}
	
	public void removeById(Long id) {
		String sql = "delete from produtos where id=?";
		try {
			PreparedStatement ps = bd.prepareStatement(sql);
			ps.setString(0, id.toString());
			ps.execute();
			Popups.showSucess("Produto removido com sucesso!");

		} catch(Exception e) {
			e.printStackTrace();
			Popups.showError("Erro ao remover o produto");
		}
	}
	
	public Produto find(Long id) {
		Produto retorno = null;
		String sql = "select * from produtos where id=?";
		try {
			PreparedStatement ps = bd.prepareStatement(sql);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			String nome = rs.getString(1);
			Float preco = rs.getFloat(2);
			Long foundId = rs.getLong(3);
			int quantidade = rs.getInt(4);
			retorno = new Produto(nome, preco, foundId, quantidade);
			Popups.showSucess("Produto encontrado com sucesso!");
		} catch (SQLException e) {
			Popups.showError("Produto não encontrado!");
		}
		return retorno;
	}
	
	
	public ArrayList<Produto> findAll() {
		ArrayList<Produto> retorno = new ArrayList<>();
		try {
			PreparedStatement ps = bd.prepareStatement("select * from produtos");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String nome = rs.getString(1);
				Float preco = rs.getFloat(2);
				Long foundId = rs.getLong(3);
				int quantidade = rs.getInt(4);
				retorno.add(new Produto(nome, preco, foundId, quantidade));
			}
		} catch (SQLException e) {
			Popups.showError("Erro ao procurar produtos!");
		}
		return retorno;
	}
	
	public void update(Produto p, boolean finalizacao) {
		String sql = "update produtos set nome = ?, preco = ?, quantidade = ? where id = ?";
		try {
			PreparedStatement ps = bd.prepareStatement(sql);
			ps.setString(1, p.getNome());
			ps.setFloat(2, p.getPreco());
			ps.setFloat(3, p.getQuantidade());
			ps.setFloat(4, p.getId());
			ps.execute();
			if(!finalizacao) {
				Popups.showSucess("Produto atualizado com sucesso!");
			}
		} catch (SQLException e) {
			Popups.showError("Erro ao atualizar produto!");
		}
	}
	
	public Integer contar() {
		int i = 0;
		try {
			PreparedStatement ps = bd.prepareStatement("select * from produtos");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				i++;
			}
		} catch (SQLException e) {
			Popups.showError("Erro ao contar produtos!");
		}
		return i;
	}

}
