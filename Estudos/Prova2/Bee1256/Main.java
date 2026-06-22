import java.util.Scanner;

public class Main {
    
    // Classe interna para simular o nó da lista encadeada
    static class Node {
        int val;
        Node next;
        
        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        for (int t = 0; t < n; t++) {
            int m = scanner.nextInt(); // Tamanho da base
            int c = scanner.nextInt(); // Quantidade de chaves
            
            // Vetor para os "cabeçalhos" (início) de cada lista na Tabela Hash
            Node[] table = new Node[m];
            
            // Vetor para guardar as "caudas" (finais) de cada lista. 
            // Isso permite inserir no final da lista com complexidade O(1).
            Node[] tails = new Node[m];
            
            // Lê as chaves e insere na posição correspondente
            for (int i = 0; i < c; i++) {
                int val = scanner.nextInt();
                int idx = val % m; // Função Hash: H(x) = x mod M
                
                Node newNode = new Node(val);
                
                // Se a posição estiver vazia, o novo nó é tanto o início quanto o fim
                if (table[idx] == null) {
                    table[idx] = newNode;
                    tails[idx] = newNode;
                } else {
                    // Se já tem elementos, conectamos ao final e atualizamos a cauda
                    tails[idx].next = newNode;
                    tails[idx] = newNode;
                }
            }
            
            // Imprime o resultado formatado
            for (int i = 0; i < m; i++) {
                System.out.print(i + " -> ");
                
                Node curr = table[i];
                // Percorre a lista encadeada daquela posição até o final
                while (curr != null) {
                    System.out.print(curr.val + " -> ");
                    curr = curr.next;
                }
                
                System.out.println("\\"); // Imprime a barra invertida
            }
            
            // Regra do Beecrowd: linha em branco entre os casos de teste
            if (t < n - 1) {
                System.out.println();
            }
        }
        
        scanner.close();
    }
}
