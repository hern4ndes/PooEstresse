public class Main {
	public static void main(String[] args) {
		System.out.println("JAVA the Best");
		Fazenda f1 = new Fazenda(1, "Estrela do Norte");
		Bovino pedrao = new Bovino(1, "pedro", 21, 9, 2018, 0, 500, 250);
		System.out.println(f1.getNome());
		System.out.println(pedrao.getNome());
		Animal bovino1 = new Bovino(2, "Zeze", 22, 9, 2016, 0, 500, 250);
		Animal suino1 = new Suino(3, "Quasimodo", 10, 5, 2018, 0, 800, 300);
		Animal caprino1 = new Caprino(4, "Barnabe", 10, 5, 2018, 0, 400, 200);
//		System.out.println(f1.cadastrarAnimal(pedrao));
//		System.out.println(f1.cadastrarAnimal(suino1));
//		System.out.println(f1.cadastrarAnimal(bovino1));
//		System.out.println(f1.cadastrarAnimal(caprino1));
//		System.out.println(f1.getAnimais().pesquisarAnimal(3).getNome());
	
	
		bovino1.isAdulto();
	System.out.println(bovino1.isAdulto().first);
//		System.out.println(bovino1.isAdulto().second);
//		System.out.println(bovino1.getAdultAge());
		
		
	}
}
