import javax.swing.JOptionPane;

public class Popups {

	
	public void showError(String m) {
		JOptionPane.showMessageDialog(null, m, "Erro!", JOptionPane.ERROR_MESSAGE);
	}
	
	public void showSucess(String m) {
		JOptionPane.showMessageDialog(null, m, "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
