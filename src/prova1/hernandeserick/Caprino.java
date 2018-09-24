package prova1.hernandeserick;

public class Caprino extends Animal {


	public Caprino(int numero, String nome, int diaNascimento, int mesNascimento, int anoNascimento, int genero,  int valorDeCompra, int valorDeVenda){
		super( numero, nome, diaNascimento,  mesNascimento, anoNascimento, genero, valorDeCompra,valorDeVenda);
		this.setAdultAge(18);
	}


}
