import java.util.*;

public class Insercao {

    int[] array;
    int n;

    public Insercao(int[] array) {
        this.array = array;
        this.n = array.length;
    }

    public void sort() {
        for (int i = 1; i < n; i++) {
            int chave = array[i];
            int j = i - 1;

            // Move os elementos maiores para frente
            while (j >= 0 && array[j] > chave) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = chave;
        }
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[5];

        for (int i = 0; i < 5; i++) {
            array[i] = sc.nextInt();
        }

        Insercao s = new Insercao(array);

        s.print();  // antes
        s.sort();   // ordena
        s.print();  // depois
    }
}
