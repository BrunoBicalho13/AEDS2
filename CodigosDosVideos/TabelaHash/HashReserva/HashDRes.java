class HashDRes{
	int tabela[];
	int m1,m2,m,reserva;
	final int NULO = -1;

	public HashDRes(){
		this(13,7);
	}

	public HashDRes(int m1, int m2){
		this.m1 = m1;//tamanho tabela
		this.m2 = m2;//tamanho reserva
		this.m = m1 + m2;
		this.tabela = new int[this.m];
		for(int i = 0; i < m1; i++){
			tabela[i] = NULO;
		}
		reserva = 0;
	}

	public int h(int elemento){
		return elemento % m1;
	}

	public boolean inserir(int elemento){
		boolean resp = false;
		if(elemento != NULO){
			int pos = h(elemento);
			if(tabela[pos] == NULO){
				tabela[pos] = elemento;
				resp = true;
			}else if( reserva < m2){
				tabela[m1 + reserva] = elemento;
				reserva++;
				resp = true;
			}
		}
		return resp;
	}

	public boolean pesquisar(int elemento){
		boolean resp = false;
		int pos = h(elemento);
		if(tabela[pos] == elemento){
			resp = true;
		}else if(tabela[pos] != NULO){
			for(int i = 0; i < reserva; i++){
				if(tabela[m1 + i] == elemento){
					resp = true;
					i = reserva;
				}
			}

		}
		return resp;
	}

	public boolean remover(int elemento){
		boolean resp = false;
		int pos = h(elemento);

		if(tabela[pos] == elemento){
			// achou na posicao principal
			tabela[pos] = NULO;
			resp = true;

			// se existir algum elemento na reserva com o mesmo hash,
			// promove ele para a posicao principal, senao a pesquisa
			// para de procurar na reserva (pesquisar só olha a reserva
			// quando tabela[pos] != NULO)
			for(int i = 0; i < reserva; i++){
				if(h(tabela[m1 + i]) == pos){
					tabela[pos] = tabela[m1 + i];
					removerDaReserva(i);
					break;
				}
			}
		}else if(tabela[pos] != NULO){
			// procura na area de reserva
			for(int i = 0; i < reserva; i++){
				if(tabela[m1 + i] == elemento){
					removerDaReserva(i);
					resp = true;
					break;
				}
			}
		}

		return resp;
	}

	// remove o elemento da posicao i da reserva, deslocando os
	// elementos seguintes para preencher o "buraco"
	private void removerDaReserva(int i){
		for(int j = i; j < reserva - 1; j++){
			tabela[m1 + j] = tabela[m1 + j + 1];
		}
		tabela[m1 + reserva - 1] = NULO;
		reserva--;
	}

	public static void main(String[] args){
		HashDRes hash = new HashDRes(13, 7);

		System.out.println("=== Teste de insercao ===");
		int[] elementos = {10, 23, 36, 5, 18, 31, 44, 7};
		// 10 % 13 = 10
		// 23 % 13 = 10  -> colide com 10, vai pra reserva
		// 36 % 13 = 10  -> colide tambem, vai pra reserva
		// 5  % 13 = 5
		// 18 % 13 = 5   -> colide com 5, vai pra reserva
		// 31 % 13 = 5   -> colide tambem, vai pra reserva
		// 44 % 13 = 5   -> colide tambem, vai pra reserva
		// 7  % 13 = 7

		for (int e : elementos) {
			boolean ok = hash.inserir(e);
			System.out.println("Inserir " + e + " (hash=" + hash.h(e) + ") -> " + ok);
		}

		imprimirTabela(hash);

		System.out.println("\n=== Teste de pesquisa ===");
		int[] pesquisar = {10, 23, 36, 5, 18, 31, 44, 7, 999};
		for (int e : pesquisar) {
			System.out.println("Pesquisar " + e + " -> " + hash.pesquisar(e));
		}

		System.out.println("\n=== Teste de remocao ===");

		// remover elemento que esta na posicao principal sem colisao (7)
		System.out.println("Remover 7 -> " + hash.remover(7));
		System.out.println("Pesquisar 7 apos remover -> " + hash.pesquisar(7));

		// remover elemento da area de reserva (23)
		System.out.println("Remover 23 -> " + hash.remover(23));
		System.out.println("Pesquisar 23 apos remover -> " + hash.pesquisar(23));
		System.out.println("Pesquisar 36 (continua na reserva) -> " + hash.pesquisar(36));

		// remover elemento da posicao principal que tem "substitutos" na reserva (10)
		System.out.println("Remover 10 -> " + hash.remover(10));
		System.out.println("Pesquisar 10 apos remover -> " + hash.pesquisar(10));
		System.out.println("Pesquisar 36 apos promocao -> " + hash.pesquisar(36));

		imprimirTabela(hash);

		// remover elemento inexistente
		System.out.println("\nRemover 999 (nao existe) -> " + hash.remover(999));

		// remover elemento ja removido
		System.out.println("Remover 10 de novo (ja removido) -> " + hash.remover(10));
	}

	private static void imprimirTabela(HashDRes hash) {
		System.out.println("\nEstado da tabela:");
		for (int i = 0; i < hash.tabela.length; i++) {
			String area = (i < hash.m1) ? "principal" : "reserva";
			System.out.println("  [" + i + "] (" + area + ") = " + hash.tabela[i]);
		}
		System.out.println("reserva ocupada: " + hash.reserva + "/" + hash.m2);



	}
}

