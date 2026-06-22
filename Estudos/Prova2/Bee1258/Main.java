import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    // Classe interna para representar o pedido de camiseta
    static class Camiseta {
        String nome;
        String cor;
        char tamanho;

        Camiseta(String nome, String cor, char tamanho) {
            this.nome = nome;
            this.cor = cor;
            this.tamanho = tamanho;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean primeiro = true;

        while (scanner.hasNextLine()) {
            String linhaN = scanner.nextLine().trim();
            if (linhaN.isEmpty()) continue;
            
            int n = Integer.parseInt(linhaN);
            if (n == 0) break; // Condição de parada

            // Imprime linha em branco ENTRE os casos de teste
            if (!primeiro) {
                System.out.println();
            }
            primeiro = false;

            // Uso de vetor puro de tamanho fixo N
            Camiseta[] camisetas = new Camiseta[n];

            for (int i = 0; i < n; i++) {
                String nome = scanner.nextLine().trim();
                
                // Lê a linha com a cor e o tamanho e divide pelo espaço em branco
                String[] detalhes = scanner.nextLine().trim().split("\\s+");
                String cor = detalhes[0];
                char tamanho = detalhes[1].charAt(0);

                camisetas[i] = new Camiseta(nome, cor, tamanho);
            }

            // Ordenação personalizada utilizando Arrays.sort
            Arrays.sort(camisetas, (c1, c2) -> {
                // 1º Critério: Cor ascendente
                int compCor = c1.cor.compareTo(c2.cor);
                if (compCor != 0) return compCor;
                
                // 2º Critério: Tamanho decrescente (c2 comparado com c1 inverte a ordem)
                if (c1.tamanho != c2.tamanho) {
                    return Character.compare(c2.tamanho, c1.tamanho);
                }
                
                // 3º Critério: Nome ascendente
                return c1.nome.compareTo(c2.nome);
            });

            // Impressão dos resultados
            for (Camiseta c : camisetas) {
                System.out.println(c.cor + " " + c.tamanho + " " + c.nome);
            }
        }
        
        scanner.close();
    }
}
