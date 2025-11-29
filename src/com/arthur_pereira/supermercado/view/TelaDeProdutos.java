package com.arthur_pereira.supermercado.view;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import com.arthur_pereira.supermercado.exceptions.NotFoundException;
import com.arthur_pereira.supermercado.model.Produto;
import com.arthur_pereira.supermercado.repository.ProdutoRepository;
import com.arthur_pereira.supermercado.service.BancoDeDados;
import com.arthur_pereira.supermercado.service.CommonData;
import com.arthur_pereira.supermercado.service.Popups;
import com.arthur_pereira.supermercado.service.ProdutoServices;

import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;

public class TelaDeProdutos extends TelaAbstrata {
	Popups popups = new Popups();
	private ProdutoServices ps = new ProdutoServices();
	private JTextField campoId;
	private JTextField campoNome;
	private JTextField campoPreco;
	private JTextField campoQuantidade;
	private final int HEIGTH = 360;
	private final int WIDTH = 560;
	
	public TelaDeProdutos() {
		super(560,360);
		getContentPane().setLayout(new MigLayout("", "[grow 15][111,grow][grow][111,grow][grow][111,grow][grow 15]", "[grow 35][][grow 35][14px,grow 5][14px,grow 5][14px,grow 5][50px,grow 35][14px,grow 5][14px,grow 5][14px,grow 5][14px,grow 5][grow 35]"));
		getContentPane().setBackground(backgroundC);

		
		JLabel lblNewLabel = new JLabel("Produtos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		getContentPane().add(lblNewLabel, "cell 3 1,alignx center,growy");
		lblNewLabel.setForeground(textC);
		
		JLabel lblLogout = new JLabel("Sair");
		lblLogout.setForeground(new Color(255, 0, 0));
		lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CommonData.setLogado(null);
				LoginScreen ls = new LoginScreen();
				ls.abrirTela();
				fecharTela();
			}
		});
		getContentPane().add(lblLogout, "cell 5 1,grow");
		
		JLabel lblNewLabel_1 = new JLabel("Id do Produto");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(lblNewLabel_1, "cell 1 3,alignx left,growy");
		lblNewLabel_1.setForeground(textC);

		
		campoId = new JTextField();
		getContentPane().add(campoId, "cell 1 4 6 1,grow");
		campoId.setColumns(10);
		campoId.setBackground(highlightC);
		campoId.setForeground(textC);

		
		JButton findButton = new JButton("Encontrar");
		findButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(campoId.getText().isBlank() || !campoId.getText().matches("[0-9]*")) {
					Popups.showError("Insira um Id numérico!");
				} try {
					Produto p = ps.findProduct(Long.valueOf(campoId.getText()));
					campoNome.setText(p.getNome());
					campoQuantidade.setText(String.valueOf(p.getQuantidade()));
					campoPreco.setText(p.getPreco().toString());
					Popups.showSucess("Produto encontrado!");
				} catch(NotFoundException ex) {
					Popups.showError("Produto não encontrado!");
					campoId.requestFocus();
				}
			}
		});
		findButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(findButton, "cell 2 5,grow");
		findButton.setBackground(highlightC);
		findButton.setForeground(textC);
		
		JButton deleteButton = new JButton("Excluir");
		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(deleteButton, "cell 4 5,grow");
		deleteButton.setBackground(highlightC);
		deleteButton.setForeground(textC);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(lblNewLabel_2, "cell 1 7,grow");
		lblNewLabel_2.setForeground(textC);
		
		JLabel lblNewLabel_3 = new JLabel("Quantidade");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(lblNewLabel_3, "cell 3 7,grow");
		lblNewLabel_3.setForeground(textC);
		
		JLabel lblNewLabel_4 = new JLabel("Preço");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(lblNewLabel_4, "cell 5 7,grow");
		lblNewLabel_4.setForeground(textC);

		
		campoNome = new JTextField();
		getContentPane().add(campoNome, "cell 1 8,grow");
		campoNome.setColumns(10);
		campoNome.setBackground(highlightC);
		campoNome.setForeground(textC);

		
		campoPreco = new JTextField();
		campoPreco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(campoPreco, "cell 3 8,grow");
		campoPreco.setColumns(10);
		campoPreco.setBackground(highlightC);
		campoPreco.setForeground(textC);
		
		campoQuantidade = new JTextField();
		getContentPane().add(campoQuantidade, "cell 5 8,grow");
		campoQuantidade.setColumns(10);
		campoQuantidade.setBackground(highlightC);
		campoQuantidade.setForeground(textC);
		
		JButton createButton = new JButton("Criar");
		createButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(createButton, "cell 2 9,grow");
		createButton.setBackground(highlightC);
		createButton.setForeground(textC);
		
		JButton updateButton = new JButton("Atualizar");
		updateButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(updateButton, "cell 4 9,grow");
		updateButton.setBackground(highlightC);
		updateButton.setForeground(textC);
		
		JButton btnEncontrarTodos = new JButton("Encontrar Todos");
		btnEncontrarTodos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEncontrarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaDeProdutos ldr = new TelaListaDeProdutos();
				ldr.abrirTela();
			}
		});
		getContentPane().add(btnEncontrarTodos, "cell 5 10,grow");
		btnEncontrarTodos.setBackground(highlightC);
		btnEncontrarTodos.setForeground(textC);
	}
	
	public Produto gerarProduto() {
		Produto p = new Produto();
		p.setId(Long.valueOf(campoId.getText()));
		p.setNome(campoNome.getText());
		p.setPreco(Float.valueOf(campoPreco.getText()));
		p.setQuantidade(Integer.valueOf(campoQuantidade.getText()));
		return p;
	}
	
	public void abrirTela(int Width, int Height) {
		this.setSize(WIDTH,HEIGTH);
		this.setVisible(true);
	}
	
	public void esconderTela() {
		this.setVisible(false);
	}
	
	public void fecharTela() {
		
	}

}
