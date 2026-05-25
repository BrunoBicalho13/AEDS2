import java.util.*;
public class Ex02{
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			Lista vet =  new Lista(n);
			
			for(int i = 0; i < n; i++){
				int a = sc.nextInt();
				vet.inserirFim(a);
			}

			while(vet.n != 1){
				vet.removerInicio();
				int b = vet.array[0];
				vet.removerInicio();
				vet.inserirFim(b); 
			}

			System.out.println(vet.array[0]);

		}



	}

	public static class Lista{
		int [] array; 
  	 	int n; 

         	
		Lista(int tamanho){
                 	array = new int[tamanho];
                 	n = 0;
         	}

		void inserirFim(int x) throws Exception{
	                 if( n>= array.length)
                         	throw new Exception ("Erro!");
 
	                 array[n] = x;
                 	 n++;
 
        	}

			
		void removerInicio() throws Exception{
                 	if (n == 0)               
                         	throw new Exception("Erro!");
 
 
                 	int resp = array[0]; 
                 	n--;
  
                  	for(int i = 0; i < n; i++){
                         	array[i] = array[i + 1];
                 	}
 
        	}	
		
		void mostrar(){
                 	for(int i = 0; i < n; i++){
                        	System.out.print(array[i]);
                 	}
        	}

	}

}
