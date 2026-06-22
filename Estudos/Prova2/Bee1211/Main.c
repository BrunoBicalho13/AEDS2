#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define MAX_N 100005
#define MAX_LEN 205

char telefones[MAX_N][MAX_LEN];

int comparar(const void *a, const void *b) {
    return strcmp((const char *) a, (const char *) b);
}

int main(void) {
    long n;

    while (scanf("%ld", &n) != EOF) {
        for (long i = 0; i < n; i++) {
            scanf("%s", telefones[i]);
        }

        qsort(telefones, (size_t) n, sizeof(telefones[0]), comparar);

        long economizado = 0;

        for (long i = 1; i < n; i++) {
            char *anterior = telefones[i - 1];
            char *atual = telefones[i];

            int j = 0;
            while (anterior[j] != '\0' && atual[j] != '\0' && anterior[j] == atual[j]) {
                economizado++;
                j++;
            }
        }

        printf("%ld\n", economizado);
    }

    return 0;
}
