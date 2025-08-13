import java.util.ArrayList;

public class BancoDeDados {

	private static BancoDeDados bd;
	private Popups popups = new Popups();
	private ArrayList<Produto> produtos;
	private Long maxId;
	
	public static BancoDeDados getBanco() {
		if(bd == null) {
			bd =  new BancoDeDados();
		}
		return bd;
	}
	
	public Long getAndUpdateId() {
		maxId++;
		return maxId;
	}
	
	public void add(Produto p) {
		produtos.add(p);
		popups.showSucess("Produto adicionado com sucesso!");
	}
	
	public void removeById(Long id) {
		try {
			produtos.remove(findById(id));
			popups.showSucess("Produto removido com sucesso!");

		} catch(Exception e) {
			e.printStackTrace();
			popups.showError("Erro ao remover o produto");

		}
	}
	
	public Produto find(Long id) {
		try {
			return findById(id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Produto findById(Long id) {
		int i = 0;
		for(Produto p: produtos) {
			if(p.id == id) {
				return produtos.get(i);
			}
			i++;
		}
		System.err.print("Produto não encontrado!");
		return null;
	}
	
	public ArrayList<Produto> findAll() {
		return produtos;
	}
	
	public void update(Produto p, Long id) {
		try {
			Integer pos = findPos(id);
			produtos.set(pos, p);
			popups.showSucess("Produto atualizado com sucesso!");
		} catch(Exception e) {
			e.printStackTrace();
			popups.showError("Erro ao atualizar o produto");
		}
		
	}
	
	public Integer findPos(Long id) {
		int i = 0;
		for(Produto p: produtos) {
			if(p.id == id) {
				return i;
			}
			i++;
		}
		System.err.print("Produto não encontrado!");
		return null;
	}
}
