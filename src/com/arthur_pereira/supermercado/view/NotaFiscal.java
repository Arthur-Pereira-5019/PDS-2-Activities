package com.arthur_pereira.supermercado.view;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import com.arthur_pereira.supermercado.model.Compra;
import com.arthur_pereira.supermercado.service.CarrinhoDeComprasService;
import com.arthur_pereira.supermercado.service.CommonData;

import java.awt.Font;
import java.util.ArrayList;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;

public class NotaFiscal extends TelaAbstrata {

	CarrinhoDeComprasService ccs = CommonData.getCarrinhoService();
	
	ArrayList<Compra> carrinho = (ArrayList<Compra>) ccs.listarCarrinhoSecundario();
	
	public NotaFiscal(float totalPago) {
		super(370, 325);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		setTitle("Nota Fiscal");
		getContentPane().setBackground(backgroundC);
		getContentPane().setLayout(new MigLayout("", "[5,grow 2][100,grow 90][5,grow 2]", "[5,grow 3][22,grow 5][100,grow][14,grow 5][14,grow 5][5,grow 3]"));
		
		JLabel lblNewLabel = new JLabel("Supermercado Azulão");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setForeground(textC);
		getContentPane().add(lblNewLabel, "cell 1 1,alignx center,growy");
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(highlightC);
		textArea.setForeground(textC);
		textArea.setLineWrap(true);
		textArea.setEnabled(false);
		textArea.setEditable(false);
		textArea.setForeground(textC);

		getContentPane().add(textArea, "cell 1 2,alignx left,growy");
		
		JLabel lblNewLabel_1 = new JLabel("Pagador: "+CommonData.getLogado().getNome()+" - CPF: "+CommonData.getLogado().getCpf());
		lblNewLabel_1.setForeground(textC);
		
		getContentPane().add(lblNewLabel_1, "cell 1 3,growx,aligny top");
		
		JLabel lblNewLabel_2 = new JLabel("Total Pago: "+String.format("%.2f", totalPago)+"R$");
		lblNewLabel_2.setForeground(textC);

		getContentPane().add(lblNewLabel_2, "cell 1 4,alignx left,aligny top");
		
		carrinho.forEach(c -> {textArea.setText(textArea.getText()+c.getProduto().getNome()+" x" + c.getQuantidade() +  "  "+"Preço total: "+String.format("%.2f", c.getProduto().getPreco()*c.getQuantidade())+"R$\n");});
		
	}
}
