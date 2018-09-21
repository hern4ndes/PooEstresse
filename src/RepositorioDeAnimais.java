import java.util.ArrayList;

public interface RepositorioDeAnimais {

	
	public abstract ArrayList<Animal>  getAnimais();
	public abstract void cadastrarAnimal(Animal a);
	public abstract void removerAnimal(Animal a);
	public abstract Animal pesquisarAnimal(int numero);

	
}

