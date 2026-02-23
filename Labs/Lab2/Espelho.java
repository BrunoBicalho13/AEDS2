
import java.util.Scanner;

public class Espelho {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1,num2;
        num1 = sc.nextInt();
        num2 = sc.nextInt();

        for(int i = num1; i <= num2;i++){
            System.out.println(i);
        }

        for(int i = num2; i >= num1;i--){
            System.out.println(i);
        }

    }
}
