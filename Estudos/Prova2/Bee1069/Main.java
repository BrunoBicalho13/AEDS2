import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
 
        for (int t = 0; t < n; t++) {
            String linha = sc.nextLine();
 
            int left = 0;   // quantidade de '<' encontrados até agora
            int right = 0;  // quantidade de diamantes formados (pares '<' '>')
 
            for (int i = 0; i < linha.length(); i++) {
                char c = linha.charAt(i);
                if (c == '<') {
                    left++;
                } else if (c == '>') {
                    if (left > right) {
                        right++;
                    }
                }
                // '.' (areia) é simplesmente ignorado
            }
 
            System.out.println(right);
        }
    }
}

