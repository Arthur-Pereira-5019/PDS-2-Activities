import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class TelaDeProdutos extends TelaAbstrata {
	public TelaDeProdutos() {
		super(400,300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Produtos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(105, 11, 104, 23);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Encontrar");
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 108, 117, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remover");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setForeground(new Color(128, 0, 0));
		btnNewButton_1.setBounds(216, 108, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(44, 77, 244, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Id do Produto");
		lblNewLabel_1.setBounds(124, 60, 72, 14);
		getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 176, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setBounds(33, 157, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(219, 176, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Preço");
		lblNewLabel_3.setBounds(246, 157, 32, 14);
		getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton_2 = new JButton("Atualizar");
		btnNewButton_2.setForeground(new Color(255, 128, 64));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(216, 224, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Criar");
		btnNewButton_3.setForeground(new Color(0, 255, 0));
		btnNewButton_3.setBounds(10, 224, 89, 23);
		getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Encontrar Todos");
		btnNewButton_4.setForeground(new Color(64, 0, 128));
		btnNewButton_4.setBounds(92, 273, 117, 23);
		getContentPane().add(btnNewButton_4);
	}

	BancoDeDados bd = BancoDeDados.getBanco();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public void buscarProdutos() {
		bd.findAll();
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
