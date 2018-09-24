package prova1.hernandeserick;


// import java.lang.Exception;

public class Bovino extends Animal{
	
	Bovino(int numero, String nome, int diaNascimento, int mesNascimento, int anoNascimento, int genero,  int valorDeCompra, int valorDeVenda){
		super( numero, nome, diaNascimento,  mesNascimento, anoNascimento, genero, valorDeCompra,valorDeVenda);
		this.setAdultAge(23);
	}
 
	
}
