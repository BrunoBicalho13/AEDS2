#include <stdio.h>

int main() {
    int R;
    scanf("%d",&R);
    while (R != 0) {
        int mark[R], let[R];
        int somaMark = 0, somaLet = 0;
        int rodadaM = -1, rodadaL = -1; // inicializo com -1 pq a primeira rodada pode ser a vencedora

        for (int i = 0; i < R; i++) { // escaneio e somo mark
            scanf("%d", &mark[i]);
            somaMark += mark[i];
        }
        for (int i = 0; i < R; i++) { // escaneio e somo let
            scanf("%d", &let[i]);
            somaLet += let[i];
        }

        for (int i = 0; i <= R - 3; i++) {
            if (mark[i] == mark[i + 1] && mark[i] == mark[i + 2]) { 
                rodadaM = i; // salvo o indice onde mark conseguiu 3 iguais primeiro
                break;
            }
        }

        for (int i = 0; i <= R - 3; i++) {
            if (let[i] == let[i + 1] && let[i] == let[i + 2]) {
                rodadaL = i; // salvo o indice onde let conseguiu 3 iguais primeiro
                break;
            }
        }

        if (rodadaM != -1 && (rodadaL == -1 || rodadaM < rodadaL)) {
            somaMark += 30;
        } else if (rodadaL != -1 && (rodadaM == -1 || rodadaL < rodadaM)) {
            somaLet += 30;
        }

        if (somaMark > somaLet) printf("M\n");
        else if (somaLet > somaMark) printf("L\n");
        else printf("T\n");
    	scanf("%d",&R);
    }

    return 0;
}
