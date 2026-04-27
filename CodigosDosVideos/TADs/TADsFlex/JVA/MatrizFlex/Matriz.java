class Matriz {
    	private Celula inicio;
    	private int linha, coluna;

    	public Matriz() {
        	this(3, 3);
    	}

    	public Matriz(int linha, int coluna) {
    		this.linha = linha;
    		this.coluna = coluna;

    		inicio = new Celula();

    		// Constroi a primeira linha
    		Celula atual = inicio;
    		for (int j = 1; j < coluna; j++) {
        		atual.dir = new Celula();
        		atual.dir.esq = atual;
        		atual = atual.dir;
    		}

    		// Constroi as linhas que faltam
    		Celula inicioLinhaAnterior = inicio;
    		for (int i = 1; i < linha; i++) {
        		Celula inicioLinhaAtual = new Celula(); // cria a celula nova
        		inicioLinhaAtual.sup = inicioLinhaAnterior;//conecta ela com as outras linhas
        		inicioLinhaAnterior.inf = inicioLinhaAtual;

        		Celula acima = inicioLinhaAnterior.dir;
        		atual = inicioLinhaAtual;
        		for (int j = 1; j < coluna; j++) {
            			atual.dir = new Celula();
           			atual.dir.esq = atual;
            			atual = atual.dir;
            			atual.sup = acima;
            			acima.inf = atual;
            			acima = acima.dir;
        		}

        		inicioLinhaAnterior = inicioLinhaAtual;
    		}

	}

    	// Ajuda pra contar quantas linhas existem pra baixo da celula inicio
    	private int countaLinhas(Celula c) {
        	int count = 0;
        	Celula tmp = inicio;
        	while (tmp != c) {
            		tmp = tmp.inf;
            		count++;
        	}
        	return count;
    	}

    	public void inserir(int elemento, int linha, int coluna) { // insere um elemento em uma linha/coluna especifica
        	Celula c = inicio;
        	for (; linha > 0; linha--) c = c.inf;
        	for (; coluna > 0; coluna--) c = c.dir;
        	c.elemento = elemento;
    	} 

    	public int obter(int linha, int coluna) { // retorna o valor de uma linha/coluna especifica
        	Celula c = inicio;
        	for (; linha > 0; linha--) c = c.inf;
        	for (; coluna > 0; coluna--) c = c.dir;
        	return c.elemento;
    	}

    	public Matriz soma(Matriz m) {
        	Matriz resp = null;

        	if (this.linha == m.linha && this.coluna == m.coluna) { // confere se o tamanho das matrizes são iguais 
            		resp = new Matriz(this.linha, this.coluna); // Se sim, cria uma matriz nova do mesmo tamanho

            		Celula iA = this.inicio; // Cria celulas novas que referenciam a celula de inicio de todas as matrizes (usaremos estas para iterar a matriz)
            		Celula iB = m.inicio;
            		Celula iC = resp.inicio;

            		for (; iA != null; iA = iA.inf, iB = iB.inf, iC = iC.inf) {// for de fora: anda "pra baixo" nas matrizes até a referencia inf ser null 
                		Celula a = iA;//Cria celulas novas que apontam para as criadas anteriormente
                		Celula b = iB;
                		Celula c = iC;

                		for (; a != null; a = a.dir, b = b.dir, c = c.dir) {//for de dentro: anda para a direita até a referencia dir ser null
                    			c.elemento = a.elemento + b.elemento; //soma os elementos das celulas a e b e coloca na celula c  
                		}	
            		}	
        	}

        	return resp; // retorna a matriz criada com os resultados da soma
    	}

	public int somaDentro() { //
                int soma = 0; 
		for (Celula i = inicio; i != null; i = i.inf) {
                         for (Celula j = i; j != null; j = j.dir) {
                                 soma += j.elemento;	 
                         }
                 }
		return soma;
      }


    	public void imprimir() { //imprime a matriz
        	for (Celula i = inicio; i != null; i = i.inf) {
            		for (Celula j = i; j != null; j = j.dir) {
                		System.out.printf("%4d", j.elemento);
            		}
            		System.out.println();
        	}
    	}

	public boolean isQuadrada(){
      		return (this.linha == this.coluna);
   	}

    	public static void main(String[] args) {
    		Matriz a = new Matriz(3, 3);
    		Matriz b = new Matriz(3, 3);

    		// Preenche a matriz a
    		int val = 1;
    		for (int i = 0; i < 3; i++)
        		for (int j = 0; j < 3; j++)
            			a.inserir(val++, i, j);

    		// Preencher matriz b
    		for (int i = 0; i < 3; i++)
        		for (int j = 0; j < 3; j++)
            			b.inserir(val++, i, j);

    		System.out.println("Matriz A:");
    		a.imprimir();

    		System.out.println("\nMatriz B:");
    		b.imprimir();

    		System.out.println("\nSoma de todos os elementos de A (somaDentro): " + a.somaDentro());

    		Matriz c = a.soma(b);
    		System.out.println("\nA + B:");
    		c.imprimir();
	}
}
