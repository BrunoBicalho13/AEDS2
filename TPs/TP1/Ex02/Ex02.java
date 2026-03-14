import java.util.*;
public class Ex02{
	public static void sub(String str1, String str2){
		
	}
	
	public static void main(String[] args){
		String string1 = "";
		Random gerador = new Random();
		gerador.setSeed(4);
		System.out.printls((char)('a' + (Math.abs(gerador.nextInt()) % 26)));	
	}
}
