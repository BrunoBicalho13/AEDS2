import java.util.*;

public class FilaCircular{ // usa módulo
	int[] array;
	int primeiro; // usado para remover
	int ultimo; // usado para inserir

	public FilaCircular() { this(6); }

	public FilaCircular(int tamanho){
		array = new int[tamanho+1];
		primeiro = ultimo = 0;
	}

	public void inserir(int x) throws Exception{
		if(((ultimo + 1) % array.length) == primeiro){
			throw new Exception("Erro!");
		}

		array[ultimo] = x;
		ultimo = (ultimo + 1) % array.length;
	}

	public int remover() throws Exception{
		if(primeiro == ultimo) // lista vazia
			throw new Exception("Erro ao remover!");
		

		int resp = array[primeiro];
		primeiro = (primeiro + 1) % array.length;
		return resp;
	}

	public void mostrar(){
		System.out.print("[ ");
		for(int i = primeiro; i != ultimo; i = ((i + 1) % array.length)){
			System.out.print(array[i] + " ");
		}

		System.out.println(" ]");
	}

	public boolean isVazia(){
		return (primeiro == ultimo);
	}


	public static void main(String[] args) throws Exception{

	FilaCircular fila = new FilaCircular(6);

	fila.inserir(1);
	fila.inserir(2);
	fila.inserir(3);

	fila.mostrar();


	fila.remover();
	fila.mostrar();
	fila.inserir(8);
	fila.remover();	
	fila.mostrar();	
												


	}





}
