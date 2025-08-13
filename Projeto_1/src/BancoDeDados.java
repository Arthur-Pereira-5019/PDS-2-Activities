import java.util.ArrayList;

public class BancoDeDados {

	private static ArrayList<Produtos> produtos;
	private Popups popups = new Popups();
	
	
	public static ArrayList<Produtos> getProdutos() {
		if(produtos == null) {
			produtos =  new ArrayList<Produtos>();
		}
		return produtos;
	}
	
	public void add(Produtos p) {
		getProdutos().add(p);
		popups.showSucess("Produto adicionado com sucesso!");
	}
	
	public void removeById(Long id) {
		try {
			getProdutos().remove(findById(id));
			popups.showSucess("Produto removido com sucesso!");

		} catch(Exception e) {
			e.printStackTrace();
			popups.showError("Erro ao remover o produto");

		}
	}
	
	public Produtos find(Long id) {
		try {
			return findById(id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Produtos findById(Long id) {
		int i = 0;
		for(Produtos p: getProdutos()) {
			if(p.id == id) {
				return getProdutos().get(i);
			}
			i++;
		}
		System.err.print("Produto não encontrado!");
		return null;
	}
	
	public void update(Produtos p, Long id) {
		try {
			Integer pos = findPos(id);
			getProdutos().set(pos, p);
			popups.showSucess("Produto atualizado com sucesso!");
		} catch(Exception e) {
			e.printStackTrace();
			popups.showError("Erro ao atualizar o produto");
		}
		
	}
	
	public Integer findPos(Long id) {
		int i = 0;
		for(Produtos p: getProdutos()) {
			if(p.id == id) {
				return i;
			}
			i++;
		}
		System.err.print("Produto não encontrado!");
		return null;
	}
}
