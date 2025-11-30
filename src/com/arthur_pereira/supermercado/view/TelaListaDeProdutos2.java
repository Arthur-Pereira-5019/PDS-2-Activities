package com.arthur_pereira.supermercado.view;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.arthur_pereira.supermercado.model.Produto;
import com.arthur_pereira.supermercado.repository.ProdutoRepository;
import com.arthur_pereira.supermercado.service.CommonData;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import net.miginfocom.swing.MigLayout;

public class TelaListaDeProdutos2 extends TelaAbstrata {
	private JTable table;
	
	String[] colunas = {"Id","Nome","Preço"};
	ProdutoRepository pr = new ProdutoRepository();
	Object[][] dados;
	
	
		public TelaListaDeProdutos2() {
			super(700, 700);
			
			popularTabela();
			getContentPane().setBackground(backgroundC);

			JScrollPane scrollPane = new JScrollPane();
			
			
			table = new JTable(dados,colunas);
			table.setFillsViewportHeight(true);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			table.setBackground(highlightC);
			table.setForeground(textC);
			scrollPane.setViewportView(table);
			getContentPane().setLayout(new MigLayout("", "[grow 5][6px,grow 2][120px,grow 80][10px,grow 5][grow 5]", "[27px,grow 7][3px,grow 1][200px,grow]"));			
			
			getContentPane().add(scrollPane, "cell 1 2 3 1,grow");

			
			JLabel lblNewLabel = new JLabel("Produtos");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
			lblNewLabel.setForeground(textC);
			getContentPane().add(lblNewLabel, "cell 2 0,alignx center,aligny center");
			
		}
		
		public void popularTabela() {
			dados = new Object[pr.contar()][6];
			ArrayList<Object> d = new ArrayList<>();
			ArrayList<Produto> produtos = pr.findAll();
			
			JButton botao_adicionar = new JButton("Adicionar!");
			
			
			if(!produtos.isEmpty()) {
				for(Produto p: produtos) {
					d.add(String.valueOf(p.getId()));
					d.add(String.valueOf(p.getNome()));
					d.add(String.valueOf(p.getPreco()));
					d.add(Integer.valueOf(p.getQuantidade()));
					d.add("");
					d.add(botao_adicionar);
				}
				
				int a = 0;
				for(int i = 0; i < pr.contar();i++) {
					for(int j = 0; j < 6;j++) {
						dados[i][j] = d.get(a);
						a++;
					}
				}
			}
			
		}
}
