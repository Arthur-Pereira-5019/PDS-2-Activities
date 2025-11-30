package com.arthur_pereira.supermercado.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;

import com.arthur_pereira.supermercado.model.Compra;
import com.arthur_pereira.supermercado.model.Produto;
import com.arthur_pereira.supermercado.repository.ProdutoRepository;
import com.arthur_pereira.supermercado.service.CarrinhoDeComprasService;
import com.arthur_pereira.supermercado.service.CommonData;
import com.arthur_pereira.supermercado.service.Popups;

public class TableButtonLogic extends DefaultCellEditor{

	    protected JButton button;
	    private String label;
	    private boolean isPushed;
	    private final ProdutoRepository pr = new ProdutoRepository();
CarrinhoDeComprasService ccs = CommonData.getCarrinhoService();
		ArrayList<Compra> carrinho = (ArrayList<Compra>) ccs.listarCompras();
	    Long id;
	    Integer quantidade;
	    Integer row;
	    Integer column;
	    JTable table;
	    

	    public TableButtonLogic(JCheckBox checkBox, JTable table) {
	        super(checkBox);
	        this.table = table;
	        button = new JButton();
	        button.setOpaque(true);
	        button.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                fireEditingStopped();
	            }
	        });
	    }

	    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
	        if (isSelected) {
	            button.setForeground(table.getSelectionForeground());
	            button.setBackground(table.getSelectionBackground());
	        } else {
	            button.setForeground(table.getForeground());
	            button.setBackground(UIManager.getColor("Button.background"));
	        }
	        this.row = row;
	        this.column = column;
			button.setText("Adicionar");

	        label = "Adicionar";
	        button.setText(label);
	        isPushed = true;
	        return button;
	    }

	    public Object getCellEditorValue() {
	        if (isPushed) {
	        	Long id = Long.valueOf((String) table.getValueAt(row, 0));
	        	Integer quantidade = Integer.valueOf((String.valueOf(table.getValueAt(row, 4))));
	        	
	        	Produto p = pr.find(id);
	        	if(quantidade <= 0) {
	        		Popups.showError("Forneça um valor válido!");
	        	} else if(quantidade > p.getQuantidade()) {
	        		Popups.showError("Estoque insuficiente!");
	        	} else {
		            if(ccs.adicionarCompra(new Compra(p, quantidade))) {
		        		Popups.showSucess("Produto adicionado ao carrinho!");
		            } else {
		        		Popups.showSucess("Alterada quantidade comprada no carrinho!");
		            }
	        	}
	        }
	        isPushed = false;
	        return new String(label);
	    }

	    public boolean stopCellEditing() {
	        isPushed = false;
	        return super.stopCellEditing();
	    }

	    protected void fireEditingStopped() {
	        super.fireEditingStopped();
	    }
	}
	
