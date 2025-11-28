package com.arthur_pereira.supermercado.view;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import com.arthur_pereira.supermercado.model.Produto;
import com.arthur_pereira.supermercado.repository.ProdutoRepository;
import com.arthur_pereira.supermercado.service.BancoDeDados;
import com.arthur_pereira.supermercado.service.CommonData;
import com.arthur_pereira.supermercado.service.Popups;
import com.arthur_pereira.supermercado.service.ProdutoServices;

import java.awt.Color;
import net.miginfocom.swing.MigLayout;

public class TelaDeProdutos extends TelaAbstrata {
	Popups popups = new Popups();
	private ProdutoServices ps = new ProdutoServices();
	private JTextField campoId;
	private JTextField campoNome;
	private JTextField campoPreco;
	private JTextField campoQuantidade;
	
	public TelaDeProdutos() {
		super(360,360);
		getContentPane().setLayout(new MigLayout("", "[grow 15][111,grow][grow][111,grow][grow][111,grow][grow 15]", "[grow 15][][grow 15][][][][grow 35][][][][][][grow 15]"));
		getContentPane().setBackground(backgroundC);

		
		JLabel lblNewLabel = new JLabel("Produtos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		getContentPane().add(lblNewLabel, "cell 3 1,alignx center");
		lblNewLabel.setForeground(textC);
		
		JLabel lblNewLabel_1 = new JLabel("Id do Produto");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(lblNewLabel_1, "cell 1 3,alignx center");
		lblNewLabel_1.setForeground(textC);

		
		campoId = new JTextField();
		getContentPane().add(campoId, "cell 1 5 6 1,growx");
		campoId.setColumns(10);
		campoId.setBackground(highlightC);
		campoId.setForeground(textC);

		
		JButton btnNewButton = new JButton("Encontrar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(btnNewButton, "cell 2 7");
		btnNewButton.setBackground(highlightC);
		btnNewButton.setForeground(textC);
		
		JButton btnNewButton_1 = new JButton("Excluir");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(btnNewButton_1, "cell 5 7,growx");
		btnNewButton_1.setBackground(highlightC);
		btnNewButton_1.setForeground(textC);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(lblNewLabel_2, "cell 1 9,alignx center");
		lblNewLabel_2.setForeground(textC);
		
		JLabel lblNewLabel_3 = new JLabel("Quantidade");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(lblNewLabel_3, "cell 3 9,alignx center");
		lblNewLabel_3.setForeground(textC);
		
		JLabel lblNewLabel_4 = new JLabel("Preço");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(lblNewLabel_4, "cell 5 9,alignx center");
		lblNewLabel_4.setForeground(textC);

		
		campoNome = new JTextField();
		getContentPane().add(campoNome, "cell 1 10,alignx center");
		campoNome.setColumns(10);
		campoNome.setBackground(highlightC);
		campoNome.setForeground(textC);

		
		campoPreco = new JTextField();
		campoPreco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(campoPreco, "cell 3 10,growx");
		campoPreco.setColumns(10);
		campoPreco.setBackground(highlightC);
		campoPreco.setForeground(textC);
		
		campoQuantidade = new JTextField();
		getContentPane().add(campoQuantidade, "cell 5 10,growx");
		campoQuantidade.setColumns(10);
		campoQuantidade.setBackground(highlightC);
		campoQuantidade.setForeground(textC);
		
		JButton btnNewButton_2 = new JButton("Criar");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(btnNewButton_2, "cell 2 11,growx");
		btnNewButton_2.setBackground(highlightC);
		btnNewButton_2.setForeground(textC);
		
		JButton btnNewButton_3 = new JButton("Atualizar");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(btnNewButton_3, "cell 4 11,growx");
		btnNewButton_3.setBackground(highlightC);
		btnNewButton_3.setForeground(textC);
	}
	
	public void abrirTela(int Width, int Height) {
		this.setSize(400,600);
		this.setVisible(true);
	}
	
	public void esconderTela() {
		this.setVisible(false);
	}
	
	public void fecharTela() {
		
	}

}
