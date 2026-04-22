import java.util.*;
class Fila{
	private Celula primeiro, ultimo;
	
	public Fila(){
		primeiro = new Celula(); // cria celula cabeça e aponta primeiro para ela
		ultimo = primeiro;//aponta ultimo para cabeça 
	}

	public void inserir(int x){
		ultimo.prox = new Celula(x);
		ultimo = ultimo.prox;
	}

	public int remover() throws Exception{
		if(primeiro == ultimo)
			throw new Exception("Vazia!");

		Celula tmp = primeiro; // aponta tmp para primeiro
		primeiro = primeiro.prox;//aponta primeiro para o proximo da fila e este será o novo cabeça
		
		int elemento = primeiro.elemento; // retorna o elemento do novo cabeça
		tmp.prox = null; // remove os ponteiros
		tmp = null;
		return elemento;
	}

	public void mostrar(){
		System.out.print("[ ");
		for(Celula i = primeiro.prox; i.prox != null ; i = i.prox){
			System.out.print(i.elemento + " ");
		}
		System.out.println(" ]");
	}

	public void removerFisicamente()throws Exception{
		if (primeiro == ultimo)
			throw new Exception("Vazia!")

		Celula tmp = primeiro.prox; // tmp referencia o primeiro termo da lista
		primeiro.prox = primeiro.prox.prox; // primeiro aponta para o segundo termo da lista (este será nosso primeiro tempo)
		int elemento = tmp.elemento;
		tmp.prox = null; //desreferencia o antigo primeiro termo da lista
		tmp = null;
		return elemento.
	}

	public int maior() throws Exception{
		int maior = -1;
		if(primeiro == ultimo)
			throw new Exception("Vazia!");

		maior = primeiro.prox.elemento;
		Celula i = primeiro.prox.prox;
		while(i != null){
			if(i.elemento > maior)
				maior = i.elemento;

			i = i.prox;
		}

		return maior;
	}

	public int retornarTerceiro(){
		if(primeiro.prox.prox.prox != null)
			return primeiro.prox.prox.prox.elemento;
			return -1;
	}

	public int somar(){
		int resp = 0;

		for(Celula i = primeiro.prox; i != null; i = i.prox){
			resp += i.elemento;
		}
		return resp;
	}

	void inverter(){
		Celula fim = ultimo;
		while(primeiro != fim){
			Celula nova = new Celula(primeiro.prox.elemento);
			nova.prox = fim.prox;
			fim.prox = nova;
			Celula tmp = primeiro.prox;
			primeiro.prox = tmp.prox;
			nova = tmp = tmp.prox = null;
			if(ultimo == fim){
				ultimo = ultimo.prox;
			}
		}
		fim = null;
	}

	public int contar(){
		return contar(primeiro.prox);
	}

	public int contar(Celula i){
		int resp;
		if(i == null)
			return 0;

		else if(i.elemento % 2 == 0 && i.elemento == 0)
			resp = 1 + contar(i.prox);

		else
			resp = contar(i.prox);

		return resp;
	}

	public void metodoDoidao(){
		Celula fim = ultimo;
		while(primeiro != fim){
			ultimo.prox = new Celula(primeiro.prox.elemento);
			Celula tmp = primeiro;
			primeiro = primeiro.prox;
			tmp = tmp.prox = null;
			ultimo = ultimo.prox;
		}
		fim = null;
	}

	public Celula toFila(Celula topo){
		Celula primeiro = new Celula();
		Celula ultimo = primeiro;
		ultimo = toFila(topo,ultimo);
		return primeiro;
	}

	public Celula toFila(Celula i, Celula ultimo){
		if( i != null){
			ultimo = toFila(i.prox,ultimo);
			ultimo.prox = new Celula(i.elemento);
			ultimo = ultimo.prox;
		}
		return ultimo;
	}

	public static void main(String[] args) throws Exception{
		Fila fila = new Fila();

    		// Inserindo elementos
    		fila.inserir(10);
    		fila.inserir(21);
    		fila.inserir(32);
    		fila.inserir(45);
    
    		System.out.print("Fila atual: ");
    		fila.mostrar(); 

    		// Testando consultas
    		System.out.println("Soma dos elementos: " + fila.somar());
    		System.out.println("Maior elemento: " + fila.maior());
    		System.out.println("Terceiro da fila: " + fila.retornarTerceiro());
    		System.out.println("Qtd de números pares: " + fila.contar());

    		// Testando remoções
    		int r1 = fila.remover();
    		System.out.println("Removido (Lógico): " + r1);
    
    		int r2 = fila.removerFisicamente();
    		System.out.println("Removido (Físico): " + r2);

    		System.out.print("Fila final: ");
    		fila.mostrar();
	}
}
