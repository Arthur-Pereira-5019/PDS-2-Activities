package com.arthur_pereira.supermercado.view;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

import com.arthur_pereira.supermercado.repository.UsuarioRepository;
import com.arthur_pereira.supermercado.service.CommonData;
import com.arthur_pereira.supermercado.service.UsuarioServices;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;

public class LoginScreen extends TelaAbstrata {
	
	UsuarioServices us = new UsuarioServices();
	private JTextField inputCPF;
	private JTextField inputSenha;
	
	public LoginScreen() {
		super(400,300);
		setTitle("Mercado Azulão");
		getContentPane().setBackground(backgroundC);
		getContentPane().setLayout(new MigLayout("", "[18px,grow 8][129px,grow][][grow 15][18px,grow 15]", "[grow 15][32px][grow 15][14px,grow 5][grow][14px][14px,grow 5][grow][14px][14px,grow 5][10px][grow 25][14px,grow 5]"));
		
		JLabel lblTitulo = new JLabel("Supermercado Azulão");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 27));
		getContentPane().add(lblTitulo, "cell 1 1,grow");
		lblTitulo.setForeground(textC);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(btnCadastrar, "cell 3 3,grow");
		btnCadastrar.setBackground(highlightC);
		btnCadastrar.setForeground(textC);
		
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(lblCpf, "cell 1 5,growx");
		lblCpf.setForeground(textC);
		
		
		inputCPF = new JTextField();
		getContentPane().add(inputCPF, "cell 1 6,grow");
		inputCPF.setColumns(10);
		inputCPF.setBackground(highlightC);
		inputCPF.setForeground(textC);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(lblSenha, "cell 1 8");
		lblSenha.setForeground(textC);

		
		inputSenha = new JTextField();
		getContentPane().add(inputSenha, "cell 1 9,grow");
		inputSenha.setColumns(10);
		inputSenha.setBackground(highlightC);
		inputSenha.setForeground(textC);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEntrar.setBackground(highlightC);
		btnEntrar.setForeground(textC);
		
		getContentPane().add(btnEntrar, "cell 1 12,alignx center,growy");

	}
}
