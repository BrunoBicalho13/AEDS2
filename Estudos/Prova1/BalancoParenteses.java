import java.util.Scanner;

public class BalancoParenteses {
    char[] array;
    int n;

    BalancoParenteses(int tamanho) {
        array = new char[tamanho];
        n = 0;
    }

    void push(char x) throws Exception{
        if(n >= array.length)
		throw new Exception ("Pilha cheia!");
        array[n++] = x;
    }

    char pop() throws Exception {
	if(n == 0)
		throw new Exception("Fila Vazia!");
        return array[--n];
    }

    // Verifica se os pares combinam
    boolean ePar(char abre, char fecha) {
        if (abre == '(' && fecha == ')') return true;
        if (abre == '[' && fecha == ']') return true;
        if (abre == '{' && fecha == '}') return true;
        return false;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a expressão:");
        String expressao = sc.next(); // Lê apenas a primeira palavra, para em espaços
        
        BalancoParenteses pilha = new BalancoParenteses(expressao.length());
        boolean valido = true;

        for (int i = 0; i < expressao.length(); i++) {
            char atual = expressao.charAt(i);

            // Se for abertura, empilha
            if (atual == '(' || atual == '[' || atual == '{') {
                pilha.push(atual);
            } 
            // Se for fechamento
            else if (atual == ')' || atual == ']' || atual == '}') {
                // Erro 1: Fechou algo mas a pilha está vazia
                if (pilha.n == 0) {
                    valido = false;
                    break;
                }

                char topo = pilha.pop();
                // Erro 2: O fechamento não combina com o último que abriu
                if (!pilha.ePar(topo, atual)) {
                    valido = false;
                    break;
                }
            }
        }

        // Erro 3: Sobrou algum símbolo de abertura sem fechar
        if (valido && pilha.n == 0) {
            System.out.println("Expressão Válida");
        } else {
            System.out.println("Expressão Inválida");
        }

        sc.close();
    }
}
