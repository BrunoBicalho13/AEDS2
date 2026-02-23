import java.util.Scanner;

public class Lab1_2 {

    static int contaMaiusculas(String s, int i) {

    // caso base
    if (i == s.length()) {
        return 0;
    }

    if (Character.isUpperCase(s.charAt(i))) {
        return 1 + contaMaiusculas(s, i + 1);
    } else {
        return contaMaiusculas(s, i + 1);
    }
}

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String string1 = sc.nextLine();

            if (string1.equals("FIM")) break;

            int maiusculas = contaMaiusculas(string1, 0);
            System.out.println(maiusculas);
        }

        sc.close();
    }
}