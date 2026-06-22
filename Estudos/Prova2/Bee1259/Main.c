#include <stdio.h>
#include <stdlib.h>

// Função de comparação para o qsort com múltiplos critérios
int compare(const void *a, const void *b) {
    int x = *(const int *)a;
    int y = *(const int *)b;
    
    // 1º Caso: Ambos são pares -> ordem crescente
    if (x % 2 == 0 && y % 2 == 0) {
        return x - y;
    }
    
    // 2º Caso: Ambos são ímpares -> ordem decrescente
    if (x % 2 != 0 && y % 2 != 0) {
        return y - x;
    }
    
    // 3º Caso: Um é par e o outro é ímpar -> o par tem prioridade
    if (x % 2 == 0) {
        return -1; // x (par) vem antes de y (ímpar)
    } else {
        return 1;  // x (ímpar) vai para depois de y (par)
    }
}

int main() {
    int n;
    
    // Leitura da quantidade de números
    if (scanf("%d", &n) != 1) return 0;
    
    // Alocação dinâmica do vetor principal
    int *arr = (int *)malloc(n * sizeof(int));
    
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }
    
    // Ordenação $O(N \log N)$
    qsort(arr, n, sizeof(int), compare);
    
    // Impressão dos resultados
    for (int i = 0; i < n; i++) {
        printf("%d\n", arr[i]);
    }
    
    free(arr);
    return 0;
}
