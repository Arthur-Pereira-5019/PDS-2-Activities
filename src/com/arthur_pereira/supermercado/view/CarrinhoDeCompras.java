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

import javax.swing.JTextArea;

public class CarrinhoDeCompras extends TelaAbstrata {
		private JTable table;
		
		String[] colunas = {"Id", "Nome","Qtd.", "Preço", "Preço Total", "Remover"};
		ProdutoRepository pr = new ProdutoRepository();
		CarrinhoDeComprasService ccs = CommonData.getCarrinhoService();
		
		ArrayList<Compra> carrinho = (ArrayList<Compra>) ccs.listarCompras();
		Object[][] dados;
		float precoFinal;
		
			public CarrinhoDeCompras() {
				super(700, 620);
				
				popularTabela();
				getContentPane().setLayout(null);
				getContentPane().setBackground(backgroundC);

				table = new JTable(dados,colunas);
				table.setFillsViewportHeight(true);
				table.setBounds(60, 37, 540, 295);
				table.setBackground(highlightC);
				table.setForeground(textC);
				getContentPane().add(table);
				
				table.getColumn("Remover").setCellEditor(new RemoverButtonLogic(new JCheckBox(), table));
				table.getColumn("Remover").setCellRenderer(new RemoverButtonRenderer());			
				
				JLabel lblNewLabel = new JLabel("Carrinho de Compras");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblNewLabel.setBounds(270, 6, 187, 21);
				lblNewLabel.setForeground(textC);
				getContentPane().add(lblNewLabel);
				
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setLocation(60, 37);
				scrollPane.setSize(540, 295);
				scrollPane.setBackground(backgroundC);
				getContentPane().add(scrollPane);
				JButton buttonCarrinho = new JButton("");
				buttonCarrinho.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						esconderTela();
						TelaDeCompras tdc = new TelaDeCompras();
						tdc.abrirTela();
					}
				});
				
				
				ImageIcon icon = new ImageIcon(LoginScreen.class.getResource("/shop.png"));
				buttonCarrinho.setBounds(10, 82, 40, 40);
				Image image = icon.getImage().getScaledInstance(buttonCarrinho.getWidth(), buttonCarrinho.getHeight(), java.awt.Image.SCALE_SMOOTH);			
				buttonCarrinho.setIcon(new ImageIcon(image));
				getContentPane().add(buttonCarrinho);
				
				JButton btnNewButton = new JButton("Finalizar Compras");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ccs.limpar();
						ccs.atualizarUltimoCarrinho();
						carrinho.forEach(c -> {
							Produto p = c.getProduto(); p.setQuantidade(c.getProduto().getQuantidade()-c.getQuantidade());
							pr.update(c.getProduto(), true);
							});
						carrinho.clear();
						popupNotinha();
					}
				});
				btnNewButton.setBounds(270, 398, 187, 21);
				btnNewButton.setForeground(textC);
				btnNewButton.setBackground(highlightC);
				getContentPane().add(btnNewButton);
				
				JLabel lblNewLabel_1 = new JLabel("Preço Total: "+precoFinal+"R$");
				lblNewLabel_1.setBounds(135, 402, 131, 13);
				lblNewLabel_1.setForeground(textC);
				getContentPane().add(lblNewLabel_1);
			}
			
			public void popularTabela() {
				dados = new Object[carrinho.size()][6];
				ArrayList<Object> d = new ArrayList<>();
				
				JButton botao_adicionar = new JButton("Adicionar!");
				
				
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
						System.out.println(d.size());
						System.out.println(p.getNome());
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
		            NotaFiscal nf = new NotaFiscal(precoFinal);
		            nf.abrirTela();
		        }
		    }
			
}
