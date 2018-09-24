package prova1.hernandeserick;
import java.time.LocalDate;
import java.time.Period;

public abstract class Animal{

	public Animal(int numero, String nome, int diaNascimento, int mesNascimento, int anoNascimento, int genero,
			int valorDeCompra, int valorDeVenda) {
		super();
		this.numero = numero;
		this.nome = nome;
		this.diaNascimento = diaNascimento;
		this.mesNascimento = mesNascimento;
		this.anoNascimento = anoNascimento;
		this.genero = genero;
		this.valorDeCompra = valorDeCompra;
		this.valorDeVenda = valorDeVenda;
		
	}

	private int numero;
	private String nome;
	private int diaNascimento;
	private int mesNascimento;
	private int anoNascimento;
	private int genero;
	private int valorDeCompra;
	private int valorDeVenda;
	private long dataNascimento;
	private int adultAge;

	private long dataVacinacao;
	private int fazenda_id;
	private boolean isVivo = true;
	private boolean isVacinado = false;
	private boolean isVendido = false;
	private boolean falecido = false;
	private boolean abatido = false;



	///////////
	private LocalDate dataDeAbate;
	private LocalDate dataDeObto;
	private LocalDate dataDeVacina;
	private LocalDate dataDeVenda;


	public LocalDate getDataDeVenda() {
		return dataDeVenda;
	}

	public void setDataDeVenda(LocalDate dataDeVenda) {
		this.dataDeVenda = dataDeVenda;
	}

	public boolean isFalecido() {
		return falecido;
	}

	public void setFalecido(boolean falecido) {
		this.falecido = falecido;
	}

	public boolean isAbatido() {
		return abatido;
	}

	public void setAbatido(boolean abatido) {
		this.abatido = abatido;
	}

	public int getNumero() {

		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getDiaNascimento() {
		return diaNascimento;
	}

		public int getMesNascimento() {
		return mesNascimento;
	}

	public void setMesNascimento(int mesNascimento) {
		this.mesNascimento = mesNascimento;
	}

	public int getAnoNascimento() {
		return anoNascimento;
	}

	public void setAnoNascimento(int anoNascimento) {
		this.anoNascimento = anoNascimento;
	}

	public int getGenero() {
		return genero;
	}

	public void setGenero(int genero) {
		this.genero = genero;
	}

	public int getValorDeCompra() {
		return valorDeCompra;
	}

	public void setValorDeCompra(int valorDeCompra) {
		this.valorDeCompra = valorDeCompra;
	}

	public int getValorDeVenda() {
		return valorDeVenda;
	}

	public void setValorDeVenda(int valorDeVenda) {
		this.valorDeVenda = valorDeVenda;
	}

	public long getDataNascimento() {
		return dataNascimento;
	} 

	public void setDataNascimento(long dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public long getDataVacinacao() {
		return dataVacinacao;
	}

	public void setDataVacinacao(long dataVacinacao) {
		this.dataVacinacao = dataVacinacao;
	}

	public int getFazenda_id() {
		return fazenda_id;
	}

	public void setFazenda_id(int fazenda_id) {
		this.fazenda_id = fazenda_id;
	}

	public double getAdultAge() {
		return adultAge;
	}


	public boolean isVivo() {
		return isVivo;
	}

	public void setVivo(boolean isVivo) {
		this.isVivo = isVivo;
	}

	public boolean isVacinado() {
		return isVacinado;
	}

	public void setVacinado(boolean isVacinado) {
		this.isVacinado = isVacinado;
	}

	public boolean isVendido() {
		return isVendido;
	}

	public void setVendido(boolean isVendido) {
		this.isVendido = isVendido;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setAdultAge(int  meses) {
		this.adultAge = meses;

	}

	public String getNome(){
		return this.nome;
	}



	// Contrutor: (numero, nome, diaNascimento, mesNascimento, anoNascimento, genero,
	// 			   valorDeCompra, valorDeVenda)


	public boolean vacina(){ 
		//dataVacinacao = is_adulto.second;
		if(isVivo && !isVendido()){
			dataDeVacina = LocalDate.now();
			return	isVacinado = true;
		
		}
		return false;	

	}

	public boolean abate(){ // abatido
		if(podeSerComercializado()) {
			dataDeAbate = LocalDate.now();
			morte();
			abatido = true;
			return true;
		}
		return false;
	}

	public void morte(){
		if(isVivo) {
			isVivo = false;
		}
	}

	public boolean morreu(){// morreu 
		if(isVivo) {
			dataDeObto = LocalDate.now();
			morte();
			
			falecido = true;
			return true;
		}
		return false;
	}

	public boolean podeSerComercializado(){
		return (((isAdulto() && isVacinado) && isVivo && isVendido == false) || (!isAdulto() && isVivo && isVendido == false));
		// adulto e vacinado ou jovem
	}


	public boolean isAdulto(){
		LocalDate hoje = LocalDate.now();    
		LocalDate nascimento = LocalDate.of(getAnoNascimento(), getMesNascimento(), getDiaNascimento()); 
		Period periodo = Period.between(nascimento, hoje);
		int diff = (periodo.getYears()*12 + periodo.getMonths());  
		return (diff >= adultAge);
	}

	public boolean temAno(LocalDate data){
		LocalDate hoje = LocalDate.now();    
		Period periodo = Period.between(data, hoje);
		return ((periodo.getYears()*12 + periodo.getMonths()) < 12);
	}

	public LocalDate getDataDeAbate() {
		return dataDeAbate;
	}

	public void setDataDeAbate(LocalDate dataDeAbate) {
		this.dataDeAbate = dataDeAbate;
	}

	public LocalDate getDataDeObto() {
		return dataDeObto;
	}

	public void setDataDeObto(LocalDate dataDeObto) {
		this.dataDeObto = dataDeObto;
	}

	public LocalDate getDataDeVacina() {
		return dataDeVacina;
	}

	public void setDataDeVacina(LocalDate dataDeVacina) {
		this.dataDeVacina = dataDeVacina;
	}

}
