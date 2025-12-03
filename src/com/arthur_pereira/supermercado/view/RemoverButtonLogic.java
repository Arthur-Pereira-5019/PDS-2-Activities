package com.arthur_pereira.supermercado.view;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.arthur_pereira.supermercado.model.Compra;
import com.arthur_pereira.supermercado.model.Produto;
import com.arthur_pereira.supermercado.repository.ProdutoRepository;
import com.arthur_pereira.supermercado.service.CarrinhoDeComprasService;
import com.arthur_pereira.supermercado.service.CommonData;
import com.arthur_pereira.supermercado.service.Popups;

public class RemoverButtonLogic extends DefaultCellEditor{
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
    

    public RemoverButtonLogic(JCheckBox checkBox, JTable table) {
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
        
        label = "Remover";
        button.setText(label);
        isPushed = true;
        return button;
    }

    public Object getCellEditorValue() {
        if (isPushed) {
        	Long id = Long.valueOf((String) table.getValueAt(row, 0));        	
        	Produto p = pr.find(id);
        	ccs.removerCompra(ccs.procurarCompraPeloProduto(p));
        	Popups.showSucess("Produto removido com sucesso!");
        		Window topLevelParent = SwingUtilities.getWindowAncestor(button);
        		if(topLevelParent instanceof CarrinhoDeCompras) {
        			((CarrinhoDeCompras) topLevelParent).atualizarTabela();
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
   	 try {
   	        super.fireEditingStopped();
   	    } catch (Exception ignored) {
   	    }
   }
}
