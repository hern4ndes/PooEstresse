
public class SistemaDeRegistro implements Rastreavel {
	private RepositorioDeFazendas fazendas = new ArrayListDeFazendas();	

	@Override
	public boolean cadastrarFazenda(Fazenda f) {
			if(f.getNumero() > 0 && !f.getNome().isEmpty() ) {
				if( fazendas.pesquisar(f.getNumero())== null) {
					fazendas.cadastrar(f);
					return true;

				}			
				return false;
			}
			return false;
		}

	@Override
	public boolean cadastrarAnimal(Animal a, Fazenda f) {
		if(a.getNumero() > 0 && !a.getNome().isEmpty() ) {
			Fazenda fazenda = fazendas.pesquisar(f.getNumero());
			if(fazenda != null) {
				return fazenda.cadastrarAnimal(a);

			}			
			return false;
		}
		return false;
	}
		

	@Override
	public boolean compra(int comprado, int fazendaCompra, int fazendaVenda) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean venda(int vendido, int fazendaVenda, int fazendaCompra) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean abate(int numeroAnimal, int identificadorFazenda) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean morte(int numeroAnimal, int identificadorFazenda) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean vacina(int numeroAnimal, int identificadorFazenda) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int listarResumoDeAnimais(int fazenda, int tipo, boolean jovem, boolean macho) {
		Fazenda f1 = fazendas.pesquisar(fazenda);
		return f1.getAnimais().getAnimais().size();
		
		
			
	}

	@Override
	public double faturamentoAnual(int fazenda, int tipo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double perdaAnual(int fazenda, int tipo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
