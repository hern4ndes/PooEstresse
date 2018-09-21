import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class ValidaData {

	private int dia;
	private int mes;
	private int ano;

	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAno() {
		return ano;
	}

	public ValidaData(int dia,int mes,int ano)	{
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	public boolean VerificarData() {
		try {
			SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
			data.setLenient(false);
			String x = dia + "/" + mes + "/" + ano;
			data.parse(x);
		} catch (ParseException e) {
			return false;
		}
		GregorianCalendar gc = new GregorianCalendar();
		GregorianCalendar day = new GregorianCalendar(ano, mes - 1, dia);
		day.setLenient(false);
		if (gc.before(day)) {
			return false;
		}

		return true;
	}
	
	
}
