package com.arthur_pereira.supermercado.view;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import com.arthur_pereira.supermercado.model.Compras;
import com.arthur_pereira.supermercado.service.CommonData;

import java.awt.Font;
import java.util.ArrayList;

public class NotaFiscal extends TelaAbstrata {

	ArrayList<Compras> carrinho = CommonData.getLastCarrinho();
	
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
		textArea.setLineWrap(true);
		textArea.setEnabled(false);
		textArea.setEditable(false);
		textArea.setBounds(20, 39, 299, 191);
		textArea.setForeground(textC);

		getContentPane().add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("Pagador: "+CommonData.getLogado().getNome()+"  CPF:"+CommonData.getLogado().getCpf());
		lblNewLabel_1.setBounds(20, 240, 174, 13);
		lblNewLabel_1.setForeground(textC);
		
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Total Pago: "+totalPago+"R$");
		lblNewLabel_2.setBounds(20, 263, 157, 13);
		lblNewLabel_2.setForeground(textC);

		getContentPane().add(lblNewLabel_2);
		
		carrinho.forEach(c -> {textArea.setText(textArea.getText()+c.getProduto().getNome()+"   "+"Preço total:"+c.getProduto().getPreco()*c.getQuantidade()+"R$\n");});
		
	}
}
