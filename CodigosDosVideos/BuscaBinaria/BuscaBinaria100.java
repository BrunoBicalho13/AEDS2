package CodigosDosVideos.BuscaBinaria;

import java.util.Random;

public class BuscaBinaria100 {

    static final int TAM = 100;
    static int[] vetor = new int[TAM];

    public static void main(String[] args) {

        // Preenche o vetor
        preencheVetor();
        System.out.println("Vetor original:");
        printVetor();

        // Ordena o vetor
        ordenaVetor();
        System.out.println("\nVetor ordenado:");
        printVetor();

        // Valor para buscar (exemplo)
        int valorBuscado = vetor[30];

        int resultado = buscaBinariaRecursiva(vetor, 0, TAM - 1, valorBuscado);

        if (resultado != -1) {
            System.out.println("\nValor " + valorBuscado + " encontrado na posição: " + resultado);
        } else {
            System.out.println("\nValor não encontrado.");
        }
    }

    // Preenche o vetor com números aleatórios
    public static void preencheVetor() {
        Random rand = new Random();
        for (int i = 0; i < TAM; i++) {
            vetor[i] = rand.nextInt(1000);
        }
    }

    // Ordena usando Bubble Sort
    public static void ordenaVetor() {
        for (int i = 0; i < TAM - 1; i++) {
            for (int j = 0; j < TAM - 1 - i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }
    }

    // Imprime o vetor
    public static void printVetor() {
        for (int i = 0; i < TAM; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }

    // Busca Binária Recursiva
    public static int buscaBinariaRecursiva(int[] v, int inicio, int fim, int valor) {

        if (inicio > fim)
            return -1;

        int meio = (inicio + fim) / 2;

        if (v[meio] == valor)
            return meio;

        if (valor < v[meio])
            return buscaBinariaRecursiva(v, inicio, meio - 1, valor);
        else
            return buscaBinariaRecursiva(v, meio + 1, fim, valor);
    }
}
