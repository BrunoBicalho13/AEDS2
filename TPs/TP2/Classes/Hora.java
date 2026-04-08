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
		return this.minuto
	}
	
	public String formatarHora(){
                String horario = string.format("%d : %d", this.hora, this.minuto);
                return horario;
        }

}
