import java.util.*;

public class Ex08{

	public static boolean validaString(String str){
		int contaMaiuscula = 0, contaMinuscula = 0, contaNumero = 0, contaEspecial = 0; //inicializa meus contadores
	
		if(str.length() >= 8){
			for(int i = 0; i < str.length(); i++){
				int c = str.charAt(i); // colocar o caracter em uma variaval c para facilitar as comparações
				if ( c >= 'A' && c <= 'Z'){
					contaMaiuscula++; // se for letra maiscula, conta
           			}
                                if( c >= 'a' && c <= 'z'){
                                        contaMinuscula++;// se for letra minuscula, conta
                                }

                                if (c >= '0' && c<= '9'){
                                        contaNumero++;// se for numero, conta
                                }

                                if( (c >= 32 && c <= 47) || (c >= 58 && c <= 64) || ( c >= 91 && c <= 96) || (c >= 123 && c <= 126)){
                                        contaEspecial++;//se for numero,conta
                                }

                        }
                }

                if(contaMaiuscula > 0 && contaMinuscula > 0 && contaNumero > 0 && contaEspecial >0){
                        return true; // Se houver pelo menos um de cada, retorna true
                }else{
                        return false; 
      		}
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
	   //declarando a string    
     	   String str;
	   Scanner sc = new Scanner(System.in);			
           str = sc.nextLine();
	   boolean Valida;
           while(compara(str,"FIM") == 0){ // While para enquanto strings sao diferentes de FIM
            	Valida = validaString(str);
            	
		if(Valida == true){
			System.out.println("SIM");
		}else{
			System.out.println("NAO");
		}

            	str = sc.nextLine(); // escaneio a proxima string
        }
    }
	
	
}
