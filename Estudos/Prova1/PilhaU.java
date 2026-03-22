import java.util.*;

public class PilhaU{
	String[] array;
	int n;

	PilhaU(){ this(6);}

	PilhaU(int tamanho){
		array = new String[tamanho];
		n = 0;
	}

	 void Push(String x) throws Exception{
		if (n >= array.length)
			throw new Exception("Pilha Cheia!");
		
		array[n] = x;
		n++;
	}

	
	 String Pop() throws Exception{
		if(n == 0)
			throw new Exception("Pilha Vazia!");

		return array[--n];
	}

	 void Mostra(){
		System.out.print("[ ");
		for(int i =  0; i < n; i++){
			System.out.print(array[i] + " ");
		}	

		System.out.println(" ]");
	}


	public static void main(String[] Args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PilhaU pilha = new PilhaU(3);
		String x;
		String saiu;
		int i = 0;
			while(i < 3){
				x = sc.nextLine();
				if(x.equals("UNDO")){
					saiu = pilha.Pop();
					System.out.println(saiu + " Está saindo");
				}else{
					pilha.Push(x);
					i++;
				}
			}
			

		pilha.Mostra();
	}















}
