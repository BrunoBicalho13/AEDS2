import java.util.*;

public class Lista{
	int [] array; //declara o array
	int n; // declara o contador

	Lista(){ this(6);} // Declara uma lista padrão de index 6
	Lista(int tamanho){
		array = new int[tamanho];
		n = 0;
	}

	void inserirInicio(int x) throws Exception{ // Se o contador já mostrar que a lista está cheia, mostra erro
		if(n >= array.length)
			throw new Exception("Erro!");



		for (int i = n; i > 0; i--){
			array[i] = array[i - 1]; // Manda os elementos para o fim do array --> Começa do final e vai puxando pra direita
		}

		array[0] = x; // coloca o valor desejado na primeira posição
		n++; // itera o contador pra mostrar que mais um item foi adicionado
	}


	void inserirFim(int x) throws Exception{
		if( n>= array.length)
			throw new Exception ("Erro!");

		array[n] = x;
		n++;
	
	}

	void inserir(int x, int pos) throws Exception{
		if (pos < 0 || n >= array.length || pos > n) // condições para a operação ser válida
			throw new Exception("Erro!");

		for(int i = n; i > pos; i--){
			array[i] = array[i - 1]; // só da shift do final até a posição desejada
		}

		array[pos] = x;
		n++;
			
	}

	int removerInicio() throws Exception{
		if (n == 0) // vetor vazio		
			throw new Exception("Erro!");


		int resp = array[0]; // guarda o valor removido em uma variável
		n--;// decrementa o contador pra mostrar que um valor foi removido

		for(int i = 0; i < n; i++){
			array[i] = array[i + 1]; // puxa os valores uma posição para a esquerda e sobrescreve a primeira casa
		}

		return resp; // retorna o valor retirado para o usuário

	}


	int removerFim() throws Exception{
		if (n == 0)
			throw new Exception("Erro!");
		
		int resp = array[--n]; // remove o número da lógica e o retorna

		return resp;
	}

	int remover(int pos) throws Exception{
		if(n == 0 || pos < 0 || pos >= n)
			throw new Exception("Erro!");
		
		int resp = array[pos];
		n--;
		
		for(int i = pos; i < n; i++){
			array[i] = array[i + 1];
		}

		return resp;
		
	}

	void mostrar(){
		System.out.print("[ ");
		for(int i = 0; i < n; i++){
			System.out.print(array[i] +" ");
		}
		System.out.println(" ]");
	}
	
	
	public static void main(String[] args) throws Exception{
		Lista lista = new Lista (6);
		int x1,x2,x3;

		lista.inserirInicio(1);
		lista.inserirFim(7);
		lista.inserirFim(9);
		lista.inserirInicio(3);
		lista.inserir(8,3);
		lista.inserir(4,2);

		lista.mostrar();

		x1 = lista.removerInicio();
		x2 = lista.removerFim();
		x3 = lista.remover(2);

		System.out.print(x1 + "," + x2 + "," + x3);
		System.out.println("");

		lista.mostrar();
	}

}

