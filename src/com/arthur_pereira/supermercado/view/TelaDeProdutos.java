package com.arthur_pereira.supermercado.view;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import com.arthur_pereira.supermercado.model.Produto;
import com.arthur_pereira.supermercado.repository.ProdutoRepository;
import com.arthur_pereira.supermercado.service.BancoDeDados;
import com.arthur_pereira.supermercado.service.Popups;

import java.awt.Color;

public class TelaDeProdutos extends TelaAbstrata {
	Popups popups = new Popups();
	public TelaDeProdutos() {
		super(360,360);
		getContentPane().setLayout(null);
		getContentPane().setBackground(backgroundC);
		
		JLabel lblNewLabel = new JLabel("Produtos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(105, 11, 129, 23);
		lblNewLabel.setForeground(textC);
		getContentPane().add(lblNewLabel);
		
		JButton botaoEncontrar = new JButton("Encontrar");
		botaoEncontrar.setForeground(new Color(0, 0, 255));
		botaoEncontrar.setBackground(highlightC);
		botaoEncontrar.setForeground(textC);
		botaoEncontrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				encontrarProduto();
			}
		});
		botaoEncontrar.setBounds(10, 108, 117, 23);
		getContentPane().add(botaoEncontrar);
		
		JButton botaoRemover = new JButton("Remover");
		botaoRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletarProduto();
			}
		});
		botaoRemover.setForeground(textC);
		botaoRemover.setBackground(highlightC);
		botaoRemover.setBounds(216, 108, 89, 23);
		getContentPane().add(botaoRemover);
		
		campoId = new JTextField();
		campoId.setBounds(44, 77, 244, 20);
		campoId.setBackground(highlightC);
		campoId.setForeground(textC);
		getContentPane().add(campoId);
		campoId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Id do Produto");
		lblNewLabel_1.setBounds(124, 60, 110, 14);
		lblNewLabel_1.setForeground(textC);
		getContentPane().add(lblNewLabel_1);
		
		campoNome = new JTextField();
		campoNome.setBounds(10, 176, 86, 20);
		campoNome.setBackground(highlightC);	
		campoNome.setForeground(textC);	
		getContentPane().add(campoNome);
		campoNome.setColumns(10);
		
		JLabel labelNome = new JLabel("Nome");
		labelNome.setBounds(33, 157, 46, 14);
		labelNome.setForeground(textC);
		getContentPane().add(labelNome);
		
		campoPreco = new JTextField();
		campoPreco.setBounds(219, 176, 86, 20);
		campoPreco.setForeground(textC);	
		campoPreco.setBackground(highlightC);	
		getContentPane().add(campoPreco);
		campoPreco.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Preço");
		lblNewLabel_3.setBounds(246, 157, 42, 14);
		lblNewLabel_3.setBackground(highlightC);
		lblNewLabel_3.setForeground(textC);	
		getContentPane().add(lblNewLabel_3);
		
		JButton botaoAtualizar = new JButton("Atualizar");
		botaoAtualizar.setBackground(highlightC);
		botaoAtualizar.setForeground(textC);		
		
		botaoAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarProduto();
			}
		});
		botaoAtualizar.setBounds(216, 224, 89, 23);
		getContentPane().add(botaoAtualizar);
		
		JButton botaoCriar = new JButton("Criar");
		botaoCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				criarProduto();
			}
		});
		botaoCriar.setBackground(highlightC);
		botaoCriar.setForeground(textC);		
		botaoCriar.setBounds(10, 224, 89, 23);
		getContentPane().add(botaoCriar);
		
		JButton botaoET = new JButton("Encontrar Todos");
		botaoET.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaDeProdutos ldr = new TelaListaDeProdutos();
				ldr.abrirTela();
			}
		});
		
		botaoET.setBackground(highlightC);
		botaoET.setForeground(textC);
		
		botaoET.setBounds(89, 272, 145, 23);
		getContentPane().add(botaoET);
		
		campoQuantidade = new JTextField();
		campoQuantidade.setBounds(112, 176, 86, 20);
		campoQuantidade.setBackground(highlightC);
		campoQuantidade.setForeground(textC);
		getContentPane().add(campoQuantidade);
		campoQuantidade.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Quantidade");
		lblNewLabel_4.setLocation(124, 157);
		lblNewLabel_4.setSize(74, 14);
		lblNewLabel_4.setForeground(textC);
		getContentPane().add(lblNewLabel_4);
	}

	ProdutoRepository pr = new ProdutoRepository();
	private JTextField campoId;
	private JTextField campoNome;
	private JTextField campoPreco;
	private JTextField campoQuantidade;

	public void buscarProdutos() {
		pr.findAll();
	}
	
	public void encontrarProduto() {
		try {
			Produto p = pr.find(Long.valueOf(campoId.getText()));
			campoNome.setText(p.getNome());
			campoPreco.setText(p.getPreco().toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void criarProduto() {
		//TODO: Verificar se há produto de nome igual
		try {
			Produto p = new Produto();
			p.setId(pr.contar().longValue());
			p.setNome(campoNome.getText());
			p.setPreco(Float.valueOf(campoPreco.getText()));
			p.setQuantidade(Integer.valueOf(campoQuantidade.getText()));
			campoId.setText(pr.add(p));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void atualizarProduto() {
		try {
			Produto p = new Produto();
			p.setNome(campoNome.getText());
			p.setPreco(Float.valueOf(campoPreco.getText()));
			p.setQuantidade(Integer.valueOf(campoQuantidade.getText()));
			p.setId(Long.valueOf(campoId.getText()));
			pr.update(p, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deletarProduto() {
		pr.removeById(Long.valueOf(campoId.getText()));
	}
	
	public void abrirTela(int Width, int Height) {
		this.setSize(400,400);
		this.setVisible(true);
	}
	
	public void esconderTela() {
		this.setVisible(false);
	}
	
	public void fecharTela() {
		
	}
}
