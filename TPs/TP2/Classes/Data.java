import java.util.*;
public class Data{
	private String ano;
	private String mes;
	private String dia;

	Data(){
		this.ano = "";
		this.mes = "";
		this.dia = "";
	}

	Data(String ano, String mes, String dia){
		this.ano = ano;
		this.mes = mes;
		this.dia = dia;
	}

	public String getAno(){
		return this.ano;
	}	

	public String getMes(){
		return this.mes;
	}

	public String getDia(){
		return this.dia;
	}

}
