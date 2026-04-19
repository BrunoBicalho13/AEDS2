import java.util.*;
public class Hora{
	private int hora;
	private int minuto;

	Hora(){
		this.hora = 0;
		this.minuto = 0;
	}

	Hora(int hora, int minuto){
		if(hora >= 0 && hora <= 23)
			this.hora = hora;
		if(minuto >= 0 && minuto <=59)
			this.minuto = minuto;
	}

	public int getHora(){
		return this.hora;
	}

	public int getMinuto(){
		return this.minuto;
	}

	public void setHora(int Hora){
		this.hora = Hora;
	}

	public void setMinuto(int Minuto){
		this.minuto = Minuto;
	}

	public static Hora parseHora(String s){
        	Scanner scan = new Scanner(s);
        	scan.useDelimiter(":");// separa por :
        	int hora = scan.nextInt();
        	int minuto = scan.nextInt();
        	Hora h = new Hora(hora,minuto);// criar o objeto hora
        	return h;// retona a nova hora
    	}
	
	public String formatarHora(){
                String horario = String.format("%02d:%02d", this.hora, this.minuto);
                return horario;
        }

}
