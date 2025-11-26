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

import java.awt.Color;
import net.miginfocom.swing.MigLayout;

public class TelaDeProdutos extends TelaAbstrata {
	Popups popups = new Popups();
	public TelaDeProdutos() {
		super(360,360);
		getContentPane().setLayout(new MigLayout("", "[grow][111,grow][grow][111,grow][grow][grow][111,grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel = new JLabel("Produtos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		getContentPane().add(lblNewLabel, "cell 3 0,alignx center");
		
		JLabel lblNewLabel_1 = new JLabel("Id do Produto");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(lblNewLabel_1, "cell 1 1,alignx center");
		
		textField = new JTextField();
		getContentPane().add(textField, "cell 1 2 7 1,growx");
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Encontrar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(btnNewButton, "cell 2 3");
		
		JButton btnNewButton_1 = new JButton("Excluir");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(btnNewButton_1, "cell 6 3,growx");
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(lblNewLabel_2, "cell 1 4,alignx center");
		
		JLabel lblNewLabel_3 = new JLabel("Quantidade");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(lblNewLabel_3, "cell 3 4,alignx center");
		
		JLabel lblNewLabel_4 = new JLabel("Preço");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(lblNewLabel_4, "cell 6 4,alignx center");
		
		textField_1 = new JTextField();
		getContentPane().add(textField_1, "cell 1 5,alignx center");
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(textField_2, "cell 3 5,growx");
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		getContentPane().add(textField_3, "cell 6 5,growx");
		textField_3.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Criar");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(btnNewButton_2, "cell 2 6,growx");
		
		JButton btnNewButton_3 = new JButton("Atualizar");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(btnNewButton_3, "cell 6 6,alignx center");
	}

	ProdutoRepository pr = new ProdutoRepository();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public void buscarProdutos() {
		pr.findAll();
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
