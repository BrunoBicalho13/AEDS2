#include <stdio.h>
#include <stdlib.h>

int main() {
    int tamA, tamB;

    if (scanf("%d %d", &tamA, &tamB) != 2) return 0;

    int *sa = (int *)malloc(tamA * sizeof(int));
    int *sb = (int *)malloc(tamB * sizeof(int));

    // Leitura da sequência SA
    for (int i = 0; i < tamA; i++) {
        scanf("%d", &sa[i]);
    }

    // Leitura da sequência SB
    for (int i = 0; i < tamB; i++) {
        scanf("%d", &sb[i]);
    }

    int ponteiroB = 0;

    // Percorremos SA uma única vez - Complexidade O(A)
    for (int i = 0; i < tamA; i++) {
        // Se encontramos o elemento que o ponteiroB está buscando
        if (sa[i] == sb[ponteiroB]) {
            ponteiroB++;
        }

        // Se já encontramos todos os elementos de SB, podemos parar
        if (ponteiroB == tamB) {
            break;
        }
    }

    // Verificação final: se o ponteiro chegou ao fim de SB, é uma subsequência
    if (ponteiroB == tamB) {
        printf("S\n");
    } else {
        printf("N\n");
    }

    free(sa);
    free(sb);

    return 0;
}
