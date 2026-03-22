import java.util.*;

public class Estadio{
	int[] array;
	int primeiro; // usado para retirar itens
	int ultimo; // usado para inserir itens

	Estadio(int tamanho){
		array = new int[tamanho + 1];
		ultimo = primeiro = 0;
	}

	void inserir(int x) throws Exception {
		if(((ultimo + 1) % array.length) == primeiro){
			throw new Exception ("Fila Cheia!");	
		}

		array[ultimo] = x;
		ultimo = (ultimo + 1) % array.length;
	}

	int remover() throws Exception{
		if ( primeiro == ultimo){
			throw new Exception ("Fila vazia!");	
		}
		int resp = array[primeiro];

		primeiro = (primeiro + 1) % array.length;
		return resp;
	}

	void mostrar(){
		System.out.print("[ ");
		for(int i = primeiro; i != ultimo; i = ((i + 1) % array.length)){
			System.out.print(array[i] + " ");
		}
		System.out.println(" ]");
	}


	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		Estadio fila = new Estadio(6);
		

		fila.inserir(1);
		fila.inserir(2);
		fila.inserir(3);
		fila.mostrar();
		fila.remover();
		fila.mostrar();
		fila.inserir(4);
		fila.mostrar();
	}
}
