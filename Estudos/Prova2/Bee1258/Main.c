#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Estrutura para armazenar os dados de cada pedido
typedef struct {
    char nome[100];
    char cor[20];
    char tamanho;
} Camiseta;

// Função de comparação para o qsort
int compare(const void* a, const void* b) {
    Camiseta* c1 = (Camiseta*)a;
    Camiseta* c2 = (Camiseta*)b;
    
    // 1º Critério: Cor ascendente
    int comp_cor = strcmp(c1->cor, c2->cor);
    if (comp_cor != 0) return comp_cor;
    
    // 2º Critério: Tamanho decrescente ('P' > 'M' > 'G' na tabela ASCII)
    if (c1->tamanho != c2->tamanho) {
        return (c2->tamanho - c1->tamanho);
    }
    
    // 3º Critério: Nome ascendente
    return strcmp(c1->nome, c2->nome);
}

int main() {
    int n;
    int primeiro = 1;
    
    // O programa termina quando N for igual a 0
    while (scanf("%d", &n) == 1 && n != 0) {
        // Imprime linha em branco ENTRE os casos de teste
        if (!primeiro) {
            printf("\n");
        }
        primeiro = 0;
        
        // Aloca dinamicamente o vetor com base na quantidade N fornecida
        Camiseta* camisetas = (Camiseta*)malloc(n * sizeof(Camiseta));
        
        for (int i = 0; i < n; i++) {
            // " %[^\n]" lê toda a linha do nome ignorando quebras de linha anteriores
            scanf(" %[^\n]", camisetas[i].nome); 
            scanf("%s %c", camisetas[i].cor, &camisetas[i].tamanho);
        }
        
        // Ordena o vetor usando o algoritmo Quicksort nativo do C
        qsort(camisetas, n, sizeof(Camiseta), compare);
        
        // Impressão dos resultados conforme a especificação
        for (int i = 0; i < n; i++) {
            printf("%s %c %s\n", camisetas[i].cor, camisetas[i].tamanho, camisetas[i].nome);
        }
        
        free(camisetas); // Libera a memória alocada
    }
    
    return 0;
}
