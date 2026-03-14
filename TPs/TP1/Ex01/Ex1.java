public class Ex1 {

    public static String cifra(String str1){ // metodo cifra
    	String resp = ""; // string para ser retornada

    	for(int i = 0; i < str1.length(); i++){
        	char c = str1.charAt(i);
		resp += (char)(str1.charAt(i) + 3); // atribuição com casting ( estava retornando int antes)
   	 }

   	 return resp;
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
	
	//declarando as strings    
        String str1;
        String str2 = "";

        str1 = MyIO.readLine();

        while(compara(str1,"FIM") == 0){ // While para enquanto strings sao diferentes de FIM
            str2 = cifra(str1); // cifro
            System.out.println(str2); // printo
            str1 = MyIO.readLine(); // escaneio a proxima string
        }
    }
}

