package com.arthur_pereira.supermercado.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class RemoverButtonRenderer extends JButton implements TableCellRenderer{

	
	public RemoverButtonRenderer() {
        setOpaque(true);
    }
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		setText("Remover");
		setBackground(new Color(0, 170, 255));
		setForeground(new Color(255, 255, 255));
        return this;
	}

}
