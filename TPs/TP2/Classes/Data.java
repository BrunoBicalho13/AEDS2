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

	public void setAno(int Ano){
		this.ano = Ano;
	}

	public void setMes(int Mes){
		this.mes = Mes;
	}

	public void setDia(int Dia){
		this.dia = Dia;
	}

	public static Data parseData(String s){
		Scanner scan = new Scanner(s); 
        	scan.useDelimiter("-");// - como delimitador
        	int ano = scan.nextInt();
        	int mes = scan.nextInt();
        	int dia = scan.nextInt();
        	scan.close();
        	Data data = new Data(ano, mes, dia);// cria um objeto data
        	return data;// retorna a nova data
	}

	public String formatarData(){
		return String.format("%02d/%02d/%04d",this.dia,this.mes,this.ano);
	}

}
