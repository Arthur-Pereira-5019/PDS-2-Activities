package com.arthur_pereira.supermercado.view;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import com.arthur_pereira.supermercado.model.Produto;
import com.arthur_pereira.supermercado.repository.ProdutoRepository;
import com.arthur_pereira.supermercado.service.BancoDeDados;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;

public class TelaListaDeProdutos extends TelaAbstrata {
	private JTable table;
	
	String[] colunas = {"Id","Nome", "Preço"};
	ProdutoRepository pr = new ProdutoRepository();
	String[][] dados;
	
	public TelaListaDeProdutos() {
		super(400, 800);
		getContentPane().setBackground(backgroundC);
		
		popularTabela();
		getContentPane().setLayout(null);
		table = new JTable(dados,colunas);
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setEnabled(false);
		table.setBackground(highlightC);
		table.setForeground(textC);
		table.setBounds(122, 35, 177, 295);
		getContentPane().add(table);
		
		JLabel lblNewLabel = new JLabel("Produtos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(147, 10, 114, 27);
		lblNewLabel.setBackground(textC);
		getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setLocation(24, 58);
		scrollPane.setSize(400, 304);
		scrollPane.setBackground(highlightC);
		getContentPane().add(scrollPane);
	}
	
	public void popularTabela() {
		dados = new String[pr.contar()][3];
		ArrayList<String> d = new ArrayList<>();
		ArrayList<Produto> produtos = pr.findAll();
		System.out.println(produtos.size());
		if(!produtos.isEmpty()) {
			for(Produto p: produtos) {
				d.add(String.valueOf(p.getId()));
				d.add(p.getNome());
				d.add(String.valueOf(p.getPreco()));
			}
			
			int a = 0;
			for(int i = 0; i < pr.contar();i++) {
				for(int j = 0; j < 3;j++) {
					dados[i][j] = d.get(a);
					a++;
					System.out.println("Adicionado dado");
				}
			}
		}
		
		
	}
}
