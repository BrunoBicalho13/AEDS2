import java.util.*;
public class Data{
	private int ano;
	private int mes;
	private int dia;

	Data(){
		this.ano = 0;
		this.mes = 0;
		this.dia = 0;
	}

	Data(int ano, int mes, int dia){
		this.ano = ano;
		this.mes = mes;
		this.dia = dia;
	}

	public int getAno(){
		return this.ano;
	}	

	public int getMes(){
		return this.mes;
	}

	public int getDia(){
		return this.dia;
	}

	public static String parseData(String s){
		
	}

	public String formatar(){
		String data = String.format("%02d/%02d/%04d",this.dia,this.mes,this.ano);
	}

}
