package prova1.hernandeserick;

public class SistemaDeRegistro implements Rastreavel {
	private RepositorioDeFazendas fazendas = new ArrayListDeFazendas();	

	@Override
	public boolean cadastrarFazenda(Fazenda f) {
		ValidarFazenda fazendavalida = new ValidarFazenda(f);
		if(fazendavalida.fazendaIsValida()) {
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
		ValidarAnimal animalValidado = new ValidarAnimal(a);
		ValidarFazenda fazendavalida = new ValidarFazenda(f);
		if(animalValidado.isValido  && fazendavalida.fazendaIsValida()) {
			Fazenda fazenda = fazendas.pesquisar(f.getNumero());
			if(fazenda != null) {
				a.setFazenda_id(fazenda.getNumero());
				a.setVivo(true);
				return fazenda.cadastrarAnimal(a);
			}			
		}
		return false;
	}


	@Override
	public boolean compra(int comprado, int fazendaCompra, int fazendaVenda) {
		if(fazendaVenda != fazendaCompra) {
			Fazenda compra = fazendas.pesquisar(fazendaCompra);
			Fazenda venda = fazendas.pesquisar(fazendaVenda);
			if((compra != null) && (venda != null)) {
				//				System.out.println(compra.getNome());
				//				System.out.println(venda.getNome());
				RepositorioDeAnimais animaisF1 = new ArrayListDeAnimais();
				animaisF1 = venda.getAnimais();
				Animal a = animaisF1.pesquisarAnimal(comprado);
				//System.out.println(animal.getNome());

				if(a != null && a.podeSerComercializado()) {
					venda.Venda(a);

					if (a instanceof Bovino) {
						Animal a1 = new Bovino(a.getNumero(), a.getNome(),a.getDiaNascimento(), a.getMesNascimento(), a.getAnoNascimento(), a.getGenero(), a.getValorDeCompra(), a.getValorDeVenda());
						return compra.cadastrarAnimal(a1);
					}
					else if (a instanceof Caprino) {
						Animal a1  = new Caprino(a.getNumero(), a.getNome(),a.getDiaNascimento(), a.getMesNascimento(), a.getAnoNascimento(), a.getGenero(), a.getValorDeCompra(), a.getValorDeVenda());
						return compra.cadastrarAnimal(a1);
					}
					else if (a instanceof Suino) {
						Animal a1  = new Suino(a.getNumero(), a.getNome(),a.getDiaNascimento(), a.getMesNascimento(), a.getAnoNascimento(), a.getGenero(), a.getValorDeCompra(), a.getValorDeVenda());
						return compra.cadastrarAnimal(a1);
					}
					
				}

				return false;
			}

			return false;
		}
		return false;
	}

	@Override
	public boolean venda(int vendido, int fazendaVenda, int fazendaCompra) {

		return compra(vendido, fazendaCompra, fazendaVenda);

	}

	@Override
	public boolean abate(int numeroAnimal, int identificadorFazenda) {
		Fazenda fazenda = fazendas.pesquisar(identificadorFazenda);
		RepositorioDeAnimais animais = new ArrayListDeAnimais();
		animais = fazenda.getAnimais();
		Animal animal = animais.pesquisarAnimal(numeroAnimal);
		if (animal != null) return fazenda.abater(animal);

		return false;
	}

	@Override
	public boolean morte(int numeroAnimal, int identificadorFazenda) {
		Fazenda fazenda = fazendas.pesquisar(identificadorFazenda);
		RepositorioDeAnimais animais = new ArrayListDeAnimais();
		animais = fazenda.getAnimais();
		Animal animal = animais.pesquisarAnimal(numeroAnimal);
		if (animal != null) return fazenda.matar(animal);

		return false;
	}


	@Override
	public boolean vacina(int numeroAnimal, int identificadorFazenda) {
		Fazenda fazenda = fazendas.pesquisar(identificadorFazenda);
		if((fazenda != null) ) {
			RepositorioDeAnimais animais = new ArrayListDeAnimais();
			animais = fazenda.getAnimais();
			Animal animal = animais.pesquisarAnimal(numeroAnimal); 
			if ((animal != null) && (fazenda != null) ) {
				return animal.vacina();
			}
		}
		return false;
	}

	@Override
	public int listarResumoDeAnimais(int fazenda, int tipo, boolean jovem, boolean macho) {
		int intGenero = 0;
		if(macho) intGenero = 1;
		else if(!macho) intGenero = 0;
		else return 0;

		int count = 0;

		Fazenda f1 = fazendas.pesquisar(fazenda);

		if(f1 != null) {
			RepositorioDeAnimais animais = f1.getAnimais();	
			for (Animal animal: animais.getAnimais()) {
				if(tipo == 0) {
					//todos
					if((!jovem) && (animal.isAdulto()) && (animal.getGenero() != intGenero) && animal.isVivo() && animal.isVendido() == false) count ++;
					// adulto && genero = genero
					else if((jovem) && (!animal.isAdulto()) && (animal.getGenero() != intGenero) && animal.isVivo()&& animal.isVendido() == false ) count ++;
					//jovem
				}
				else if(tipo == 1) {
					if((!jovem) && (animal.isAdulto()) && (animal.getGenero() != intGenero) &&(animal instanceof Bovino) && animal.isVivo() && animal.isVendido() == false) count ++;//bovino adulto 
					else if((jovem) && (!animal.isAdulto()) && (animal.getGenero() != intGenero) &&(animal instanceof Bovino)&& animal.isVivo() && animal.isVendido() == false) count ++; // bovino jovem

				}else if(tipo == 2) {
					if((!jovem) && (animal.isAdulto()) && (animal.getGenero() != intGenero) &&(animal instanceof Suino)&& animal.isVivo() && animal.isVendido() == false) count ++;//bovino adulto 
					else if((jovem) && (!animal.isAdulto()) && (animal.getGenero() != intGenero) &&(animal instanceof Suino) && animal.isVivo()&& animal.isVendido() == false) count ++; // bovino jovem

				}
				else if(tipo == 3) {
					if((!jovem) && (animal.isAdulto()) && (animal.getGenero() != intGenero) &&(animal instanceof Caprino)&& animal.isVivo() && animal.isVendido() == false) count ++;//bovino adulto 
					else if((jovem) && (!animal.isAdulto()) && (animal.getGenero() != intGenero) &&(animal instanceof Caprino) && animal.isVivo()&& animal.isVendido() == false) count ++; // bovino jovem

				}

			}

		}
		return count;
	}

	@Override
	public double faturamentoAnual(int fazenda, int tipo) {
		Fazenda f1 = fazendas.pesquisar(fazenda);
		double count = 0;
		if(f1 != null) {
			RepositorioDeAnimais animais = f1.getAnimais();
			for (Animal animal: animais.getAnimais()) {
				if(tipo == 0) {
					//todos
					if(animal.isVendido() == true && animal.temAno(animal.getDataDeVenda())) count = count + animal.getValorDeVenda();

				}
				else if(tipo == 1) {
					if((animal instanceof Bovino)&& animal.isVivo() && animal.isVendido() == true && animal.temAno(animal.getDataDeVenda())) count = count + animal.getValorDeVenda();//bovino adulto 

				}else if(tipo == 2) {
					if((animal instanceof Suino)&& animal.isVivo() && animal.isVendido() == true && animal.temAno(animal.getDataDeVenda()))count = count + animal.getValorDeVenda();//bovino adulto 

				}
				else if(tipo == 3) {
					if((animal instanceof Caprino)&& animal.isVivo() && animal.isVendido() == true && animal.temAno(animal.getDataDeVenda())) count += animal.getValorDeVenda();//bovino adulto 
				}

			}

		}

		return count;
	}

	@Override
	public double perdaAnual(int fazenda, int tipo) {
		Fazenda f1 = fazendas.pesquisar(fazenda);
		double count = 0;
		if(f1 != null) {
			RepositorioDeAnimais animais = f1.getAnimais();
			for (Animal animal: animais.getAnimais()) {
				if(tipo == 0) {
					//todos
					if(animal.isFalecido() == true && animal.temAno(animal.getDataDeObto())) count = count + animal.getValorDeVenda();

				}
				else if(tipo == 1) {
					if((animal instanceof Bovino) && animal.isFalecido() == true && animal.temAno(animal.getDataDeObto())) count = count + animal.getValorDeVenda();//bovino adulto 

				}else if(tipo == 2) {
					if((animal instanceof Suino)&& animal.isFalecido() == true && animal.temAno(animal.getDataDeObto()) )count = count + animal.getValorDeVenda();//bovino adulto 

				}
				else if(tipo == 3) {
					if((animal instanceof Caprino)&& animal.isFalecido() == true && animal.temAno(animal.getDataDeObto()) )count = count + animal.getValorDeVenda();//bovino adulto
				}

			}

		}

		return count;
	}

}


