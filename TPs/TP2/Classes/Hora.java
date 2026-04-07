public class Hora{
	private int hora;
	private int minuto;

	Hora(){
		this.hora = 0;
		this.minuto = 0;
	}

	Hora(int hora, int minuto){
		this.hora = hora;
		this.minuto = minuto;
	}

	public int getHora(){
		return this.hora;
	}

	public int getMinuto(){
		return this.minuto
	}
	
	public String formatar(){
                String horario = string.format("%d : %d", this.hora, this.minuto);
                return horario;
        }

}
