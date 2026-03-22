import java.util.*;

public class PilhaNoel{
	int[] array;
	int[] aux;
	int n;

	PilhaNoel(int tam){
		array = new int[tam];
		aux = new int[tam];
		n = 0;
	} 

	void Push(int x){
		array[n] = x;
		if(n == 0)
			aux[n] = x;
		else
			aux[n] = (x < aux[n - 1]) ? x : aux[n - 1];
		n++;
	}

	void Pop(){
		if(n==0)
			System.out.println("EMPTY");
		else
			n--;	
	}

	void Min(){
		if (n == 0)
			System.out.println("EMPTY");
		else{
			System.out.println(aux[n - 1]); // topo do aux sempre tem o menor valor!
		}
	}

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int n;
		n = sc.nextInt();

		PilhaNoel pilha = new PilhaNoel(n);

		for(int i = 0; i < n; i++){
			String str = sc.next();

			if(str.charAt(1) == 'U'){
				int v = sc.nextInt();
				pilha.Push(v);
			}else if(str.charAt(1) == 'O'){
				pilha.Pop();
			}else if(str.charAt(0) == 'M'){
				pilha.Min();
			}
			


		}

	}	
}
