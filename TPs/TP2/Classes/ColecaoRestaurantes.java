import java.util.*;
import java.io.File;
public class ColecaoRestaurantes{
	private int tamanho;
	private Restaurante[] restaurantes;

	ColecaoRestaurantes(){
		this.tamanho = 0;
		this.restaurantes = null;
	
	}

	ColecaoRestaurantes(int tamanho){
		this.tamanho = tamanho;
		this.restaurantes = new Restaurante[tamanho];
	}

	public void setTamanho(int tamanho){
		this.tamanho = tamanho;
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

	public Restaurante pesquisarId(int id){
		for(int i = 0; i < this.tamanho; i++){
			if(this.restaurantes[i] != null && this.restaurantes[i].getId() == id){ //busca sequencial por Id
				return this.restaurantes[i];
			}
		}
		return null; // retorna null se não encontrar o restaurante buscado
	}

	public void lerCsv(String path) throws Exception{
		File arquivo = new File(path);
		Scanner sc = new Scanner(arquivo);
		
		if(sc.hasNextLine()) // pula o cabeçalho
			sc.nextLine();
			
		int i = 0;
		while(sc.hasNextLine()){
			String linha = sc.nextLine(); // Escaneia a string com as infos do restaurante
			restaurantes[i] = Restaurante.parseRestaurante(linha); // guarda o restaurante no formato correto dentro do vetor
			i++;
		}
	}

	public static  ColecaoRestaurantes lerCsv() throws Exception{
		File arquivo = new File("/tmp/restaurantes.csv");
		Scanner sc = new Scanner(arquivo);
		int tamanho = 0;
		
		while(sc.hasNextLine()){
			sc.nextLine();
			tamanho++; // conta quantas linhas o arquivo tem ( vai ser o tamanho do vetor de restaurantes)
		}
			
		
		sc.close();
		
		ColecaoRestaurantes novaColecao = new ColecaoRestaurantes(tamanho -1);

		novaColecao.lerCsv("/tmp/restaurantes.csv");
		return novaColecao; 
	}
}
