package com.arthur_pereira.supermercado.view;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import com.arthur_pereira.supermercado.exceptions.GenericProductException;
import com.arthur_pereira.supermercado.exceptions.InvalidIDException;
import com.arthur_pereira.supermercado.exceptions.InvalidNameException;
import com.arthur_pereira.supermercado.exceptions.InvalidPriceException;
import com.arthur_pereira.supermercado.exceptions.InvalidStockException;
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
	private JTextField campoQuantidade;
	private JTextField campoPreco;
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
				try {
					desserializarProduto(ps.findProduct(buscarId()));
					Popups.showSucess("Produto encontrado!");
				}
				catch(NotFoundException | InvalidIDException ex)  {
					Popups.showError(ex.getMessage());
					campoId.requestFocus();
				}
			}
		});
		findButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(findButton, "cell 2 5,grow");
		findButton.setBackground(highlightC);
		findButton.setForeground(textC);
		
		JButton deleteButton = new JButton("Excluir");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ps.deleteProducts(buscarId());
					campoNome.setText("");
					campoPreco.setText("");
					campoQuantidade.setText("");
					Popups.showSucess("Produto excluído com sucesso!");
				} catch(NotFoundException ex) {
					Popups.showError("Produto não encontrado!");
					campoId.requestFocus();
				} catch(NumberFormatException ex) {
					Popups.showError("Insira um Id numérico!");
					campoId.requestFocus();
				}
			}
		});
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

		
		campoQuantidade = new JTextField();
		campoQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(campoQuantidade, "cell 3 8,grow");
		campoQuantidade.setColumns(10);
		campoQuantidade.setBackground(highlightC);
		campoQuantidade.setForeground(textC);
		
		campoPreco = new JTextField();
		getContentPane().add(campoPreco, "cell 5 8,grow");
		campoPreco.setColumns(10);
		campoPreco.setBackground(highlightC);
		campoPreco.setForeground(textC);
		
		JButton createButton = new JButton("Criar");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					desserializarProduto(ps.createProduct(serializarProduto(false)));
					Popups.showSucess("Produto cadastrado com sucesso!");
				} catch (GenericProductException ex) {
					exceptionHandler(ex);
				} catch (Exception ex) {
					Popups.showError("Exceção desconhecida: " + ex.getMessage());
				}
			}
		});
		createButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(createButton, "cell 2 9,grow");
		createButton.setBackground(highlightC);
		createButton.setForeground(textC);
		
		JButton updateButton = new JButton("Atualizar");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					desserializarProduto(ps.updateProduct(serializarProduto(true)));
					Popups.showSucess("Produto atualizado com sucesso!");

				} catch(NotFoundException ex) {
					Popups.showError(ex.getMessage());
					campoId.requestFocus();
				} catch (GenericProductException ex) {
					exceptionHandler(ex);
				} catch (Exception ex) {
					Popups.showError("Exceção desconhecida: " + ex.getMessage());
				}
			}
		});
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
	
	public Produto serializarProduto(boolean a) {
		Produto p = new Produto();
		if(a) {
			p.setId(buscarId());
		}
		p.setNome(buscarNome());
		p.setPreco(buscarPreco());
		p.setQuantidade(buscarQuantidade());
		return p;
	}
	
	public void desserializarProduto(Produto p) {
		campoId.setText(String.valueOf(p.getId()));
		campoNome.setText(p.getNome());
		campoQuantidade.setText(String.valueOf(p.getQuantidade()));
		campoPreco.setText(String.valueOf(p.getPreco()));
	}
	
	public void exceptionHandler(Exception e) {
		Popups.showError(e.getMessage());
		if (e instanceof InvalidPriceException) {
			campoPreco.requestFocus();
		} else if ( e instanceof InvalidNameException) {
			campoNome.requestFocus();
		} else if (e instanceof InvalidStockException) {
			campoQuantidade.requestFocus();
		} else {
			campoId.requestFocus();
		}
	}
	
	public void abrirTela(int Width, int Height) {
		this.setSize(WIDTH,HEIGTH);
		this.setVisible(true);
	}
	
	
	
	public Float buscarPreco() {
		try {
			return Float.valueOf(campoPreco.getText());
		} catch(Exception ex) {
			throw new InvalidPriceException("Insira um preço válido!");
		}
	}
	
	public String buscarNome() {
		try {
			return campoNome.getText();
		} catch(Exception ex) {
			throw new InvalidNameException("Insira um nome válido para o produto!");
		}
	}
	
	public Integer buscarQuantidade() {
		try {
			return Integer.valueOf(campoQuantidade.getText());
		} catch(Exception ex) {
			throw new InvalidStockException("Insira um estoque válido para o produto!");
		}
	}
	
	public Long buscarId() {
		try {
			return Long.valueOf(campoId.getText());
		} catch(Exception ex) {
			throw new InvalidIDException("Insira um id válido para o produto!");
		}
	}

}
