import java.util.*;

public class Ex11{
	public static int compara(String str1, String str2){ // Metodo para realizar as comparações
        	int aux = 1;

        	if(str1.length() != str2.length()){
            		aux = 0; // se os tamanhos são diferentes = false
        	} else {
            		for(int i = 0; i < str1.length(); i++){
                		if(str1.charAt(i) != str2.charAt(i)){
                    			aux = 0; // Se os caracteres nas mesmas posições são diferentes = false
                   			 i = str1.length(); // para o for
                		}
            		}
        	}

        	return aux;
    	}

	public static String inverte(String str, int pos) {
    		if (pos >= str.length()) { // Se chega no final da string, para
        		return "";
    		}

    		return inverte(str, pos + 1) + str.charAt(pos); // chama para a proxima posição da string e concatena
}

	public static void main(String[] args){
		String str1 = MyIO.readLine();
		String str2 = "";
		
		while(compara(str1,"FIM") == 0){
			str2 = inverte(str1,0);
			MyIO.println(str2);
			str1 = MyIO.readLine();
		}
	}

}
