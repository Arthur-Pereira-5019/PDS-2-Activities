package com.arthur_pereira.supermercado.view;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

import com.arthur_pereira.supermercado.model.Usuario;
import com.arthur_pereira.supermercado.repository.UsuarioRepository;
import com.arthur_pereira.supermercado.service.Popups;
import com.arthur_pereira.supermercado.service.UsuarioServices;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaDeCadastro extends TelaAbstrata {
	private JTextField campoNome;
	private JTextField campoCPF;
	private UsuarioRepository ur = new UsuarioRepository();
	private UsuarioServices us = new UsuarioServices();
	
	public TelaDeCadastro() {
		super(400,300);
		getContentPane().setLayout(null);
		getContentPane().setBackground(backgroundC);
		
		campoNome = new JTextField();
		campoNome.setBounds(124, 80, 141, 28);
		campoNome.setBackground(highlightC);
		campoNome.setForeground(textC);
		getContentPane().add(campoNome);
		campoNome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(124, 56, 46, 14);
		lblNewLabel.setForeground(textC);
		getContentPane().add(lblNewLabel);
		
		campoCPF = new JTextField();
		campoCPF.setBounds(124, 139, 141, 28);
		campoCPF.setBackground(highlightC);
		campoCPF.setForeground(textC);
		getContentPane().add(campoCPF);
		campoCPF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		lblNewLabel_1.setBounds(124, 119, 46, 14);
		lblNewLabel_1.setForeground(textC);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cadastro");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_2.setBounds(150, 11, 150, 32);
		lblNewLabel_2.setForeground(textC);
		getContentPane().add(lblNewLabel_2);

		JCheckBox admnistradorCheckbox = new JCheckBox("Admnistrador");
		admnistradorCheckbox.setBounds(147, 184, 118, 23);
		admnistradorCheckbox.setBackground(backgroundC);
		admnistradorCheckbox.setForeground(textC);

		
		getContentPane().add(admnistradorCheckbox);
		
		
		JButton btnNewButton = new JButton("Cadastrar-se");
		btnNewButton.setBackground(highlightC);
		btnNewButton.setForeground(textC);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAbstrata ta = new TelaDeCompras();
				Usuario u = new Usuario();
				
				
				u.setCpf(campoCPF.getText());
				u.setNome(campoNome.getText());
				u.setAdministrador(false);
				
				if(admnistradorCheckbox.isSelected()) {
					ta = new TelaDeProdutos();
					u.setAdministrador(true);
				}
				if(us.cadastrar(u)) {
					fecharTela();
					ta.abrirTela();
				}
				
			}
		});
		btnNewButton.setBounds(147, 214, 112, 23);
		getContentPane().add(btnNewButton);
		
	}
}
