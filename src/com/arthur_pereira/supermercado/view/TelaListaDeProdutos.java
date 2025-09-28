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

public class TelaListaDeProdutos extends TelaAbstrata {
	private JTable table;
	
	String[] colunas = {"Id","Nome", "Preço"};
	ProdutoRepository pr = new ProdutoRepository();
	String[][] dados;
	
	public TelaListaDeProdutos() {
		super(400, 800);
		
		popularTabela();
		getContentPane().setLayout(null);
		table = new JTable(dados,colunas);
		table.setBounds(122, 35, 177, 295);
		getContentPane().add(table);
		
		JLabel lblNewLabel = new JLabel("Produtos");
		lblNewLabel.setBounds(183, 11, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setLocation(108, 37);
		scrollPane.setSize(200, 304);
		getContentPane().add(scrollPane);
	}
	
	public void popularTabela() {
		dados = new String[pr.contar()][3];
		ArrayList<String> d = new ArrayList<>();
		ArrayList<Produto> produtos = pr.findAll();
		for(Produto p: produtos) {
			d.add(String.valueOf(p.getId()));
			d.add(p.getNome());
			d.add(String.valueOf(p.getPreço()));
		}
		
		System.out.println(d.get(0));
		System.out.println(d.get(1));
		System.out.println(d.get(2));
		
		int a = 0;
		for(int i = 0; i < pr.contar()-1;i++) {
			for(int j = 0; j < 3;j++) {
				dados[i][j] = d.get(a);
				a++;
			}
		}
		
	}
}
