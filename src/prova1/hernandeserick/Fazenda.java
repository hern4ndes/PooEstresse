package prova1.hernandeserick;

import java.time.LocalDate;

public class Fazenda {
	private RepositorioDeAnimais animais = new ArrayListDeAnimais(); 
	private int numero;
	private String nome;

	public Fazenda(int numero, String nome) {
		this.numero = numero;
		this.nome = nome;
	}
	public int getNumero() {
		return numero;
	
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public RepositorioDeAnimais getAnimais() {
		return animais;
	}
	
	public void setAnimais(RepositorioDeAnimais animais) {
		this.animais = animais;
	}
	
	public boolean cadastrarAnimal(Animal a) {
		ValidaData data = new ValidaData(a.getDiaNascimento(), a.getMesNascimento(), a.getAnoNascimento());
		if (data.VerificarData()){
			if(animais.pesquisarAnimal(a.getNumero()) == null) {
				a.setVivo(true);
				a.setFazenda_id(numero);
				a.setVendido(false);
				Animal b = a;
				animais.cadastrarAnimal(b); 
				return true;
			}
			return false;
		}

		return false; 
	}
	
	public void Venda(Animal a) {
			if(a.podeSerComercializado()) {
				a.setVendido(true);
				a.setDataDeVenda(LocalDate.now()); 
				
				
			}
		}
		
	
	public boolean abater(Animal a) {
		return a.abate();
	}
	
	public boolean matar(Animal a) {
		return a.morreu();
	}
	


}
