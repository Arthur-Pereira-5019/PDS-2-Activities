package com.arthur_pereira.supermercado.view;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

import com.arthur_pereira.supermercado.repository.UsuarioRepository;
import com.arthur_pereira.supermercado.service.CommonData;
import com.arthur_pereira.supermercado.service.UsuarioServices;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginScreen extends TelaAbstrata {
	private JTextField campo_nome;
	private JTextField campo_cpf;
	
	UsuarioServices us = new UsuarioServices();
	
	public LoginScreen() {
		super(400,300);
		getContentPane().setLayout(null);
		
		campo_nome = new JTextField();
		campo_nome.setBounds(124, 80, 141, 28);
		getContentPane().add(campo_nome);
		campo_nome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(124, 56, 46, 14);
		getContentPane().add(lblNewLabel);
		
		campo_cpf = new JTextField();
		campo_cpf.setBounds(124, 139, 141, 28);
		getContentPane().add(campo_cpf);
		campo_cpf.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		lblNewLabel_1.setBounds(124, 119, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_2.setBounds(161, 11, 62, 32);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(us.logar(campo_cpf.getText(), campo_nome.getText())) {
					TelaAbstrata ta = new TelaDeCompras();
					if(CommonData.getLogado().isAdministrador()) {
						ta = new TelaDeProdutos();
					}
					fecharTela();
					ta.abrirTela();
				}
			}
		});
		btnNewButton.setBounds(148, 194, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cadastrar-se");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaDeCadastro tc = new TelaDeCadastro();
				tc.abrirTela();
				fecharTela();
			}
		});
		btnNewButton_1.setBounds(255, 11, 106, 23);
		getContentPane().add(btnNewButton_1);
		
	}
}
