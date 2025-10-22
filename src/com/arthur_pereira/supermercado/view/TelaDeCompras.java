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

public class TelaDeCompras extends TelaAbstrata {
	private JTable table;
	
	String[] colunas = {"Id","Nome","Preço","Qtd.", "Qtd. Desejada", "Adicionar"};
	ProdutoRepository pr = new ProdutoRepository();
	Object[][] dados;
	
	
		public TelaDeCompras() {
			super(700, 700);
			
			popularTabela();
			getContentPane().setLayout(null);
			getContentPane().setBackground(backgroundC);

			table = new JTable(dados,colunas);
			table.setFillsViewportHeight(true);
			table.setBounds(60, 37, 600, 295);
			table.setBackground(highlightC);
			table.setForeground(textC);
			getContentPane().add(table);
			
			table.getColumn("Adicionar").setCellEditor(new TableButtonLogic(new JCheckBox(), table));
			table.getColumn("Adicionar").setCellRenderer(new TableButtonRenderer());			
			
			JLabel lblNewLabel = new JLabel("Produtos");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
			lblNewLabel.setBounds(323, 0, 101, 27);
			lblNewLabel.setForeground(textC);
			getContentPane().add(lblNewLabel);
			
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setLocation(60, 37);
			scrollPane.setSize(600, 295);
			scrollPane.setBackground(backgroundC);
			getContentPane().add(scrollPane);
			JButton buttonCarrinho = new JButton("");
			buttonCarrinho.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					esconderTela();
					CarrinhoDeCompras cdc = new CarrinhoDeCompras();
					cdc.abrirTela();
				}
			});
			
			
			ImageIcon icon = new ImageIcon(LoginScreen.class.getResource("/cart.png"));
			buttonCarrinho.setBounds(10, 82, 40, 40);
			Image image = icon.getImage().getScaledInstance(buttonCarrinho.getWidth(), buttonCarrinho.getHeight(), java.awt.Image.SCALE_SMOOTH);			
			buttonCarrinho.setIcon(new ImageIcon(image));
			getContentPane().add(buttonCarrinho);
			
			JLabel lblNewLabel_1 = new JLabel("Log Out");
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
			lblNewLabel_1.setBounds(581, 12, 72, 13);
			getContentPane().add(lblNewLabel_1);
		}
		
		// Nome produto -> Informações do produto; Campo número de produtos; Campo adicionar ao carrinho;
		// Botão carrinho;
		// Remover elementos do carrinho;
		// Finalizar Compra;
		// Emitir NF;
		// Transição
		
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
