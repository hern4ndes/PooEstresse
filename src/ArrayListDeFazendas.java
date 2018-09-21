import java.util.ArrayList;

public class ArrayListDeFazendas implements RepositorioDeFazendas{
	
		ArrayList<Fazenda> Fazendas = new ArrayList<Fazenda>();

		public void cadastrar(Fazenda f) {
			Fazendas.add(f);
		}
		
		public Fazenda pesquisar(int numero){
			for (Fazenda fazenda : Fazendas) {
				if (fazenda.getNumero() == numero) {
					return fazenda;
				}
			}
			return null;
			
		}
	}


