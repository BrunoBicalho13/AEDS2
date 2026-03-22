import java.util.*;

public class Robin{
	int[] array;
	int primeiro;
	int ultimo;

	Robin(int tamanho){
		array = new int[tamanho + 1];
		primeiro = ultimo = 0;
	}

	void inserir(int x) throws Exception {
		if((ultimo + 1) % array.length == primeiro)
			throw new Exception("Fila Cheia!");
		
		array[ultimo] = x;
		ultimo = (ultimo + 1) % array.length;	
	}

	int remover() throws Exception{
		if(primeiro == ultimo)
			throw new Exception("Fila vazia!");
	

		int resp = array[primeiro];
		
		primeiro = (primeiro + 1) % array.length;
		return resp;	
	}

	boolean vazia(){
		return primeiro == ultimo;
	}

	
	public static void main(String[] args) throws Exception {
        	Scanner sc = new Scanner(System.in);
        	int quantum = 10;
        
        	System.out.println("Quantidade de processos:");
        	int n = sc.nextInt();
        	Robin fila = new Robin(n);

        	System.out.println("Digite o tempo de cada processo:");
        		for (int i = 0; i < n; i++) {
            			fila.inserir(sc.nextInt());
        		}

        	while (!fila.vazia()) {
            		int tempoAtual = fila.remover();
            
            		if (tempoAtual > quantum) {
                		int sobra = tempoAtual - quantum;
                		fila.inserir(sobra); // Reinserção com o tempo restante
            		} else {
                		System.out.println("Processo finalizado!");
            		}
        	}
        	sc.close();
    	}
}	



