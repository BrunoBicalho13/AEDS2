public class Hash {
	int tabela[];
	int m;
	final int NULO = -1;

	public Hash() {
		this(13);
	}

	public Hash(int m) {
		this.m = m;
		this.tabela = new int[this.m];
		for (int i = 0; i < m; i++) {
			tabela[i] = NULO;
		}
	}

	public int h(int elemento) {
		return elemento % m;
	}

	public int reh(int elemento) {
		return ++elemento % m;
	}

	public boolean inserir(int elemento) {
		boolean resp = false;
		if (elemento != NULO) {
			int pos = h(elemento);
			if (tabela[pos] == NULO) {
				tabela[pos] = elemento;
				resp = true;
			} else {
				pos = reh(elemento);
				if (tabela[pos] == NULO) {
					tabela[pos] = elemento;
					resp = true;
				}
			}
		}
		return resp;
	}

	public boolean pesquisar(int elemento) {
		boolean resp = false;
		int pos = h(elemento);
		if (tabela[pos] == elemento) {
			resp = true;
		} else if (tabela[pos] != NULO) {
			pos = reh(elemento);
			if (tabela[pos] == elemento) {
				resp = true;
			}
		}
		return resp;
	}

	boolean remover(int elemento) {
		boolean resp = false;
		int pos = h(elemento);

		if (tabela[pos] == elemento) {
			tabela[pos] = NULO;
			resp = true;
		} else if (tabela[pos] != NULO) {
			pos = reh(elemento);
			if (tabela[pos] == elemento) {
				tabela[pos] = NULO;
				resp = true;
			}
		}

		return resp;
	}

	public static void main(String[] args) {
		Hash hash = new Hash(13);

		System.out.println("=== Teste de insercao ===");
		// 10 % 13 = 10
		// 23 % 13 = 10  -> colide, reh(23) = 24 % 13 = 11
		// 5  % 13 = 5
		// 18 % 13 = 5   -> colide, reh(18) = 19 % 13 = 6
		// 7  % 13 = 7
		int[] elementos = {10, 23, 5, 18, 7};
		for (int e : elementos) {
			boolean ok = hash.inserir(e);
			System.out.println("Inserir " + e + " (h=" + hash.h(e) + ", reh=" + hash.reh(e) + ") -> " + ok);
		}

		imprimirTabela(hash);

		System.out.println("\n=== Teste de insercao com colisao dupla (sem espaco) ===");
		// 36 % 13 = 10 (ocupado por 10) -> reh(36) = 37 % 13 = 11 (ocupado por 23) -> falha
		boolean ok = hash.inserir(36);
		System.out.println("Inserir 36 -> " + ok + " (esperado false, h e reh ja ocupados)");

		System.out.println("\n=== Teste de pesquisa ===");
		int[] pesquisar = {10, 23, 5, 18, 7, 999};
		for (int e : pesquisar) {
			System.out.println("Pesquisar " + e + " -> " + hash.pesquisar(e));
		}

		System.out.println("\n=== Teste de remocao ===");

		// remover elemento direto na posicao principal (7)
		System.out.println("Remover 7 -> " + hash.remover(7));
		System.out.println("Pesquisar 7 apos remover -> " + hash.pesquisar(7));

		// remover elemento que esta na posicao de rehash (23)
		System.out.println("Remover 23 -> " + hash.remover(23));
		System.out.println("Pesquisar 23 apos remover -> " + hash.pesquisar(23));

		// 10 continua acessivel normalmente (nao foi afetado)
		System.out.println("Pesquisar 10 (nao removido) -> " + hash.pesquisar(10));

		// remover elemento inexistente
		System.out.println("Remover 999 (nao existe) -> " + hash.remover(999));

		// remover elemento ja removido
		System.out.println("Remover 7 de novo (ja removido) -> " + hash.remover(7));

		imprimirTabela(hash);
	}

	private static void imprimirTabela(Hash hash) {
		System.out.println("\nEstado da tabela:");
		for (int i = 0; i < hash.tabela.length; i++) {
			System.out.println("  [" + i + "] = " + hash.tabela[i]);
		}
	}


}

