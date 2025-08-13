import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import java.awt.Font;

public class LoginScreen extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	public LoginScreen() {
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(124, 80, 141, 28);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(124, 56, 46, 14);
		getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(124, 139, 141, 28);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		lblNewLabel_1.setBounds(124, 119, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Admnistrador");
		tglbtnNewToggleButton.setBounds(134, 194, 121, 23);
		getContentPane().add(tglbtnNewToggleButton);
		
		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_2.setBounds(161, 11, 62, 32);
		getContentPane().add(lblNewLabel_2);
	}
}
