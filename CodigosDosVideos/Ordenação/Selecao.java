import java.util.*;

public class Selecao {

    int[] array;
    int n;

    public Selecao(int[] array) {
        this.array = array;
        this.n = array.length;
    }

    public void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void sort() {
        for (int i = 0; i < (n - 1); i++) {
            int menor = i;

            for (int j = i + 1; j < n; j++) {
                if (array[menor] > array[j]) {
                    menor = j;
                }
            }

            swap(menor, i);
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

        Selecao s = new Selecao(array);

        s.print();  // antes
        s.sort();   // ordena
        s.print();  // depois
    }
}
