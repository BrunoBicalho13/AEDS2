public class AVL{
	private No raiz;
	
	public AVL(){
		raiz = null;
	}

	public boolean pesquisar(int x){
		return pesquisar(x,raiz);
	}

	private boolean pesquisar(int x, No i){
		boolean resp;
		if(i == null){
			resp = false;
		}else if(x == i.elemento){
			resp = true;
		}else if(x < i.elemento){
			resp = pesquisar(x, i.esq);
		}else{
			resp = pesquisar(x,i.dir);
		}
		return resp;
	}

	public void caminharCentral(No i){
		if(i != null){
			caminharCentral(i.esq);
			System.out.print(i.elemento + " ");
			caminharCentral(i.dir);
		}
	}

//	public void caminhar Pre

}
