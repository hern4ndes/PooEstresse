import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;

import javax.swing.text.StyledEditorKit.BoldAction;

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


	// Contrutor: (numero, nome, diaNascimento, mesNascimento, anoNascimento, genero,
	// 			   valorDeCompra, valorDeVenda)


	public boolean vacina(){
		//dataVacinacao = is_adulto.second;
		isVacinado = true;
		return true;

	}

	public boolean abate(){
		if(podeSerComercializado()) {
			morte();
			return true;
		}
		return false;
	}

	public boolean morte(){
		if(isVivo) {
			isVivo = false;
			return true;
		}return false;
	}

	public boolean podeSerComercializado(){
		return ((isAdulto().first && isVacinado || !(isAdulto().first)) && isVivo && isVendido == false);
		// adulto e vacinado ou jovem
	}

	public void setAdultAge(int  meses) {
		this.adultAge = meses;

	}



	public String getNome(){
		return this.nome;
	}

	public Pair<Boolean, LocalDate> isAdulto(){

		LocalDate today = LocalDate.now();    
		LocalDate userday = LocalDate.of(getAnoNascimento(), getMesNascimento(), getDiaNascimento()); 
		Period periodo = Period.between(userday, today);
		int diff = (periodo.getYears()*12 + periodo.getMonths());  

		return new Pair<Boolean, LocalDate>(( diff >= adultAge), today);
	}

	private boolean isAtivo(){
		return isVivo || !isVendido;
	}



}
