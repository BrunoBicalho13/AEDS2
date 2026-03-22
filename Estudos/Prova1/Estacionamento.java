import java.util.*;

public class Estacionamento{
	int [] array;
	int n;

	Estacionamento() {  this(6); }

	Estacionamento(int tamanho){
		array = new int[tamanho];
		n = 0;
	}

	void Push(int x) throws Exception{
		if (n >= array.length)
			throw new Exception ("Estacionamento cheio");
		
		array[n] = x;
		n++;
	}

	int Pop() throws Exception{
		if (n == 0)
			throw new Exception("Estacionamento Vazio");


		return array[--n];
	}

	int Topo(){
		if(n > 0){
			return array[n - 1];
		}else{
			return -1; // indica que a pilha está vazia
		}
	}

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);

		int qtdVagoes = 5;
		int[] entrada = {1,2,3,4,5};
		int[] saidaDesejada = new int[qtdVagoes]; 

		for(int i = 0; i < qtdVagoes; i++){
			saidaDesejada[i] = sc.nextInt();
		}

		Estacionamento pilhaSaida = new Estacionamento(qtdVagoes);

		int j = 0; // aponta para o elemento que buscamos

		for(int i = 0; i < entrada.length; i++){
			int vagao = entrada[i];
			pilhaSaida.Push(vagao);
			
		
			while(pilhaSaida.n > 0 && pilhaSaida.Topo() == saidaDesejada[j]){
				pilhaSaida.Pop();
				j++;
			
				if(j == qtdVagoes) break;
			}
		}

		if(pilhaSaida.n == 0){
			System.out.println("Saida Possível");
		}else{
			System.out.println("Não Possível");	
		}

		sc.close();
}













}
