package com.arthur_pereira.supermercado.view;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import com.arthur_pereira.supermercado.model.Compra;
import com.arthur_pereira.supermercado.service.CarrinhoDeComprasService;
import com.arthur_pereira.supermercado.service.CommonData;

import java.awt.Font;
import java.util.ArrayList;
import java.awt.Color;

public class NotaFiscal extends TelaAbstrata {

	CarrinhoDeComprasService ccs = CommonData.getCarrinhoService();
	
	ArrayList<Compra> carrinho = (ArrayList<Compra>) ccs.listarCarrinhoSecundario();
	
	public NotaFiscal(float totalPago) {
		super(370, 325);
		setTitle("Nota Fiscal");
		getContentPane().setLayout(null);
		getContentPane().setBackground(backgroundC);
		
		JLabel lblNewLabel = new JLabel("Supermercado Azulão");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(87, 10, 157, 19);
		lblNewLabel.setForeground(textC);
		getContentPane().add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(highlightC);
		textArea.setForeground(textC);
		textArea.setLineWrap(true);
		textArea.setEnabled(false);
		textArea.setEditable(false);
		textArea.setBounds(20, 39, 299, 191);
		textArea.setForeground(textC);

		getContentPane().add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("Pagador: "+CommonData.getLogado().getNome()+" - CPF: "+CommonData.getLogado().getCpf());
		lblNewLabel_1.setBounds(20, 240, 299, 13);
		lblNewLabel_1.setForeground(textC);
		
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Total Pago: "+String.format("%.2f", totalPago)+"R$");
		lblNewLabel_2.setBounds(20, 263, 157, 13);
		lblNewLabel_2.setForeground(textC);

		getContentPane().add(lblNewLabel_2);
		
		carrinho.forEach(c -> {textArea.setText(textArea.getText()+c.getProduto().getNome()+"   "+"Preço total:"+String.format("%.2f", c.getProduto().getPreco()*c.getQuantidade())+"R$\n");});
		
	}
}
