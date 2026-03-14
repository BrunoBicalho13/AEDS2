import java.util.*;

public class Ex03{
	public static boolean vogais(String str) {
    		for (int i = 0; i < str.length(); i++) {
        		char c = str.charAt(i);

        		if (!(c=='A'||c=='E'||c=='I'||c=='O'||c=='U'||c=='a'||c=='e'||c=='i'||c=='o'||c=='u')) { // Se não for vogal retorna falso
            			return false;
        		}
    		}
   		 return true;
	}
	
	public static boolean consoantes(String str){

    for (int i = 0; i < str.length(); i++){

        char c = str.charAt(i);

        // Verifica se é letra
        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {

            // verifica se é vogal
            if (c=='A'||c=='E'||c=='I'||c=='O'||c=='U'|| c=='a'||c=='e'||c=='i'||c=='o'||c=='u') {

                return false; // Se é vogal retornamos false
            }

        } else {
            return false; // Se nao for letra retornamos false
        }
    }

    return true;
}


	public static boolean inteiro(String str){
    		for(int i = 0; i < str.length(); i++){
        		if(!(str.charAt(i) >= 48 && str.charAt(i) <= 57)){ // Se não está entre essas posições da ASCII retorna falso
           			 return false;
        		}
    		}
    		return true;
	}

	public static boolean real(String str){
 	   	int separador = 0;

    		for(int i = 0; i < str.length(); i++){

        		char c = str.charAt(i);

       			 if(c >= '0' && c <= '9'){
            		// número válido
        		}
        		else if(c == '.' || c == ','){
            			separador++;
            			if(separador > 1){
                			return false;
            			}
       		 	} else{
           		 	return false;
        		}
   		 }

    		return true;
	}

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



	public static void main(String[] args){
		String str = "";

		str = MyIO.readLine();

		while(compara(str,"FIM")  == 0){
			String str1 = ""; // Declarando strings para atribuir SIM ou NAO dependendo do resultado booleano
			String str2 = "";
			String str3 = "";
			String str4 = "";
			
			boolean X1 = vogais(str);
			if (X1 == true){
				str1 = "SIM";
			}else{
				str1 = "NÃO";
			}


			boolean X2 = consoantes(str);
			if (X2 == true){
                                str2 = "SIM";
                        }else{
                                str2 = "NÃO";
                        }

		
			boolean X3 = inteiro(str);
			if (X3  == true){
                                str3 = "SIM";
                        }else{
                                str3 = "NÃO";
                        }

			boolean X4 = real(str);
			if (X4 == true){
                                str4 = "SIM";
                        }else{
                                str4 = "NÃO";
                        }

			System.out.println(str1 + " " + str2 + " " + str3 + " " + str4); // Saida com as strings SIM ou NÃO  

			str = MyIO.readLine();
		
		}
	}
}
