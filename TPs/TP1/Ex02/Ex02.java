import java.util.*;

public class Ex02{
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


	public static String random(String str, Random gerador){
		char letra1 = ((char) ('a' + (Math.abs(gerador.nextInt()) % 26)));
		char letra2 = ((char) ('a' + (Math.abs(gerador.nextInt()) % 26)));
		//pega as letras aleatorias
		String resp = "";
		for(int i = 0; i < str.length(); i++){
			//Anda caracter por caracter se achar a letra sorteada
			//ele troca, se não continua escrevendo
			if(str.charAt(i) == letra1){
				resp += letra2;
			}else{
				resp += str.charAt(i);
			}
		}
		// Retorna a string nova
		return resp;
	}

	public static void main(String[] args){

		Random gerador = new Random();
		gerador.setSeed(4);

		String str1 = MyIO.readLine();
		String resp = "";
		while(compara(str1,"FIM") == 0){ // Chamada da função mandando str e FIM
			resp = random(str1, gerador);
			MyIO.println(resp);
			str1 = MyIO.readLine();
		}
	}
}








	
