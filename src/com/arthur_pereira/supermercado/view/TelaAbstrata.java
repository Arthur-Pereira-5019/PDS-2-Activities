package com.arthur_pereira.supermercado.view;
import java.awt.Color;

import javax.swing.JFrame;

import com.arthur_pereira.supermercado.service.CommonData;

public abstract class TelaAbstrata extends JFrame {
	
	public final int WIDTH;
	public final int HEIGHT;
	
	protected final Color backgroundC = new Color(0, 83, 196);
	protected final Color textC = new Color(255, 255, 255);
	protected final Color highlightC = new Color(0, 0, 128);
	
	protected CommonData cd = new CommonData();
	
	public TelaAbstrata(int WIDTH, int HEIGHT) {
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
	}
	
	public void abrirTela() {
		this.setSize(WIDTH,HEIGHT);
		this.setVisible(true);
	}
	
	public void esconderTela() {
		this.setVisible(false);
	}
	
	public void fecharTela() {
		this.dispose();
	}

}
