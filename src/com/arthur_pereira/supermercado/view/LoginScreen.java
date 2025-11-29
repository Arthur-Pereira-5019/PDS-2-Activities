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

public class LoginScreen extends TelaAbstrata {
	
	UsuarioServices us = new UsuarioServices();
	private JTextField inputCPF;
	private JTextField inputSenha;
	
	public LoginScreen() {
		super(400,300);
		setTitle("Mercado Azulão");
		getContentPane().setBackground(backgroundC);
		getContentPane().setLayout(new MigLayout("", "[113px][18px][129px,grow][][]", "[32px][][14px][][][][][][10px][][]"));
		
		JLabel lblTitulo = new JLabel("Supermercado Azulão");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		getContentPane().add(lblTitulo, "cell 2 0");
		lblTitulo.setForeground(textC);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		getContentPane().add(btnCadastrar, "cell 4 1");
		btnCadastrar.setBackground(highlightC);
		btnCadastrar.setForeground(textC);
		
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(lblCpf, "cell 2 3,growx");
		lblCpf.setForeground(textC);
		
		
		inputCPF = new JTextField();
		getContentPane().add(inputCPF, "cell 2 4,growx");
		inputCPF.setColumns(10);
		inputCPF.setBackground(highlightC);
		inputCPF.setForeground(textC);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(lblSenha, "cell 2 6");
		lblSenha.setForeground(textC);

		
		inputSenha = new JTextField();
		getContentPane().add(inputSenha, "cell 2 7,growx");
		inputSenha.setColumns(10);
		inputSenha.setBackground(highlightC);
		inputSenha.setForeground(textC);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel iconSmurf = new JLabel("New label");
		getContentPane().add(iconSmurf, "cell 4 6 1 4");
		btnEntrar.setBackground(highlightC);
		btnEntrar.setForeground(textC);
		
		getContentPane().add(btnEntrar, "cell 2 10,alignx center");
		ImageIcon icon = new ImageIcon(LoginScreen.class.getResource("/smurf.png"));
		this.addComponentListener(new ComponentAdapter() {
		    @Override
		    public void componentResized(ComponentEvent e) {
		        int w = iconSmurf.getWidth();
		        int h = iconSmurf.getHeight();
		        if (w > 0 && h > 0) {
		            Image img = icon.getImage().getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
		            iconSmurf.setIcon(new ImageIcon(img));
		        }
		    }
		});

	}
}
