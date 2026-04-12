import java.util.*;
public class Ex12{
	
	public static int somaDigitos(int n){
		if (n == 0)
			return 0;

		else
			return (n % 10) + somaDigitos(n/10);
	}


	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String string;

		while(sc.hasNext()){
			string = sc.next();
			int num = Integer.parseInt(string);

			System.out.println(somaDigitos(num));
		}

		sc.close();
	}
}
