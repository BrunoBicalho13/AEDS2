import java.util.*;

public class FilaA{
	int [] array;
	int n;

	FilaA(){ this (6); }

	FilaA(int tamanho){
		array =  new int[tamanho];
		n = 0;
	}

	void InserirFinal(int x) throws Exception {
		if ( n >= array.length)
			throw new Exception("Fila Cheia!");
		

		array[n] = x;
		n++;	
	}


	void InserirPreferencial(int x) throws Exception {
		if( n >= array.length)
			throw new Exception ("Fila Cheia!");

		for(int i = n; i > 0; i--){
			array[i] = array[i - 1];
		}
		
		
		array[0] = x;
		n++;
	}


	int RemoveInicio() throws Exception{
		if(n == 0)
			throw new Exception ("Fila Vazia!");

		int resp = array[0];
		n--;
		
		for(int i = 0; i < n; i++){
			array[i] = array[i + 1];
		}
		

		return resp;
	}



	void Mostra(){
		System.out.print("[ ");
		for(int i = 0; i < n; i++){
			System.out.print(array[i] + " ");
		}

		System.out.println(" ]");
			
	}

	void MostraProx() throws Exception{
		if(n == 0)
			throw new Exception ("Fila vazia!");
		
		System.out.println("O próximo da fila é " + array[0]);
	}

	public static void main( String[] args) throws Exception{
		FilaA fila = new FilaA(6);
		int x1;
		fila.InserirFinal(1);
		fila.InserirFinal(2);
		fila.InserirPreferencial(3);
		fila.Mostra();
		x1 = fila.RemoveInicio();

		System.out.println(x1 + " foi atendido");		

		fila.MostraProx();

		fila.Mostra();
	}


























}
