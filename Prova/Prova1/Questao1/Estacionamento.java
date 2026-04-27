import java.util.*;

public class Estacionamento{
	int [] array;
	int n;

	Estacionamento() {  this(6); }

	Estacionamento(int tamanho){
		array = new int[tamanho];
		n = 0;
	}

	void Push(int x){
		if (n >= array.length)
			System.out.println("Nao");
		
		array[n] = x;
		n++;
	}

	int Pop(){
		if (n == 0)
		System.out.println("Não");


		return array[--n];
	}

	int Topo(){
		if(n > 0){
			return array[n - 1];
		}else{
			return -1; // indica que a pilha está vazia
		}
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cont = 0;
		int N = MyIO.readInt(); // quantidade de carros
		int K = MyIO.readInt(); // quantidade de vagas
		int[] motoristas= new int[N * 2]; // vetor que armazena as horas de entrada e saída do motorista
		while(N != 0 && K!= 0){
			cont = 0;
			for(int i = 0; i < N * 2; i++){ // 2N linhas de entrada, para a chegada e saída de cada motorista
				motoristas[i] = MyIO.readInt();
			}
		
			for(int i = 1; i < ((N * 2) - 1); i += 2){
				if(motoristas[i] > motoristas [i + 1]){
					cont++; // conta se algum não pode entrar
				}
			}

			if(cont == 0){
				MyIO.println("Sim");	
			}else{
				MyIO.println("Nao");
				}
			N = MyIO.readInt(); // quantidade de carros
			K = MyIO.readInt(); // quantidade de vagas
		}
	}
}
