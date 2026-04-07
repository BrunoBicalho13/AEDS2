public class ColecaoRestaurantes{
	private int tamanho;
	private Restaurante[] restaurantes;

	ColecaoRestaurantes(){
		this.tamanho = 0;
		this.restaurantes = restaurantes[0];
	
	}

	ColecaoRestaurantes(int tamanho, Restaurante[] restaurantes){
		this.tamanho = tamanho;
		this.restaurantes = restaurantes;
	}

	public void setRestaurante(Restaurante rest){
		this.restaurante = rest;
	}

	public static  ColecaoRestaurantes lerCsv(){
		// Ler o arquivo csv
		int tamanho = 0;
		Restaurante[] restaurante;

		//lendo as linhas, mandando os objetos pro array e contando as linhas
		ColecaoRestaurantes novoObj = new ColecaoRestaurantes(tamanho, restaurante);

	}

	


	public static void main(String args[]){
		lerCsv();
	}
}
