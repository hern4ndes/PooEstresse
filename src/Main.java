import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.Period;

public class Main {
	public static void main(String[] args) {
		Rastreavel sistema = new SistemaDeRegistro();
		Fazenda f1 = new Fazenda(1, "Estrela do Norte");
		sistema.cadastrarFazenda(f1);
		Animal bovino1 = new Bovino(1, "Zeze", 15, 5, 2018, 0, 500, 250);
		Animal suino1 = new Suino(2, "Quasimodo", 10, 5, 2018, 0, 800, 300);
		sistema.cadastrarAnimal(bovino1, f1);
		sistema.cadastrarAnimal(suino1, f1);
		Fazenda f2 = new Fazenda(2, "Estrela do Sul");
		sistema.cadastrarFazenda(f2);
		Animal caprino1 = new Caprino(3, "Barnabe", 10, 5, 2018, 0, 400, 200);
		sistema.cadastrarAnimal(caprino1, f2);
		 System.out.println(suino1.getFazenda_id());
		 System.out.println(f1.getAnimais().getAnimais().size());
		// Testando as compras
		 
		 //System.out.println(sistema.listarResumoDeAnimais(2, 0, true, true));
		 sistema.compra(2, 2, 1);
			 System.out.println(suino1.isVendido());
			 System.out.println(suino1.getNome());
			 System.out.println(suino1.getFazenda_id());
		

		 System.out.println("______________");
		 	
			 System.out.println(suino1.isVendido());
			 System.out.println(suino1.getNome());
			 System.out.println(suino1.getFazenda_id());
		 
		
		
		

	}
}
