import java.util.*;

class Pilha{
	public Celula topo;

	public Pilha(){
		topo = null;
	}

	public void inserir(int x){
		Celula tmp = new Celula(x); // Cria uma célula nova
		tmp.prox = topo; // aponta essa célula para a célula que topo aponta
		topo = tmp; // Faz topo apontar para tmp
		tmp = null; // remove o apontamento de tmp
	}

	public int remover() throws Exception{
		if(topo == null)
			throw new Exception("Vazia!");

		int elemento = topo.elemento; //marca o elemento de cima da pilha para retorno
		Celula tmp = topo;
		topo = topo.prox; // faz topo apontar pra a célula de baixo, que agora será a ultima
		tmp.prox = null;// tira o apontamento
		tmp = null;//tira o apontamento
		return elemento;
	}

	public void mostrar(){
		System.out.print("[ ");
		for(Celula i = topo; i != null; i = i.prox){
			System.out.print(i. elemento + " ");
		}

		System.out.println(" ]");
	}

	public int somar(){
		int resp = 0;
		for(Celula i = topo; i != null; i = i.prox){
			resp += i.elemento;
		}
		return resp;
	}
	


	public void mostrarRec(){
		System.out.print("[ ");
		mostrarRec(topo);
		System.out.println(" ]");
	}


	public void mostrarRec(Celula i){
		if( i != null){
			System.out.print(i.elemento + " ");//se inverter, printo na ordem de inserção	
			mostrarRec(i.prox);
		}
	}

	public int somarRec(Celula i){ // passa Topo como parâmetro 
		if(i == null)
			return 0;

		else
			return i.elemento + somarRec(i.prox);
	}
	
	public int maior(){
		int maior = topo.elemento;

		for(Celula i = topo; i.prox != null; i = i.prox){
			if(maior < i.elemento)
				maior = i.elemento;
		}
		
		return maior;
	}


	public int maiorRec(Celula i, int maior) {//Passa topo e topo.prox 
    		if (i == null) {
        		return maior;
    		}
    
    		if (i.elemento > maior) {
        		maior = i.elemento;
    		}
    
    		return maiorRec(i.prox, maior);
}

	public static void main(String[] args) throws Exception{
		Pilha pilha = new Pilha();

		pilha.inserir(3);
		pilha.inserir(5);
		pilha.inserir(4);
		pilha.mostrar();
		
		pilha.remover();
		pilha.mostrar();
		int soma1,soma2,maior1,maior2;
		soma1 = pilha.somar();
		soma2 = pilha.somarRec(pilha.topo);
		maior1 = pilha.maior();
		maior2 = pilha.maiorRec(pilha.topo,pilha.topo.elemento);

		System.out.println(soma1 + " " +  soma2 + " " + maior1 + " " + maior2);
	}

}















