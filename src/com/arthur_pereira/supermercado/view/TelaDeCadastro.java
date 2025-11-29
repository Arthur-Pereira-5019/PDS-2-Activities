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

public class TelaDeCadastro extends TelaAbstrata {
	
	UsuarioServices us = new UsuarioServices();
	private JTextField inputNome;
	private JTextField inputCPF;
	private JCheckBox checkAdm;
	
	public TelaDeCadastro() {
		super(400,320);
		setTitle("Mercado Azulão");
		getContentPane().setBackground(backgroundC);
		getContentPane().setLayout(new MigLayout("", "[18px,grow 8][80px,grow][][grow 15][18px,grow 15]", "[grow 15][32px][grow 15][14px,grow 5][grow][14px][14px,grow 5][grow][14px][14px,grow 5][10px][14px,grow 5][grow 25][14px,grow 5]"));
		
		JLabel lblTitulo = new JLabel("Cadastro");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 27));
		getContentPane().add(lblTitulo, "cell 1 1,grow");
		lblTitulo.setForeground(textC);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fecharTela();
				LoginScreen ls = new LoginScreen();
				ls.abrirTela();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(btnVoltar, "cell 3 3,grow");
		btnVoltar.setBackground(highlightC);
		btnVoltar.setForeground(textC);
		
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(lblNome, "cell 1 5,growx");
		lblNome.setForeground(textC);
		
		
		inputNome = new JTextField();
		getContentPane().add(inputNome, "cell 1 6,grow");
		inputNome.setColumns(10);
		inputNome.setBackground(highlightC);
		inputNome.setForeground(textC);
		inputNome.requestFocus();
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(lblCPF, "cell 1 8");
		lblCPF.setForeground(textC);

		
		inputCPF = new JTextField();
		getContentPane().add(inputCPF, "cell 1 9,grow");
		inputCPF.setColumns(10);
		inputCPF.setBackground(highlightC);
		inputCPF.setForeground(textC);
		
		JButton btnCadastrar = new JButton("Cadastrar-se");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(us.cadastrar(new Usuario(inputNome.getText(), inputCPF.getText(), checkAdm.isSelected())) == true) {
						esconderTela();
						TelaAbstrata ta = CommonData.getLogado().isAdministrador() ? (new TelaDeProdutos()) : (new TelaDeCompras());
						ta.abrirTela();
						Popups.showSucess("Bem vindo "+inputNome.getText()+"!" );
					}
				} catch(InvalidNameException ex) {
					inputNome.requestFocus();
					Popups.showError(ex.getMessage());
				} catch(InvalidCPFException | BadLoginException | DuplicatedResourceException ex) {
					inputCPF.requestFocus();
					Popups.showError(ex.getMessage());
				} 
				catch (Exception ex) {
					Popups.showError(ex.getMessage());
				}
				
			}
		});
		btnCadastrar.setBackground(highlightC);
		btnCadastrar.setForeground(textC);
		
		checkAdm = new JCheckBox("Administrador");
		checkAdm.setFont(new Font("Tahoma", Font.PLAIN, 12));
		checkAdm.setBackground(backgroundC);
		checkAdm.setForeground(textC);
		getContentPane().add(checkAdm, "cell 1 11,alignx center");

		
		getContentPane().add(btnCadastrar, "cell 1 13,alignx center,growy");

	}
}
