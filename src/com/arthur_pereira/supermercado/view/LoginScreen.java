package com.arthur_pereira.supermercado.view;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

import com.arthur_pereira.supermercado.exceptions.*;
import com.arthur_pereira.supermercado.model.Usuario;
import com.arthur_pereira.supermercado.repository.UsuarioRepository;
import com.arthur_pereira.supermercado.service.CommonData;
import com.arthur_pereira.supermercado.service.Popups;
import com.arthur_pereira.supermercado.service.UsuarioServices;

import java.awt.Font;
import java.awt.Image;
import java.awt.RenderingHints.Key;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginScreen extends TelaAbstrata {
	
	UsuarioServices us = new UsuarioServices();
	private JTextField inputNome;
	private JTextField inputCPF;
	
	public LoginScreen() {
		super(400,300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Mercado Azulão");
		getContentPane().setBackground(backgroundC);
		getContentPane().setLayout(new MigLayout("", "[18px,grow 4][80px,grow 80][22,grow 16][8,grow 6][18px,grow 4]", "[5,grow 22][32px][grow 5][14px,grow 5][grow 20][14px][14px,grow 3][grow 5][14px][14px,grow 3][grow 25][14px,grow 3][20,grow 26]"));
		
		JLabel lblTitulo = new JLabel("Supermercado Azulão");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		getContentPane().add(lblTitulo, "cell 1 1,grow");
		lblTitulo.setForeground(textC);
		
		JButton btnCadastrar = new JButton("Cadastrar-se");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				esconderTela();
				TelaDeCadastro tdc = new TelaDeCadastro();
				tdc.abrirTela();
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(btnCadastrar, "cell 3 3,grow");
		btnCadastrar.setBackground(highlightC);
		btnCadastrar.setForeground(textC);
		
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(lblNome, "cell 1 5,growx");
		lblNome.setForeground(textC);
		
		
		inputNome = new JTextField();
		inputNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					inputCPF.requestFocus();
				}
			}
		});
		getContentPane().add(inputNome, "cell 1 6,grow");
		inputNome.setColumns(10);
		inputNome.setBackground(highlightC);
		inputNome.setForeground(textC);
		inputNome.setCaretColor(textC);
		inputNome.requestFocus();
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(lblCPF, "cell 1 8");
		lblCPF.setForeground(textC);

		
		inputCPF = new JTextField();
		inputCPF.setCaretColor(textC);
		inputCPF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					entrar();
				}
			}
		});
		getContentPane().add(inputCPF, "cell 1 9,grow");
		inputCPF.setColumns(10);
		inputCPF.setBackground(highlightC);
		inputCPF.setForeground(textC);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entrar();
			}
		});
		btnEntrar.setBackground(highlightC);
		btnEntrar.setForeground(textC);
		
		getContentPane().add(btnEntrar, "cell 1 11,alignx center,growy");
	}
	
	public void entrar() {
		try {
			if(us.logar(new Usuario(inputNome.getText(), inputCPF.getText())) == true) {
				Popups.showSucess("Bem vindo "+inputNome.getText()+"!" );
				esconderTela();
				TelaAbstrata ta = CommonData.getLogado().isAdministrador() ? (new TelaDeProdutos()) : (new TelaDeCompras());
				ta.abrirTela();
			}
		} catch(InvalidNameException ex) {
			inputNome.requestFocus();
			Popups.showError(ex.getMessage());
		} catch(InvalidCPFException | BadLoginException ex) {
			inputCPF.requestFocus();
			Popups.showError(ex.getMessage());
		} catch (Exception ex) {
			Popups.showError(ex.getMessage());
		}
	}
}
