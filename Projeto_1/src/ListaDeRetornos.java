import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.TableModel;

public class ListaDeRetornos extends TelaAbstrata {
	private JTable table;
	
	String[] colunas = {"Id","Nome", "Preço"};
	BancoDeDados bd = BancoDeDados.getBanco();
	String[][] dados;
	
	public ListaDeRetornos() {
		super(400, 800);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		popularTabela();
		table = new JTable(dados,colunas);
		getContentPane().add(table);
	}
	
	public void popularTabela() {
		dados = new String[bd.contar()][3];
		ArrayList<String> d = new ArrayList<>();
		ArrayList<Produto> produtos = bd.findAll();
		for(Produto p: produtos) {
			d.add(String.valueOf(p.getId()));
			d.add(p.getNome());
			d.add(String.valueOf(p.getPreço()));
		}
		for(int i = 0; i < bd.contar()-1;i++) {
			for(int j = 0; j < 2;j++) {
				dados[i][j] = d.get(i+j);
			}
		}
	}
	
	

}
