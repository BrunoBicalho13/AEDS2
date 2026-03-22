import java.util.*;

public class Quick{
	int[] array;

	public Quick(int array[]){
		this.array = array;
	}

	public void sort(int esquerda, int direita){
		int i = esquerda;
		int j = direita;
		int pivo = array[(esquerda + direita) / 2];
		while( i <= j){
			while(array[i] < pivo) i++; // busca candidatos maiores que o pivo na esquerda do array
			while(array[j] > pivo) j--; // busca candidatos menores que o pivo na direita do array
			if( i <= j){
				swap(i,j);
				i++;
				j--;
			}
		}
	
		if(esquerda < j){
			sort(esquerda,j);
		}

		if( i < direita){
			sort(i, direita);
		}
	}

	public void swap(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public void mostrar() {
		System.out.print("[");

		for (int i = 0; i < array.length; i++) {
			System.out.print(" ("+i+")" + array[i]);
		}

		System.out.println("]");
	}




	public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);

    		int[] array = new int[5];

    		// leitura
   		 for (int i = 0; i < 5; i++) {
        		array[i] = sc.nextInt();
    		 }

    		Quick vetor = new Quick(array);

    		vetor.mostrar(); // antes

    		vetor.sort(0, array.length - 1);

    		vetor.mostrar(); // depois
		}
}
