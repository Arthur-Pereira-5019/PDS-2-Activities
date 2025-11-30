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

public class TelaDeCompras extends TelaAbstrata {
	private JTable table;
	
	String[] colunas = {"Id","Nome","Preço","Qtd.", "Qtd. Desejada", "Adicionar"};
	ProdutoRepository pr = new ProdutoRepository();
	Object[][] dados;
	
	
		public TelaDeCompras() {
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
			
			table.getColumn("Adicionar").setCellEditor(new TableButtonLogic(new JCheckBox(), table));
			table.getColumn("Adicionar").setCellRenderer(new TableButtonRenderer());			
			
			getContentPane().add(scrollPane, "cell 1 2 3 1,grow");

			
			JLabel lblNewLabel = new JLabel("Produtos");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
			lblNewLabel.setForeground(textC);
			getContentPane().add(lblNewLabel, "cell 2 0,alignx center,aligny center");
			
			
			JButton buttonCarrinho = new JButton("Carrinho");
			buttonCarrinho.setFont(new Font("Tahoma", Font.PLAIN, 12));
			buttonCarrinho.setBackground(highlightC);
			buttonCarrinho.setForeground(textC);
			buttonCarrinho.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					esconderTela();
					CarrinhoDeCompras cdc = new CarrinhoDeCompras();
					cdc.abrirTela();
				}
			});
			getContentPane().add(buttonCarrinho, "cell 1 1,grow");
			
			JLabel lblNewLabel_1 = new JLabel("Log Out");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					CommonData.setLogado(null);
					LoginScreen ls = new LoginScreen();
					ls.abrirTela();
					fecharTela();
				}
			});
			lblNewLabel_1.setForeground(new Color(255, 0, 0));
			getContentPane().add(lblNewLabel_1, "cell 3 1,alignx center,aligny center");
			
			
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
