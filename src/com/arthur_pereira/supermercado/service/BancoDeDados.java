package com.arthur_pereira.supermercado.service;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.arthur_pereira.supermercado.model.Produto;

public class BancoDeDados {

	private static Connection c;

	private static final String URL = "jdbc:mysql://localhost:3306/supermercado";
	private static final String USER = "root";
	private static final String PASSWORD = "admin";
	public static final String DBMODE = "recreate";

	private static boolean created = false;
	
	//Singleton
	public static Connection getConnection() {
		if(c == null) {
			try {
				c =  DriverManager.getConnection(URL, USER, PASSWORD);
				if(created == false && !DBMODE.equals("keep")) {
					if(DBMODE.equals("create")) {
						createDatabase();
					} else if(DBMODE.equals("recreate")){
						createTables();
					}
					created = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return c;
	}
	
	private BancoDeDados() {
		
	}
	
	private static void createDatabase() {
		PreparedStatement createDatabase = null;
		try {
			createDatabase = c.prepareStatement("create database supermercado");
			c.setCatalog("supermercado");
			createDatabase.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		createTables();
	}
	
	private static void createTables() {
		try {
			PreparedStatement dropSchema = c.prepareStatement("drop database supermercado");
			PreparedStatement createDatabase = c.prepareStatement("create database supermercado");
			PreparedStatement useDatabase = c.prepareStatement("use supermercado");
			PreparedStatement createProduto = c.prepareStatement("create table produtos(nome varchar(120), preco float (8), id BIGINT PRIMARY KEY AUTO_INCREMENT, quantidade int)");
			PreparedStatement createUsuario = c.prepareStatement("create table usuarios(nome varchar(120), cpf char(11), id BIGINT PRIMARY KEY AUTO_INCREMENT, administrador int)");
			dropSchema.execute();
			createDatabase.execute();
			useDatabase.execute();
			createProduto.execute();
			createUsuario.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
