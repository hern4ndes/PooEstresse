import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.text.StyledEditorKit.BoldAction;

public abstract class Animal{
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getDiaNascimento() {
		return diaNascimento;
	}

	public void setDiaNascimento() {
		this.diaNascimento = diaNascimento;
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

	public long getAdultAge() {
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
	private long adultAge;
	//private int genero;
	private long dataVacinacao;
	private int fazenda_id;
	private boolean isVivo = true;
	private boolean isVacinado = false;
	private boolean isVendido = false;
	private int diasDoano= 365;

	// Contrutor: (numero, nome, diaNascimento, mesNascimento, anoNascimento, genero,
	// 			   valorDeCompra, valorDeVenda)


	public void vacina(){
		Pair<Boolean, Date> is_adulto =  isAdulto(); //isAdulto();
		if(is_adulto.first){
			//dataVacinacao = is_adulto.second;
			isVacinado = true;
			System.out.println("wow, vacination is done!");
		}else{
			System.out.println("Invalid vacination date!");
		}
	}

	public void abate(){
		if(isVacinado) morte();
	}

	public void morte(){
		isVivo = false;
	}

	public boolean podeSerComercializado(){
		return (isAdulto().first && isVacinado || !(isAdulto().first) );
	}

	public void setAdultAge(float anos) {
		this.adultAge = (long) (diasDoano * anos * 24 * 60 * 60 * 1000);

	}



	public String getNome(){
		return this.nome;
	}

	public Pair<Boolean, Date> isAdulto(){
		//    	GregorianCalendar gc = new GregorianCalendar();
		long diff = 0;
		GregorianCalendar gc = new GregorianCalendar();
		Date now = gc.getTime();

		try {
			SimpleDateFormat format = new SimpleDateFormat("MM/DD/yyyy");
			System.out.println("today");
			String today = (gc.get(gc.MONTH)+1) + "/" + gc.get(gc.DATE) +"/"+ gc.get(gc.YEAR);
			System.out.println(today);
			String bornday = mesNascimento + "/" + diaNascimento +"/"+ anoNascimento;
			System.out.println(bornday);
			diff = ((format.parse(today).getTime() - format.parse(bornday).getTime()));
		}
		
		catch (Exception e) {
			e.printStackTrace();	
		}
		return new Pair<Boolean, Date>(( diff > adultAge), now);
	}

	private boolean isAtivo(){
		return isVivo || !isVendido;
	}

}
