import java.util.*;

public class Pilha{ // first in last out
	// otimizado : inserir no fim e remover no fim

	int[] array;
	int n;

	
	Pilha(){ this(6);}

	Pilha(int tamanho){
		array = new int[tamanho];
		n = 0;
	}

	void push(int x) throws Exception{
		if ( n>= array.length)
			throw new Exception("Erro!");
	
		array[n] = x;
		n++;
	}
	
	int pop() throws Exception{
		if ( n == 0)
			throw new Exception("Erro!");
		
		return  array[--n];		
	}


	void mostrar(){
		System.out.print("[ ");
		for(int i = 0; i < n; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println(" ]");
	}
	
	
	public static void main(String[] args) throws Exception{

		Pilha pilha = new Pilha(6);
		pilha.push(1);
		pilha.push(2);
		pilha.push(3);

		pilha.mostrar();

		pilha.pop();
		
		pilha.mostrar();

		pilha.push(8);

		pilha.mostrar();

		pilha.pop();

		pilha.mostrar();


	}
}
