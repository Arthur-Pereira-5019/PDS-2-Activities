package com.arthur_pereira.supermercado.service;
import javax.swing.JOptionPane;

public class Popups {

	
	public static void showError(String m) {
		JOptionPane.showMessageDialog(null, m, "Erro!", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void showSucess(String m) {
		JOptionPane.showMessageDialog(null, m, "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
