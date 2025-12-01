package com.arthur_pereira.supermercado.view;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import com.arthur_pereira.supermercado.model.Compra;
import com.arthur_pereira.supermercado.model.Produto;
import com.arthur_pereira.supermercado.repository.ProdutoRepository;
import com.arthur_pereira.supermercado.service.CarrinhoDeComprasService;
import com.arthur_pereira.supermercado.service.CommonData;
import com.arthur_pereira.supermercado.service.Popups;
import com.arthur_pereira.supermercado.service.ProdutoServices;

import javax.swing.JTextArea;
import net.miginfocom.swing.MigLayout;

public class CarrinhoDeCompras extends TelaAbstrata {
		private JTable table;
		
		String[] colunas = {"Id", "Nome","Qtd.", "Preço", "Preço Total", "Remover"};
		ProdutoServices ps = new ProdutoServices();
		CarrinhoDeComprasService ccs = CommonData.getCarrinhoService();
		
		ArrayList<Compra> carrinho = (ArrayList<Compra>) ccs.listarCompras();
		Object[][] dados;
		float precoFinal;
		
			public CarrinhoDeCompras() {
				super(700, 620);
				setTitle("Supermercado Azulão");
				
				carregarTabela();
			}
			
			public void carregarTabela() {
				precoFinal = 0;
				popularTabela();
				getContentPane().setBackground(backgroundC);
				
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setBackground(backgroundC);
				getContentPane().setLayout(new MigLayout("", "[5,grow 10][40px,grow 5][40,grow 15][4px,grow 25][40,grow 15][40,grow 5][5,grow 10]", "[5,grow 3][21px,grow 2][14px,grow 1][15,grow 40][40,grow 40][14,grow 1][grow 5,shrink 3]"));

				
				table = new JTable(dados,colunas);
				table.setFillsViewportHeight(true);
				table.setBackground(highlightC);
				table.setForeground(textC);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				
				table.getColumn("Remover").setCellEditor(new RemoverButtonLogic(new JCheckBox(), table));
				table.getColumn("Remover").setCellRenderer(new RemoverButtonRenderer());			
				scrollPane.setViewportView(table);
				
				getContentPane().add(scrollPane, "cell 1 3 5 2,grow");

				
				JLabel lblNewLabel = new JLabel("Carrinho de Compras");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblNewLabel.setForeground(textC);
				getContentPane().add(lblNewLabel, "cell 2 1 3 1,alignx center,growy");
				JButton buttonCarrinho = new JButton("Retornar");
				buttonCarrinho.setBackground(highlightC);
				buttonCarrinho.setForeground(textC);
				buttonCarrinho.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						esconderTela();
						TelaDeCompras tdc = new TelaDeCompras();
						tdc.abrirTela();
					}
				});
				getContentPane().add(buttonCarrinho, "cell 1 2,grow");
				
				
				
								
				JButton btnNewButton = new JButton("Finalizar Compras");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!ccs.isVazio()) {
							ccs.atualizarUltimoCarrinho();
							ccs.limpar();
							carrinho.forEach(c -> {
								Produto p = c.getProduto(); p.setQuantidade(c.getProduto().getQuantidade()-c.getQuantidade());
								ps.updateProduct(c.getProduto());
								});
							carrinho.clear();
							popupNotinha();
						} else {
							Popups.showError("Seu carrinho está vazio!");
						}
					}
				});
				btnNewButton.setForeground(textC);
				btnNewButton.setBackground(highlightC);
				getContentPane().add(btnNewButton, "cell 4 5,grow");
				
				JLabel lblNewLabel_1 = new JLabel("Preço Total: "+precoFinal+"R$");
				lblNewLabel_1.setForeground(textC);
				getContentPane().add(lblNewLabel_1, "cell 2 5,grow");
			}
			
			public void popularTabela() {
				carrinho = (ArrayList<Compra>) ccs.listarCompras();
				
				dados = new Object[carrinho.size()][6];
				ArrayList<Object> d = new ArrayList<>();
				
				JButton botao_adicionar = new JButton("Remover!");
				
				
				if(!carrinho.isEmpty()) {
					for(Compra c: carrinho) {
						Produto p = c.getProduto();
						d.add(String.valueOf(p.getId()));
						d.add(String.valueOf(p.getNome()));
						d.add(Integer.valueOf(c.getQuantidade()));
						d.add(String.valueOf(p.getPreco()));
						float precoTotal = p.getPreco() * c.getQuantidade();
						precoFinal += precoTotal;
						d.add(String.valueOf(precoTotal));
						
						d.add(botao_adicionar);
					}
					
					int a = 0;
					for(int i = 0; i < carrinho.size();i++) {
						for(int j = 0; j < 6;j++) {
							dados[i][j] = d.get(a);
							a++;
						}
					}
				}
				
			}
			
			public void popupNotinha() {
		        int result = JOptionPane.showConfirmDialog(
		            null,
		            "Vai querer a notinha?",
		            "Confirmação",
		            JOptionPane.YES_NO_OPTION
		        );

		        if (result == JOptionPane.YES_OPTION) {
		        	System.out.println(precoFinal);
		            NotaFiscal nf = new NotaFiscal(precoFinal);
		            nf.abrirTela();
		        }
		    }
			
			public void limparTabela() {
				for(int i = 0; i < carrinho.size();i++) {
					for(int j = 0; j < 5;j++) {
						getContentPane().removeAll();
						revalidate();
				        repaint(); 
						carregarTabela();
					}
				}
			}
			

}
