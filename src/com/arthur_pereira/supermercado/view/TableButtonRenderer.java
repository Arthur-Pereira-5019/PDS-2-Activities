package com.arthur_pereira.supermercado.view;

import java.awt.Component;
import java.util.EventObject;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class TableButtonRenderer extends JButton implements TableCellRenderer{
	//Código gerado com assistência de IA, sua função é customizar como a tabela renderiza os botões.

	
	public TableButtonRenderer() {
        setOpaque(true);
    }
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		setText((value == null) ? "" : value.toString());
        return this;
	}

}
