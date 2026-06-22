#include <stdio.h>
 
int main(void) {
    int n;
    char linha[1100];
 
    scanf("%d", &n);
 
    while (n--) {
        scanf("%s", linha);
 
        int left = 0;   /* quantidade de '<' encontrados até agora       */
        int right = 0;  /* quantidade de diamantes formados (pares '<>') */
 
        for (int i = 0; linha[i] != '\0'; i++) {
            if (linha[i] == '<') {
                left++;
            } else if (linha[i] == '>') {
                if (left > right) {
                    right++;
                }
            }
            /* '.' (areia) é simplesmente ignorado */
        }
 
        printf("%d\n", right);
    }
 
    return 0;
}

