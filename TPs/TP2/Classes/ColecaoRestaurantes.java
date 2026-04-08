public class ColecaoRestaurantes{
	private int tamanho;
	private Restaurante[] restaurantes;

	ColecaoRestaurantes(){
		this.tamanho = 0;
		this.restaurantes = restaurantes[0];
	
	}

	ColecaoRestaurantes(int tamanho, Restaurante[] restaurantes){
		this.tamanho = tamanho;
		this.restaurantes = restaurantes[0];
	}

	public void setTamanho(int tamanho){
		this.tamaho = tamanho;
	}

	public void setRestaurante(Restaurante[] rest){
		this.restaurantes = rest;
	}

	public int getTamanho(){
		return this.tamanho;
	}

	public Restaurante[] getRestaurantes(){
		return this.restaurantes;
	}

	public void lerCsv(String path){
		File arquivo = new File(path);
			
		
	}

	public static  ColecaoRestaurantes lerCsv(){
		File arquivo = new File("restaurantes.csv");
		Scanner sc = new Scanner(file);
		int tamanho = 0;
		
		while(scanner.hasNextLine()){
			scanner.nextLine();
			tamanho++; // conta quantas linhas o arquivo tem ( vai ser o tamanho do vetor de restaurantes)
		}
			
		

		
		ColecaoRestaurantes novoObj = new ColecaoRestaurantes(); // crio o objeto com o construtor padrão pois darei valor apenas ao atributo tamanho ( usando setter)

		novoObj.setTamanho(tamanho - 1);
		
		sc.close();
		return novoObj; 
	}

	


}
