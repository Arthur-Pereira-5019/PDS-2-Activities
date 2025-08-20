import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class TelaDeProdutos extends TelaAbstrata {
	Popups popups = new Popups();
	public TelaDeProdutos() {
		super(400,300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Produtos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(105, 11, 129, 23);
		getContentPane().add(lblNewLabel);
		
		JButton botaoEncontrar = new JButton("Encontrar");
		botaoEncontrar.setForeground(new Color(0, 0, 255));
		botaoEncontrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				encontrarProduto();
			}
		});
		botaoEncontrar.setBounds(10, 108, 117, 23);
		getContentPane().add(botaoEncontrar);
		
		JButton botaoRemover = new JButton("Remover");
		botaoRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletarProduto();
			}
		});
		botaoRemover.setForeground(new Color(128, 0, 0));
		botaoRemover.setBounds(216, 108, 89, 23);
		getContentPane().add(botaoRemover);
		
		campoId = new JTextField();
		campoId.setBounds(44, 77, 244, 20);
		getContentPane().add(campoId);
		campoId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Id do Produto");
		lblNewLabel_1.setBounds(124, 60, 110, 14);
		getContentPane().add(lblNewLabel_1);
		
		campoNome = new JTextField();
		campoNome.setBounds(10, 176, 86, 20);
		getContentPane().add(campoNome);
		campoNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setBounds(33, 157, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		campoPreco = new JTextField();
		campoPreco.setBounds(219, 176, 86, 20);
		getContentPane().add(campoPreco);
		campoPreco.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Preço");
		lblNewLabel_3.setBounds(246, 157, 32, 14);
		getContentPane().add(lblNewLabel_3);
		
		JButton botaoAtualizar = new JButton("Atualizar");
		botaoAtualizar.setForeground(new Color(255, 128, 64));
		botaoAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarProduto();
			}
		});
		botaoAtualizar.setBounds(216, 224, 89, 23);
		getContentPane().add(botaoAtualizar);
		
		JButton botaoCriar = new JButton("Criar");
		botaoCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				criarProduto();
			}
		});
		botaoCriar.setForeground(new Color(0, 255, 0));
		botaoCriar.setBounds(10, 224, 89, 23);
		getContentPane().add(botaoCriar);
		
		JButton btnNewButton_4 = new JButton("Encontrar Todos");
		btnNewButton_4.setForeground(new Color(64, 0, 128));
		btnNewButton_4.setBounds(92, 273, 117, 23);
		getContentPane().add(btnNewButton_4);
	}

	BancoDeDados bd = BancoDeDados.getBanco();
	private JTextField campoId;
	private JTextField campoNome;
	private JTextField campoPreco;

	public void buscarProdutos() {
		bd.findAll();
	}
	
	public void encontrarProduto() {
		try {
			Produto p = bd.find(Long.valueOf(campoId.getText()));
			campoNome.setText(p.getNome());
			campoPreco.setText(p.getPreço().toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void criarProduto() {
		//TODO: Verificar se há produto de nome igual
		try {
			Produto p = new Produto();
			p.setId(bd.contar().longValue());
			p.setNome(campoNome.getText());
			p.setPreço(Float.valueOf(campoPreco.getText()));
			bd.add(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void atualizarProduto() {
		try {
			Produto p = new Produto();
			p.setNome(campoNome.getText());
			p.setPreço(Float.valueOf(campoPreco.getText()));
			bd.update(p, Long.valueOf(campoId.getText()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deletarProduto() {
		bd.removeById(Long.valueOf(campoId.getText()));
	}
	
	public void abrirTela(int Width, int Height) {
		this.setSize(400,400);
		this.setVisible(true);
	}
	
	public void esconderTela() {
		this.setVisible(false);
	}
	
	public void fecharTela() {
		
	}
}
