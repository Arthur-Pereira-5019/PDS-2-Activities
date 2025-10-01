package com.arthur_pereira.supermercado.view;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.arthur_pereira.supermercado.model.Produto;
import com.arthur_pereira.supermercado.repository.ProdutoRepository;

public class TelaDeCompras extends TelaAbstrata {
	private JTable table;
	
	String[] colunas = {"Id","Nome","Qtd.", "Qtd. Desejada", "Adicionar"};
	ProdutoRepository pr = new ProdutoRepository();
	Object[][] dados;
	
	
		public TelaDeCompras() {
			super(400, 800);
			
			popularTabela();
			getContentPane().setLayout(null);
			table = new JTable(dados,colunas);
			table.setBounds(30, 35, 360, 295);
			getContentPane().add(table);
			
			table.getColumn("Adicionar").setCellEditor(new TableButtonLogic(new JCheckBox(), table));
			table.getColumn("Adicionar").setCellRenderer(new TableButtonRenderer());
			
			JLabel lblNewLabel = new JLabel("Produtos");
			lblNewLabel.setBounds(183, 11, 60, 14);
			getContentPane().add(lblNewLabel);
			
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setLocation(30, 37);
			scrollPane.setSize(360, 304);
			getContentPane().add(scrollPane);
		}
		
		// Nome produto -> Informações do produto; Campo número de produtos; Campo adicionar ao carrinho;
		// Botão carrinho;
		// Remover elementos do carrinho;
		// Finalizar Compra;
		// Emitir NF;
		
		public void popularTabela() {
			dados = new Object[pr.contar()][5];
			ArrayList<Object> d = new ArrayList<>();
			ArrayList<Produto> produtos = pr.findAll();
			
			JButton botao_adicionar = new JButton("Adicionar!");
			
			
			if(!produtos.isEmpty()) {
				for(Produto p: produtos) {
					d.add(String.valueOf(p.getId()));
					d.add(String.valueOf(p.getNome()));
					d.add(Integer.valueOf(p.getQuantidade()));
					d.add("");
					d.add(botao_adicionar);
				}
				
				int a = 0;
				for(int i = 0; i < pr.contar()-1;i++) {
					for(int j = 0; j < 5;j++) {
						dados[i][j] = d.get(a);
						a++;
					}
				}
			}
			
		}

}
