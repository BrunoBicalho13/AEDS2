import java.util.*;
public class PilhaFlex{
	private Celula topo;
	
	public PilhaFlex(){
		topo = null;
	}
	
	public void inserir(int x){
		Celula tmp = new Celula(x);
		tmp.prox = topo;
		topo = tmp;
		tmp = null;
	}

	public int remover() throws Exception{
		if(topo == null)
			throw new Exception("Pilha Vazia!");

		int elemento = topo.elemento;
		Celula tmp = topo;
		topo = topo.prox;
		tmp.prox = null;
		tmp = null;
		
		return elemento;
	}

	public void mostrar(){
		System.out.print("[ ");
		
		for(Celula i = topo; i != null; i = i.prox){
			System.out.print(i.elemento + " ");
		}
		
		System.out.println("]");
	}

	int somar(){
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
		if(i != null){
			System.out.print(i.elemento + " ");
			mostrarRec(i.prox);
		}
	}

	public void mostrarRecEnvio(){
		System.out.print("[ ");
		mostrarRecEnvio(topo);
		System.out.println("]");
	}

	public void mostrarRecEnvio(Celula i){
		if(i != null){
			mostrarRecEnvio(i.prox);
			System.out.print(i.elemento + " ");
		}
	}

	
}

