#include <stdio.h>
#include <string.h>
#include <ctype.h>
 
#define MAX 1100
 
char pilha[MAX];
int topo = -1;
 
void push(char c) {
    pilha[++topo] = c;
}
 
char pop(void) {
    return pilha[topo--];
}
 
char peek(void) {
    return pilha[topo];
}
 
int vazia(void) {
    return topo == -1;
}
 
/* Retorna a precedência de um operador */
int precedencia(char op) {
    if (op == '+' || op == '-') return 1;
    if (op == '*' || op == '/') return 2;
    if (op == '^') return 3;
    return 0;
}
 
/* '^' é associativo à direita; os demais, à esquerda */
int associaDireita(char op) {
    return op == '^';
}
 
int main(void) {
    int n;
    char expressao[MAX];
    char saida[MAX];
 
    scanf("%d", &n);
 
    while (n--) {
        scanf("%s", expressao);
 
        topo = -1; /* reseta a pilha para o novo caso de teste */
        int tamExpr = strlen(expressao);
        int posSaida = 0;
 
        for (int i = 0; i < tamExpr; i++) {
            char c = expressao[i];
 
            if (isalnum((unsigned char) c)) {
                saida[posSaida++] = c;
            } else if (c == '(') {
                push(c);
            } else if (c == ')') {
                while (!vazia() && peek() != '(') {
                    saida[posSaida++] = pop();
                }
                if (!vazia()) {
                    pop(); /* remove o '(' */
                }
            } else {
                /* operador: +, -, *, /, ^ */
                while (!vazia() && peek() != '(' &&
                       (precedencia(peek()) > precedencia(c) ||
                        (precedencia(peek()) == precedencia(c) && !associaDireita(c)))) {
                    saida[posSaida++] = pop();
                }
                push(c);
            }
        }
 
        while (!vazia()) {
            saida[posSaida++] = pop();
        }
 
        saida[posSaida] = '\0';
        printf("%s\n", saida);
    }
 
    return 0;
}

