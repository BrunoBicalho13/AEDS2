import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = Integer.parseInt(sc.nextLine().trim());

            String[] telefones = new String[n];
            for (int i = 0; i < n; i++) {
                telefones[i] = sc.nextLine().trim();
            }

            Arrays.sort(telefones);

            long economizado = 0;

            for (int i = 1; i < n; i++) {
                String anterior = telefones[i - 1];
                String atual = telefones[i];

                int tam = Math.min(anterior.length(), atual.length());
                int j = 0;
                while (j < tam && anterior.charAt(j) == atual.charAt(j)) {
                    economizado++;
                    j++;
                }
            }

            System.out.println(economizado);
        }
    }
}
