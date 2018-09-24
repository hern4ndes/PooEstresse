package prova1.hernandeserick;

public class ValidarFazenda {
private boolean fazendaIsvalida = false; 

	public ValidarFazenda(Fazenda f) { 
		if(!f.getNome().isEmpty() && f.getNumero() > 0) fazendaIsvalida = true;
		// TODO Auto-generated constructor stub
	}
public boolean fazendaIsValida() {
	return fazendaIsvalida;
}

}
