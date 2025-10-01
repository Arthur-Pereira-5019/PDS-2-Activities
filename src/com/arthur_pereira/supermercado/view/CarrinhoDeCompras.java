package com.arthur_pereira.supermercado.view;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class CarrinhoDeCompras extends TelaAbstrata {

	public CarrinhoDeCompras() {
		super(400, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Carrinho de Compras");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(111, 11, 224, 18);
		getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(209, 131, 2, 2);
		getContentPane().add(scrollPane);
		
		JButton btnNewButton = new JButton("Finalizar Compras");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(153, 456, 135, 23);
		getContentPane().add(btnNewButton);
	}
}
