import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        // Alocamos o tamanho máximo possível para cada array.
        // No pior caso, todos os números são pares ou todos são ímpares.
        int[] pares = new int[n];
        int[] impares = new int[n];
        
        // Contadores para saber exatamente quantos elementos há em cada array
        int countPares = 0;
        int countImpares = 0;
        
        // Leitura e separação em tempo $O(N)$
        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            if (val % 2 == 0) {
                pares[countPares++] = val;
            } else {
                impares[countImpares++] = val;
            }
        }
        
        // O Arrays.sort permite ordenar apenas a fatia preenchida do array.
        // Ambos ficam em ordem crescente nativamente.
        Arrays.sort(pares, 0, countPares);
        Arrays.sort(impares, 0, countImpares);
        
        // Imprime os pares (já estão em ordem crescente)
        for (int i = 0; i < countPares; i++) {
            System.out.println(pares[i]);
        }
        
        // Imprime os ímpares de trás para frente (ordem decrescente)
        for (int i = countImpares - 1; i >= 0; i--) {
            System.out.println(impares[i]);
        }
        
        scanner.close();
    }
}
