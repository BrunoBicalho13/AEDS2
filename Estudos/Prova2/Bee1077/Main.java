import java.util.Scanner;

public class Main {

    static char[] pilha = new char[1100];
    static int topo = -1;

    static void push(char c) {
        pilha[++topo] = c;
    }

    static char pop() {
        return pilha[topo--];
    }

    static char peek() {
        return pilha[topo];
    }

    static boolean vazia() {
        return topo == -1;
    }

    // Retorna a precedência de um operador
    static int precedencia(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        if (op == '^') return 3;
        return 0;
    }

    // '^' é associativo à direita; os demais, à esquerda
    static boolean associaDireita(char op) {
        return op == '^';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int t = 0; t < n; t++) {
            String expressao = sc.nextLine();

            topo = -1; // reseta a pilha para o novo caso de teste
            char[] saida = new char[expressao.length() + 10];
            int posSaida = 0;

            for (int i = 0; i < expressao.length(); i++) {
                char c = expressao.charAt(i);

                if (Character.isLetterOrDigit(c)) {
                    saida[posSaida++] = c;
                } else if (c == '(') {
                    push(c);
                } else if (c == ')') {
                    while (!vazia() && peek() != '(') {
                        saida[posSaida++] = pop();
                    }
                    if (!vazia()) {
                        pop(); // remove o '('
                    }
                } else {
                    // operador: +, -, *, /, ^
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

            System.out.println(new String(saida, 0, posSaida));
        }
    }
}
