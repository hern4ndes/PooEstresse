package prova1.hernandeserick;

public class ValidarAnimal {
	public boolean isValido =  false;

	
	public ValidarAnimal(Animal a) {
		if (a.getNumero() > 0 && !a.getNome().isEmpty() && a.getDiaNascimento() > 0 && a.getMesNascimento() >0 && a.getAnoNascimento() > 0 && ((a.getGenero()==0)|| (a.getGenero() == 1)) && a.getValorDeCompra()>= 0 && a.getValorDeVenda()>=0){
			this.isValido = true;
			
		}
		 
	}
	public boolean  animalIsValido() {
		return isValido;
	}

}
