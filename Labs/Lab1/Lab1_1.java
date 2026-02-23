import java.util.Scanner;

public class Lab1_1 {

    static int contaMaiusculas(String string) {
        int maiusculas = 0;
        for (int i = 0; i < string.length(); i++) {
            if (Character.isUpperCase(string.charAt(i))) {
                maiusculas++;
            }
        }
        return maiusculas;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String string1 = sc.nextLine();

            if (string1.equals("FIM")) break;

            int maiusculas = contaMaiusculas(string1);
            System.out.println(maiusculas);
        }

        sc.close();
    }
}
