import java.util.ArrayList;

public class ArrayListDeAnimais implements RepositorioDeAnimais{

	 ArrayList<Animal> animais = new ArrayList<Animal>();
	

	
	 
	 
	 public void cadastrarAnimal(Animal a) {
		animais.add(a);
	}
	 
	public Animal pesquisarAnimal(int numero){
		for (Animal animal : animais) {
			if (animal.getNumero() == numero) {
				return animal;
			}
		}
		return null;

	}

	public void removerAnimal(Animal a) {
		animais.remove(a);
}


	public ArrayList<Animal> getAnimais() {
		
		return animais;
	}




}


	

