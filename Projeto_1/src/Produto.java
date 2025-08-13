
public class Produto {
	String nome;
	Float preço;
	Long id;
	
	public Produto(String nome, Float preço, Long id) {
		super();
		this.nome = nome;
		this.preço = preço;
		this.id = BancoDeDados.getBanco().getAndUpdateId();
	}
	
	public Produto() {
		
	}
	

}
