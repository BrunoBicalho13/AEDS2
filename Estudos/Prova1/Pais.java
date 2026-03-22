import java.util.*;

class Pais {
    String nome;
    int ouro, prata, bronze;

    Pais(String nome, int ouro, int prata, int bronze) {
        this.nome = nome;
        this.ouro = ouro;
        this.prata = prata;
        this.bronze = bronze;
    }
}

public class QuadroMedalhasManual {

    public static void bubbleSort(Pais[] lista) {
        int n = lista.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (precisaTrocar(lista[j], lista[j + 1])) {
                    Pais temp = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = temp;
                }
            }
        }
    }

    private static int compararNomes(String s1, String s2) {
        int tamanhoMinimo = Math.min(s1.length(), s2.length());

        for (int i = 0; i < tamanhoMinimo; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (c1 != c2) {
                return c1 - c2; // Retorna a diferença numérica dos caracteres
            }
        }
        return s1.length() - s2.length();
    }

    private static boolean precisaTrocar(Pais p1, Pais p2) {
        // 1. Ouro (Maior primeiro)
        if (p1.ouro < p2.ouro) return true;
        if (p1.ouro > p2.ouro) return false;

        // 2. Prata (Maior primeiro)
        if (p1.prata < p2.prata) return true;
        if (p1.prata > p2.prata) return false;

        // 3. Bronze (Maior primeiro)
        if (p1.bronze < p2.bronze) return true;
        if (p1.bronze > p2.bronze) return false;

        // 4. Nome (Ordem Alfabética manual)
        return compararNomes(p1.nome, p2.nome) > 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        Pais[] lista = new Pais[n];

        for (int i = 0; i < n; i++) {
            lista[i] = new Pais(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        bubbleSort(lista);

        for (int i = 0; i < n; i++) {
            System.out.println(lista[i].nome + " " + lista[i].ouro + " " + 
                               lista[i].prata + " " + lista[i].bronze);
        }
        
        sc.close();
    }
}
