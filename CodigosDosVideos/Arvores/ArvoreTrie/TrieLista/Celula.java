class Celula {
	public char elemento; // Elemento inserido na celula.
	public Celula prox; // Aponta a celula prox.
	public No no;


	/**
	 * Construtor da classe.
	 */
	public Celula() {
		this.elemento = 0;
		this.prox = null;
		this.no = null;
	}

	/**
	 * Construtor da classe.
	 * @param elemento char inserido na celula.
	 */
	public Celula(char elemento) {
		this.elemento = elemento;
		this.prox = null;
		this.no = new No(elemento);
	}
}
